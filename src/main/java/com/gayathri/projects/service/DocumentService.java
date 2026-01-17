package com.gayathri.projects.service;


import com.gayathri.projects.entity.ConfidentialityLevel;
import com.gayathri.projects.entity.DocumentEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface DocumentService
        {
            DocumentEntity createDocument(DocumentEntity document);
            DocumentEntity updateConfidentiality(String id, ConfidentialityLevel level);

            Optional<DocumentEntity> getDocumentById(String id);
            Optional<DocumentEntity> getDocumentByNumber(String documentNumber);

            List<DocumentEntity> getAllDocuments();
            void deleteDocument(String id);

            ConfidentialityLevel getConfidentialityById(String id);
            List<DocumentEntity> getDocumentsByConfidentiality(ConfidentialityLevel level);

        }