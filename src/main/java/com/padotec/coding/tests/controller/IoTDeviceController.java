package com.padotec.coding.tests.controller;

import com.padotec.coding.tests.dto.IoTDeviceDTO;
import com.padotec.coding.tests.entities.IoTDevice;
import com.padotec.coding.tests.json.IoTDevicePostJson;
import com.padotec.coding.tests.services.IoTDeviceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/")
public class IoTDeviceController {

    IoTDeviceService iotDeviceService;

    public IoTDeviceController(IoTDeviceService iotDeviceService) {
        this.iotDeviceService = iotDeviceService;
    }


    @PostMapping(value = "/registrar")
    public ResponseEntity<IoTDevicePostJson> insertIoT(@RequestBody IoTDeviceDTO iotDeviceDTO) {

        IoTDevice iotDevice = this.iotDeviceService.fromDTOToIoT(iotDeviceDTO);
        this.iotDeviceService.insertIoT(iotDevice);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(iotDevice)
                .toUri();

        return ResponseEntity.created(uri)
                .body(new IoTDevicePostJson(iotDevice));

    }

    @GetMapping(value = "/listar")
    public ResponseEntity<List<IoTDeviceDTO>> findAllDevices() {
        List<IoTDevice> iotDevices = this.iotDeviceService.findAllDevice();

        return ResponseEntity.ok(iotDevices.stream()
                .map(IoTDeviceDTO::new)
                .collect(java.util.stream.Collectors.toList()));

    }
}
