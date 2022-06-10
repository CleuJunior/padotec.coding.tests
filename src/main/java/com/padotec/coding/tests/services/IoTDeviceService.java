package com.padotec.coding.tests.services;

import com.padotec.coding.tests.dto.IoTDeviceDTO;
import com.padotec.coding.tests.entities.IoTDevice;
import com.padotec.coding.tests.repositories.IoTDeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IoTDeviceService {

    IoTDeviceRepository iotDeviceRepository;

    @Autowired
    public IoTDeviceService(IoTDeviceRepository iotDeviceRepository) {
        this.iotDeviceRepository = iotDeviceRepository;
    }

    public IoTDevice insertIoT(IoTDevice iotDevice) {
        return this.iotDeviceRepository.save(iotDevice);
    }

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
