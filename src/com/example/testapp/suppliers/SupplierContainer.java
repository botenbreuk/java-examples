package com.example.testapp.suppliers;

import java.util.List;
import java.util.function.Supplier;

public class SupplierContainer {

    private Supplier<List<String>> documentNames;

    public SupplierContainer(Supplier<List<String>> documentNames) {
        this.documentNames = documentNames;
    }

    public Supplier<List<String>> getDocumentNames() {
        return documentNames;
    }
}
