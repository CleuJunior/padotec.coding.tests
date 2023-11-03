package br.com.cleonildo.dto.request;


public class IoTDeviceRequest {

    private String name;
    private String mac;
    private String email;
    private Double latitude;
    private Double longitude;

    public IoTDeviceRequest() {
    }

    public IoTDeviceRequest(String name, String mac, String email, Double latitude, Double longitude) {
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
