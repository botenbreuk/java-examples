package com.example.testapp.suppliers;

import java.util.Arrays;
import java.util.List;

public class DocumentService {

    public DocumentService() {}

    public List<Document> getDocuments() {
        System.out.println("Execution DocumentService::getDocuments \n");
        return Arrays.asList(new Document("Doc1"), new Document("Doc2"));
    }
}
