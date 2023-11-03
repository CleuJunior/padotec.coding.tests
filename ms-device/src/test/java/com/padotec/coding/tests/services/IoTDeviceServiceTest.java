package com.padotec.coding.tests.services;

import com.padotec.coding.tests.dto.request.IoTDeviceRequest;
import com.padotec.coding.tests.dto.response.IoTDeviceResponse;
import com.padotec.coding.tests.entities.IoTDevice;
import com.padotec.coding.tests.repositories.IoTDeviceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class IoTDeviceServiceTest {
    private static final long DEVICE_ID = 1L;
    private static final String NAME = "Laboratório";
    private static final String MAC = "B7-92-EE-8F-34-AA";
    private static final String EMAIL = "laboratorio@gmail.com";
    private static final double LATITUDE = 9989.98;
    private static final double LONGITUDE = 7758.99;
    private IoTDeviceRepository repository;
    private IoTDeviceService service;
    private IoTDevice device;

    @BeforeEach
    void setup() {
        // Given / Arrange
        this.repository = mock(IoTDeviceRepository.class);
        this.service = new IoTDeviceService(repository, new ModelMapper());
        this.device = new IoTDevice(DEVICE_ID, NAME, MAC, EMAIL, LATITUDE, LONGITUDE);
    }

    @DisplayName("Return the list of IoTDevices")
    @Test
    void givenIoTDeviceRepository_whenFindAllDevices_thenReturnIoTDeviceResponsesList() {
        when(repository.findAll()).thenReturn(singletonList(device));

        List<IoTDeviceResponse> actual = this.service.findAllDevice();

        assertNotNull(actual);
        assertInstanceOf(IoTDeviceResponse.class, actual.get(0));
        assertEquals(1, actual.size());
        this.basicAssertions(actual.get(0));

        verify(repository, times(1)).findAll();
    }

    @DisplayName("Return an empty list of IoTDevices")
    @Test
    void givenIoTDeviceRepository_whenFindAllDevices_thenReturnEmptyList() {
        when(repository.findAll()).thenReturn(List.of());

        List<IoTDeviceResponse> actual = this.service.findAllDevice();

        assertNotNull(actual);
        assertEquals(0, actual.size());
        verify(repository, times(1)).findAll();
    }

    @DisplayName("Return the Device with specific ID")
    @Test
    void givenIoTDeviceRepository_whenFindDeviceById_thenReturnDevice() {
        when(repository.findById(anyLong())).thenReturn(Optional.ofNullable(device));

        IoTDeviceResponse expected = new IoTDeviceResponse(device);
        IoTDeviceResponse actual = this.service.findDeviceById(DEVICE_ID);

        assertNotNull(actual);
        assertEquals(expected.getDeviceId(), actual.getDeviceId());
        assertEquals(expected.getEmail(), actual.getEmail());

        verify(repository, times(1)).findById(anyLong());
    }

    @DisplayName("Throw ResourceNotFoundException when ID not found")
    @Test
    void givenIoTDeviceRepository_whenFindDeviceByIdNonExisting_thenThrowResourceNotFoundException() {
        when(repository.findById(anyLong())).thenReturn(Optional.empty());


        assertThrows(ResourceNotFoundException.class, () -> this.service.findDeviceById(DEVICE_ID));
        verify(repository, times(1)).findById(anyLong());
    }

    @DisplayName("Insert a device")
    @Test
    void givenIoTDeviceRepository_whenInsertIoT_thenReturnDevice() {
        when(repository.save(any(IoTDevice.class))).thenReturn(device);

        IoTDeviceResponse expected = this.service.insertIoT(new IoTDeviceRequest());
        IoTDeviceResponse actual = new IoTDeviceResponse(device);

        assertNotNull(actual);
        assertEquals(expected.getDeviceId(), actual.getDeviceId());
        assertEquals(expected.getEmail(), actual.getEmail());

        verify(repository, times(1)).save(any(IoTDevice.class));
    }

    @DisplayName("Insert a single list of devices")
    @Test
    void givenIoTDeviceRepository_whenInsertListIoT_thenReturnListDevice() {
        List<IoTDeviceRequest> singleListRequest = singletonList(new IoTDeviceRequest());

        when(repository.saveAll(anyList())).thenReturn(singletonList(device));

        List<IoTDeviceResponse> actual = this.service.insertListIoT(singleListRequest);

        assertNotNull(actual);
        assertEquals(1,  actual.size());
        this.basicAssertions(actual.get(0));

        verify(repository, times(1)).saveAll(anyList());
    }

    private void basicAssertions(IoTDeviceResponse response) {
        assertEquals(DEVICE_ID, response.getDeviceId());
        assertEquals(NAME, response.getName());
        assertEquals(MAC, response.getMac());
        assertEquals(EMAIL, response.getEmail());
        assertEquals(LATITUDE, response.getLatitude());
        assertEquals(LONGITUDE, response.getLongitude());
    }

}