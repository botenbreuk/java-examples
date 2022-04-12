package nl.rdb.java_examples.suppliers;

import java.util.Arrays;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DocumentService {

    public List<Document> getDocuments() {
        log.info("Execution DocumentService::getDocuments \n");
        return Arrays.asList(new Document("Doc1"), new Document("Doc2"));
    }
}
