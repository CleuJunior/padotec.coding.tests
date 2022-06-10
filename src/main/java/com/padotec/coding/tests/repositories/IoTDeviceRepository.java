package com.padotec.coding.tests.repositories;

import com.padotec.coding.tests.entities.IoTDevice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IoTDeviceRepository extends JpaRepository<IoTDevice, Long> {
}
