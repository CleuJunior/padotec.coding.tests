package com.padotec.coding.tests.dto;


import com.padotec.coding.tests.entities.IoTDevice;

public class IoTDevicePostDTO {

    private Long deviceId;
    private String mac;

    public IoTDevicePostDTO() { }

    public IoTDevicePostDTO(IoTDevice ioTDevice) {
        this.deviceId = ioTDevice.getDeviceId();
        this.mac = ioTDevice.getMac();

    }

    public Long getDeviceId() { return deviceId; }

    public String getMac() { return mac; }

    public void setDeviceId(Long deviceId) { this.deviceId = deviceId; }

    public void setMac(String mac) { this.mac = mac; }
}
