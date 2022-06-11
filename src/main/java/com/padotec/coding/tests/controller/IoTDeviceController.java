package com.padotec.coding.tests.controller;

import com.padotec.coding.tests.configs.RabbitMQConfig;
import com.padotec.coding.tests.dto.IoTDeviceDTO;
import com.padotec.coding.tests.dto.IoTDeviceListPostDTO;
import com.padotec.coding.tests.dto.IoTDevicePostDTO;
import com.padotec.coding.tests.entities.IoTDevice;
import com.padotec.coding.tests.services.IoTDeviceService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class IoTDeviceController {

    private final IoTDeviceService iotDeviceService;
    private final AmqpTemplate amqpTemplate;

    @Autowired
    public IoTDeviceController(IoTDeviceService iotDeviceService, AmqpTemplate amqpTemplate) {
        this.iotDeviceService = iotDeviceService;
        this.amqpTemplate = amqpTemplate;
    }

    @GetMapping(value = "/listar")
    public ResponseEntity<List<IoTDeviceDTO>> findAllDevices() {
        List<IoTDevice> iotDevices = this.iotDeviceService.findAllDevice();

        return ResponseEntity.ok()
                .body(iotDevices.stream()
                        .map(IoTDeviceDTO::new)
                        .collect(java.util.stream.Collectors.toList()));

    }

    @GetMapping(value = "/listar/{deviceId}")
    public ResponseEntity<IoTDeviceDTO> findDevicesById(@PathVariable Long deviceId) {
        IoTDevice iotDevice = this.iotDeviceService.findDeviceById(deviceId);

        IoTDeviceDTO iotDeviceDTO = new IoTDeviceDTO(iotDevice);

        return ResponseEntity.ok().body(iotDeviceDTO);

    }

    @PostMapping(value = "/registrar")
    public ResponseEntity<IoTDevicePostDTO> insertIoT(@RequestBody IoTDeviceDTO iotDeviceDTO) {

        IoTDevice iotDevice = this.iotDeviceService.fromDTOToIoT(iotDeviceDTO);
        this.iotDeviceService.insertIoT(iotDevice);

        return ResponseEntity.accepted()
                .body(new IoTDevicePostDTO(iotDevice));

    }

    @PostMapping(value = "/registrar/async")
    public ResponseEntity<List<IoTDeviceListPostDTO>> insertIoTList(@RequestBody List<IoTDeviceDTO> iotDevicesDTO) {

        List<IoTDevice> iotDevices = iotDevicesDTO.stream()
                .map(this.iotDeviceService::fromDTOToIoT)
                .collect(java.util.stream.Collectors.toList());

        List<IoTDeviceListPostDTO> iotDeviceListPostDTOS = iotDevices.stream()
                .map(IoTDeviceListPostDTO::new)
                .collect(java.util.stream.Collectors.toList());

        this.iotDeviceService.insertListIoT(iotDevices);

        this.amqpTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, RabbitMQConfig.ROUTING_KEY, iotDevices);

        return ResponseEntity.accepted()
                .body(iotDeviceListPostDTOS);

    }

}
