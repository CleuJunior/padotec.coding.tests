package com.padotec.coding.tests.consumer;

import com.padotec.coding.tests.dto.request.IoTDeviceRequest;
import com.padotec.coding.tests.services.IoTDeviceService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class IoTDeviceConsumer {
    private final IoTDeviceService service;

    public IoTDeviceConsumer(IoTDeviceService service) {
        this.service = service;
    }

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void listenIoTDevice(@Payload List<IoTDeviceRequest> payload) {
        this.service.insertListIoT(payload);
    }
}
