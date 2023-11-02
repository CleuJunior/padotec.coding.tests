package com.padotec.coding.tests.dto.response;

import com.padotec.coding.tests.entities.IoTDevice;

public class IoTDeviceResponse {
    private final Long deviceId;
    private final String name;
    private final String mac;
    private final String email;
    private final Double latitude;
    private final Double longitude;

    private IoTDeviceResponse(IoTDevice ioTDevice) {
        this.deviceId = ioTDevice.getDeviceId();
        this.name = ioTDevice.getName();
        this.mac = ioTDevice.getMac();
        this.email = ioTDevice.getEmail();
        this.latitude = ioTDevice.getLatitude();
        this.longitude = ioTDevice.getLongitude();
    }

    public static IoTDeviceResponse of(IoTDevice ioTDevice) {
        return new IoTDeviceResponse(ioTDevice);
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public String getName() {
        return name;
    }

    public String getMac() {
        return mac;
    }

    public String getEmail() {
        return email;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }
}
