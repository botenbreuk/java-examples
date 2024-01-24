package nl.rdb.java_examples.suppliers;

import java.util.List;
import java.util.function.Supplier;

import lombok.extern.slf4j.Slf4j;
import nl.rdb.java_examples.scanner.Example;

@Slf4j
public class SupplierExample {

    /*
     * These methods test if documentsReference.get() is called before the get() is called from
     * the SupplierContainer::getDocumentNames
     */
    public SupplierContainer getDocumentsReference() {
        DocumentService documentService = new DocumentService();

        Supplier<List<Document>> documentsReference = documentService::getDocuments;

        log.info("SupplierExample -> execute documentsReference");
        Supplier<List<String>> newList = () -> documentsReference.get().stream()
                .map(Document::getNaam)
                .toList();

        return new SupplierContainer(newList);
    }

    @Example
    void supplierExample() {
        SupplierExample supplierExample = new SupplierExample();

        List<String> stringList = supplierExample.getDocumentsReference().documentNames().get();
        log.info("Stringlist size: " + stringList.size());
    }
}
