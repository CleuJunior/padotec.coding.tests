package br.com.cleonildo.producers;

import br.com.cleonildo.configs.broker.RabbitMQConfig;
import br.com.cleonildo.dto.request.IoTDeviceRequest;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class IoTProducer {
    private final RabbitTemplate template;

    @Value(value = RabbitMQConfig.ROUTING_KEY)
    private String routingKey;

    public IoTProducer(RabbitTemplate template) {
        this.template = template;
    }

    public void publisIoTDevice(List<IoTDeviceRequest> request) {
        this.template.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, RabbitMQConfig.ROUTING_KEY, request);
    }

}
