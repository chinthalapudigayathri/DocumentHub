package com.gayathri.projects.graphql;

import com.gayathri.projects.entity.ConfidentialityLevel;
import com.gayathri.projects.entity.DocumentEntity;
import com.gayathri.projects.service.DocumentService;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;


@Controller
public class DocumentResolver
{
    private final DocumentService documentService;

    public DocumentResolver(DocumentService documentService) {
        this.documentService = documentService;
    }

    // Queries
    @QueryMapping
    public List<DocumentEntity> documents() {
        return documentService.getAllDocuments();
    }

    @QueryMapping
    public DocumentEntity documentById(@Argument String id) {
        return documentService.getDocumentById(id).orElse(null);
    }

    @QueryMapping
    public DocumentEntity documentByNumber(@Argument String documentNumber) {
        return documentService.getDocumentByNumber(documentNumber).orElse(null);
    }

    @QueryMapping
    public List<DocumentEntity> documentsByConfidentiality(@Argument ConfidentialityLevel level) {
        return documentService.getDocumentsByConfidentiality(level);
    }

    // Mutations
    @MutationMapping
    public DocumentEntity createDocument(@Argument String documentNumber, @Argument String title, @Argument String author) {
        DocumentEntity doc = new DocumentEntity();
        doc.setDocumentNumber(documentNumber);
        doc.setTitle(title);
        doc.setAuthor(author);
        return documentService.createDocument(doc);
    }

    @MutationMapping
    public DocumentEntity updateConfidentiality(@Argument String id, @Argument ConfidentialityLevel level) {
        return documentService.updateConfidentiality(id, level);
    }

    @MutationMapping
    public boolean deleteDocument(String id) {
        documentService.deleteDocument(id);
        return true;
    }

}