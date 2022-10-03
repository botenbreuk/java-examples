package nl.rdb.java_examples.suppliers;

import java.util.List;
import java.util.function.Supplier;

public record SupplierContainer(Supplier<List<String>> documentNames) {
}
