package com.padotec.coding.tests.producers;

import com.padotec.coding.tests.configs.broker.RabbitMQConfig;
import com.padotec.coding.tests.dto.request.IoTDeviceRequest;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class IoTProducer {
    private final RabbitTemplate template;

    @Value(value = RabbitMQConfig.ROUTING_KEY)
    private String routingKey;

    public IoTProducer(RabbitTemplate template) {
        this.template = template;
    }

    public void publisIoTDevice(IoTDeviceRequest request) {
        System.out.println("Cheguei aqui");
    }

}
