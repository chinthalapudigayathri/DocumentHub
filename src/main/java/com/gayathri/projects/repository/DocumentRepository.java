package com.gayathri.projects.repository;


import com.gayathri.projects.entity.DocumentEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

/* we create an interface here as spring Data generates methods on its own
interface in repository is always public because spring Data interacts with it
 */
public interface DocumentRepository extends MongoRepository<DocumentEntity,String>
{

    /*we use optional class here to avoid null pointer exception
    * we are telling spring data to create a findbydocumentNumber and search using documentNumber againstData
    * using documentEntity and return empty if there is no data
     */
    Optional<DocumentEntity>  findByDocumentNumber(String documentNumber);
}