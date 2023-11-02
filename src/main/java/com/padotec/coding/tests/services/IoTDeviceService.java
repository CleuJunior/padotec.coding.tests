package com.padotec.coding.tests.services;

import com.padotec.coding.tests.dto.request.IoTDeviceListRequest;
import com.padotec.coding.tests.dto.response.IoTDeviceResponse;
import com.padotec.coding.tests.entities.IoTDevice;
import com.padotec.coding.tests.repositories.IoTDeviceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IoTDeviceService {
    private final IoTDeviceRepository iotDeviceRepository;

    public IoTDeviceService(IoTDeviceRepository iotDeviceRepository) {
        this.iotDeviceRepository = iotDeviceRepository;
    }

    public List<IoTDeviceResponse> findAllDevice() {
        return this.iotDeviceRepository
                .findAll()
                .stream()
                .map(IoTDeviceResponse::of)
                .collect(Collectors.toList());
    }

    public IoTDeviceResponse findDeviceById(Long id) {
        IoTDevice device =  this.iotDeviceRepository.findById(id).orElseThrow();

        return IoTDeviceResponse.of(device);
    }

    public IoTDeviceResponse insertIoT(IoTDeviceListRequest request) {
        IoTDevice diveceFromRequest = this.fromRequest(request);
        IoTDevice response = this.iotDeviceRepository.save(diveceFromRequest);

        return IoTDeviceResponse.of(response);
    }

    public void insertListIoT(List<IoTDeviceListRequest> requests) {
        List<IoTDevice> devices = requests.
                stream()
                .map(this::fromRequest)
                .collect(Collectors.toList());

        this.iotDeviceRepository.saveAll(devices);
    }

    private IoTDevice fromRequest(IoTDeviceListRequest ioTDeviceResponse) {
        return new IoTDevice(
                ioTDeviceResponse.getName(),
                ioTDeviceResponse.getMac(),
                ioTDeviceResponse.getEmail(),
                ioTDeviceResponse.getLatitude(),
                ioTDeviceResponse.getLongitude()
        );
    }

}
