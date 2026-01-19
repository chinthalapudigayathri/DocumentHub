package com.gayathri.projects.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaEventProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaEventProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishDocumentCreated(String documentId) {
        kafkaTemplate.send("document-events", "Document created: " + documentId);
    }

    public void publishDocumentDeleted(String documentId) {
        kafkaTemplate.send("document-events", "Document deleted: " + documentId);
    }
}