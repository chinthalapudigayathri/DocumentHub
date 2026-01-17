package com.gayathri.projects.service;

import com.gayathri.projects.entity.ConfidentialityLevel;
import com.gayathri.projects.entity.DocumentEntity;
import com.gayathri.projects.repository.DocumentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DocumentServiceImpl implements DocumentService
{
    /*creates a Repository call from Service by declaring this
    * We make it private so that no other class can reach repository layer and interact with Data
     */
    private final DocumentRepository documentRepository;
    /* Creating constructor to call repository*/
    public DocumentServiceImpl(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    /*All other methods are public because they implement methods in public interface */
    @Override
    public DocumentEntity createDocument(DocumentEntity document)
    {
        document.setUpdatedAt(LocalDateTime.now());
        if(document.getConfidential()==null)
        {
            document.setConfidential(ConfidentialityLevel.Non_Confidential);
        }

        return documentRepository.save(document);

    }

    @Override
    public DocumentEntity updateConfidentiality(String id, ConfidentialityLevel level)
    {
        DocumentEntity document = documentRepository.findById(id).orElseThrow(() -> new RuntimeException("document Not found"));
        document.setConfidential(level);
        document.setUpdatedAt(LocalDateTime.now());
        return documentRepository.save(document);

    }

    @Override
    public ConfidentialityLevel getConfidentialityById(String id)
    {
        /* We are using streams here streams is like a pipeline that sends data from collections */
        return documentRepository.findById(id).map(DocumentEntity::getConfidential).orElseThrow(() -> new RuntimeException("confidentiality not found"));

    }

    @Override
    public List<DocumentEntity> getDocumentsByConfidentiality(ConfidentialityLevel level) {
        return documentRepository.findAll().stream().filter(doc -> doc.getConfidential() == level).collect(Collectors.toList());
    }


    @Override
    public Optional<DocumentEntity> getDocumentById(String id) {
        return documentRepository.findById(id);
    }

    @Override
    public Optional<DocumentEntity> getDocumentByNumber(String documentNumber) {
        return documentRepository.findByDocumentNumber(documentNumber);
    }

    @Override
    public List<DocumentEntity> getAllDocuments() {
        return documentRepository.findAll();
    }

    @Override
    public void deleteDocument(String id) {
        documentRepository.deleteById(id);
    }


}