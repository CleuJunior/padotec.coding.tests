package com.padotec.coding.tests.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "iot_device")
public class IoTDevice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long deviceId;
     private String name;
     private String mac;
     private String email;
     private Double latitude;
     private Double longitude;

     public IoTDevice() { }

    public IoTDevice(Long deviceId, String name, String mac, String email, Double latitude, Double longitude) {
        this.deviceId = deviceId;
        this.name = name;
        this.mac = mac;
        this.email = email;
        this.latitude = latitude;
        this.longitude = longitude;
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