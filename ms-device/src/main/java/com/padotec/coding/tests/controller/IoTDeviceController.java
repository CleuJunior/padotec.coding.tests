package com.padotec.coding.tests.controller;

import com.padotec.coding.tests.configs.broker.RabbitMQConfig;
import com.padotec.coding.tests.dto.request.IoTDeviceRequest;
import com.padotec.coding.tests.dto.response.IoTDeviceResponse;
import com.padotec.coding.tests.services.IoTDeviceService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class IoTDeviceController {
    private final IoTDeviceService iotDeviceService;
    private final AmqpTemplate amqpTemplate;

    public IoTDeviceController(IoTDeviceService iotDeviceService, AmqpTemplate amqpTemplate) {
        this.iotDeviceService = iotDeviceService;
        this.amqpTemplate = amqpTemplate;
    }

    @GetMapping
    public ResponseEntity<List<IoTDeviceResponse>> findAllDevices() {
        List<IoTDeviceResponse> responses = this.iotDeviceService.findAllDevice();

        return ResponseEntity.ok().body(responses);
    }

    @GetMapping(value = "/{deviceId}")
    public ResponseEntity<IoTDeviceResponse> findDevicesById(@PathVariable Long deviceId) {
        IoTDeviceResponse response = this.iotDeviceService.findDeviceById(deviceId);

        return ResponseEntity.ok().body(response);
    }

    @PostMapping
    public ResponseEntity<Map<String, URI>> insertIoT(@RequestBody IoTDeviceRequest request) {
        IoTDeviceResponse response = this.iotDeviceService.insertIoT(request);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.getDeviceId())
                .toUri();

        Map<String, URI> responseMap = Map.of("device", uri);

        return ResponseEntity.created(uri).body(responseMap);
    }

    @PostMapping(value = "/async")
    public ResponseEntity<Map<String, String>> insertIoTList(@RequestBody List<IoTDeviceRequest> requests) {
        this.amqpTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, RabbitMQConfig.ROUTING_KEY, requests);

        return ResponseEntity.accepted().body(Map.of("devices", "accepted"));
    }
}
