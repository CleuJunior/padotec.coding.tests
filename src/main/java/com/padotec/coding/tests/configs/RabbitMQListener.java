package com.padotec.coding.tests.configs;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class RabbitMQListener implements MessageListener {

    @Override
    public void onMessage(Message message) {
        System.out.println("Received message: " + Arrays.toString(message.getBody()));
    }

}
