package com.padotec.coding.tests.json;


import com.padotec.coding.tests.entities.IoTDevice;

public class IoTDevicePostJson {

    private Long deviceId;
    private String mac;

    public IoTDevicePostJson() { }

    public IoTDevicePostJson(IoTDevice ioTDevice) {
        this.deviceId = ioTDevice.getDeviceId();
        this.mac = ioTDevice.getMac();

    }

    public Long getDeviceId() { return deviceId; }

    public String getMac() { return mac; }

    public void setDeviceId(Long deviceId) { this.deviceId = deviceId; }

    public void setMac(String mac) { this.mac = mac; }
}
