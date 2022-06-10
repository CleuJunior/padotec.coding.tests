package com.padotec.coding.tests.dto;

import com.padotec.coding.tests.entities.IoTDevice;

public class IoTDeviceDTO {

    private Long deviceId;
    private String name;
    private String mac;
    private String email;
    private Double latitude;
    private Double longitude;

    public IoTDeviceDTO() { }

    public IoTDeviceDTO(IoTDevice ioTDevice) {
        this.deviceId = ioTDevice.getDeviceId();
        this.name = ioTDevice.getName();
        this.mac = ioTDevice.getMac();
        this.email = ioTDevice.getEmail();
        this.latitude = ioTDevice.getLatitude();
        this.longitude = ioTDevice.getLongitude();
    }

    public Long getDeviceId() { return deviceId; }

    public String getName() { return name; }

    public String getMac() { return mac; }

    public String getEmail() { return email; }

    public Double getLatitude() { return latitude; }

    public Double getLongitude() { return longitude; }

    public void setDeviceId(Long deviceId) { this.deviceId = deviceId; }

    public void setName(String name) { this.name = name; }

    public void setMac(String mac) { this.mac = mac; }

    public void setEmail(String email) { this.email = email; }

    public void setLatitude(Double latitude) { this.latitude = latitude; }

    public void setLongitude(Double longitude) { this.longitude = longitude; }
}
