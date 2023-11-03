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

    public IoTDeviceListRequest(String name, String mac, String email, Double latitude, Double longitude) {
        this.name = name;
        this.mac = mac;
        this.email = email;
        this.latitude = latitude;
        this.longitude = longitude;
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
