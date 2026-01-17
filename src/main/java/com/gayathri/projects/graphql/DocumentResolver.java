package com.gayathri.projects.graphql;

import com.gayathri.projects.entity.ConfidentialityLevel;
import com.gayathri.projects.entity.DocumentEntity;
import com.gayathri.projects.service.DocumentService;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class DocumentResolver
{
    private final DocumentService documentService;

    public DocumentResolver(DocumentService documentService) {
        this.documentService = documentService;
    }

    // Queries
    public List<DocumentEntity> documents() {
        return documentService.getAllDocuments();
    }

    public DocumentEntity documentById(String id) {
        return documentService.getDocumentById(id).orElse(null);
    }

    public DocumentEntity documentByNumber(String documentNumber) {
        return documentService.getDocumentByNumber(documentNumber).orElse(null);
    }

    public List<DocumentEntity> documentsByConfidentiality(ConfidentialityLevel level) {
        return documentService.getDocumentsByConfidentiality(level);
    }

    // Mutations
    public DocumentEntity createDocument(String documentNumber, String title, String author) {
        DocumentEntity doc = new DocumentEntity();
        doc.setDocumentNumber(documentNumber);
        doc.setTitle(title);
        doc.setAuthor(author);
        return documentService.createDocument(doc);
    }

    public DocumentEntity updateConfidentiality(String id, ConfidentialityLevel level) {
        return documentService.updateConfidentiality(id, level);
    }

    public boolean deleteDocument(String id) {
        documentService.deleteDocument(id);
        return true;
    }

}