package nl.rdb.java_examples.suppliers;

import java.util.List;
import java.util.function.Supplier;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SupplierExample {

    /*
     * This methods tests if documentsReference.get() is called before the get() is called from
     * the SupplierContainer::getDocumentNames
     */
    public SupplierContainer getDocumentsReference() {
        DocumentService documentService = new DocumentService();

        Supplier<List<Document>> documentsReference = documentService::getDocuments;

        log.info("SupplierExample -> execute documentsReference \n");
        Supplier<List<String>> newList = () -> documentsReference.get().stream()
                .map(Document::getNaam)
                .toList();

        return new SupplierContainer(newList);
    }
}
