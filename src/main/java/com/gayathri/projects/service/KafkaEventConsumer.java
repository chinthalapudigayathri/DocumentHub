package com.gayathri.projects.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaEventConsumer {

    @KafkaListener(topics = "document-events", groupId = "documenthub-group")
    public void listen(String message) {
        System.out.println("Received Kafka event: " + message);
        // Later: push to ELK, trigger notifications, etc.
    }
}