package com.example.java_examples.suppliers;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class SupplierExample {

    public SupplierExample() { }

    /*
     * This methods tests if documentsReference.get() is called before the get() is called from
     * the SupplierContainer::getDocumentNames
     */
    public SupplierContainer getDocumentsReference() {
        DocumentService documentService = new DocumentService();

        Supplier<List<Document>> documentsReference = () -> documentService.getDocuments();

        System.out.printf("SupplierExample -> execute documentsReference \n");
        Supplier<List<String>> newList = () -> documentsReference.get().stream()
                .map(Document::getNaam)
                .collect(Collectors.toList());

        return new SupplierContainer(newList);
    }
}
