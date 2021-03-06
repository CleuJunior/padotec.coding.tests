package com.padotec.coding.tests.services;

import com.padotec.coding.tests.dto.IoTDeviceDTO;
import com.padotec.coding.tests.entities.IoTDevice;
import com.padotec.coding.tests.repositories.IoTDeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IoTDeviceService {

    IoTDeviceRepository iotDeviceRepository;

    @Autowired
    public IoTDeviceService(IoTDeviceRepository iotDeviceRepository) { this.iotDeviceRepository = iotDeviceRepository; }

    public List<IoTDevice> findAllDevice() { return this.iotDeviceRepository.findAll(); }

    public IoTDevice findDeviceById(Long id) { return this.iotDeviceRepository.findById(id).orElseThrow(); }

    public void insertIoT(IoTDevice iotDevice) { this.iotDeviceRepository.save(iotDevice); }

    public void insertListIoT(List<IoTDevice> iotDevices) { this.iotDeviceRepository.saveAll(iotDevices); }

    public IoTDevice fromDTOToIoT(IoTDeviceDTO ioTDeviceDTO) {
        return new IoTDevice(

                ioTDeviceDTO.getDeviceId(),
                ioTDeviceDTO.getName(),
                ioTDeviceDTO.getMac(),
                ioTDeviceDTO.getEmail(),
                ioTDeviceDTO.getLatitude(),
                ioTDeviceDTO.getLongitude()

        );
    }

}
