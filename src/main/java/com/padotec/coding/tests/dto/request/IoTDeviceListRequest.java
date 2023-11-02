package com.padotec.coding.tests.dto.request;


import com.padotec.coding.tests.entities.IoTDevice;

public class IoTDeviceListRequest {

    private String name;
    private String mac;
    private String email;
    private Double latitude;
    private Double longitude;

    public IoTDeviceListRequest() {
    }

    public IoTDeviceListRequest(IoTDevice ioTDevice) {
        this.name = ioTDevice.getName();
        this.mac = ioTDevice.getMac();
        this.email = ioTDevice.getEmail();
        this.latitude = ioTDevice.getLatitude();
        this.longitude = ioTDevice.getLongitude();
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
