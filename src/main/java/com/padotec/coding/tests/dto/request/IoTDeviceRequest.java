package com.padotec.coding.tests.dto.request;


import com.padotec.coding.tests.entities.IoTDevice;

public class IoTDeviceRequest {
    private Long deviceId;
    private String mac;

    public IoTDeviceRequest() {
    }

    public IoTDeviceRequest(IoTDevice ioTDevice) {
        this.deviceId = ioTDevice.getDeviceId();
        this.mac = ioTDevice.getMac();
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public String getMac() {
        return mac;
    }
}
