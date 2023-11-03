package br.com.cleonildo.controller;

import br.com.cleonildo.dto.request.IoTDeviceRequest;
import br.com.cleonildo.producers.IoTProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class IoTDevicesController {
    private final IoTProducer producer;

    public IoTDevicesController(IoTProducer producer) {
        this.producer = producer;
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> insertIoTList(@RequestBody List<IoTDeviceRequest> requests) {
        this.producer.publisIoTDevice(requests);

        return ResponseEntity.accepted().body(Map.of("devices", "accepted"));
    }
}
