package com.gayathri.projects.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

/*generates constructors */
@AllArgsConstructor
@NoArgsConstructor
/* generates build patterns */
@Builder
/* generates getters and setters */
@Data
/* we define table="" in RDDMS and collection in MongoDB as in MongoDB data is stored as json like formats */
@Document(collection = "documents")
/* an entity class is always public because Database and spring Data JPa need to access it */
public class DocumentEntity
{
    /* to generate primary key */
    @Id
    private String id;

    /* fields in entity class are always private to protect the data */
    private String documentNumber;
    private String title;
    private String author;
    private List<String> accessors;
    private LocalDateTime updatedAt;
    private ConfidentialityLevel confidential;





}