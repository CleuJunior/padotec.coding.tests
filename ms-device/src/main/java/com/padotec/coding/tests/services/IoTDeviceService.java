package com.padotec.coding.tests.services;

import com.padotec.coding.tests.dto.request.IoTDeviceRequest;
import com.padotec.coding.tests.dto.response.IoTDeviceResponse;
import com.padotec.coding.tests.entities.IoTDevice;
import com.padotec.coding.tests.repositories.IoTDeviceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class IoTDeviceService {
    private final IoTDeviceRepository iotDeviceRepository;
    private final ModelMapper mapper;
    public static final String DEVICE_NOT_FOUND = "Device not found!";

    public IoTDeviceService(IoTDeviceRepository iotDeviceRepository, ModelMapper mapper) {
        this.iotDeviceRepository = iotDeviceRepository;
        this.mapper = mapper;
    }

    public List<IoTDeviceResponse> findAllDevice() {
        return this.iotDeviceRepository
                .findAll()
                .stream()
                .map(iot -> mapper.map(iot, IoTDeviceResponse.class))
                .collect(Collectors.toList());
    }

    public IoTDeviceResponse findDeviceById(Long id) {
        Optional<IoTDevice> device = this.iotDeviceRepository.findById(id);

        if (device.isEmpty())
            throw new ResourceNotFoundException(DEVICE_NOT_FOUND);

        return this.mapper.map(device.get(), IoTDeviceResponse.class);
    }

    public IoTDeviceResponse insertIoT(IoTDeviceRequest request) {
        IoTDevice diveceFromRequest = this.mapper.map(request, IoTDevice.class);
        IoTDevice response = this.iotDeviceRepository.save(diveceFromRequest);

        return this.mapper.map(response, IoTDeviceResponse.class);
    }

    public List<IoTDeviceResponse> insertListIoT(List<IoTDeviceRequest> requests) {
        List<IoTDevice> devices = requests
                .stream()
                .map(request -> mapper.map(request, IoTDevice.class))
                .collect(Collectors.toList());

        return this.iotDeviceRepository
                .saveAll(devices)
                .stream()
                .map(d -> mapper.map(d, IoTDeviceResponse.class))
                .collect(Collectors.toList());
    }
}
