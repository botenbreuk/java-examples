package nl.rdb.java_examples.csv;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {

    public List<Object> read(File appImport) {
        //        CsvMapper csvMapper = new CsvMapper();
        //        JavaTimeModule module = new JavaTimeModule();
        //        LocalDateTimeDeserializer localDateTimeDeserializer = new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss"));
        //        module.addDeserializer(LocalDateTime.class, localDateTimeDeserializer);
        //        csvMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        //                .configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true)
        //                .configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true)
        //                .registerModule(module)
        //                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        //    CsvSchema schema = CsvSchema.emptySchema().withColumnSeparator(';').withoutEscapeChar().withHeader();
        //
        //    ObjectReader oReader = csvMapper.readerFor(ApplicatieImportCsvLine.class).with(schema);
        List<Object> csvLines = new ArrayList<>();
        //
        //        try(
        //    Reader appImportStream = new FileReader(appImport)) {
        //        MappingIterator<ApplicatieImportCsvLine> mi = oReader.readValues(appImportStream);
        //
        //        while (mi.hasNext()) {
        //            ApplicatieImportCsvLine current = mi.next();
        //            csvLines.add(current);
        //        }
        //
        //        LOGGER.info("ApplicatieImport > Read {} CSV lines.", csvLines.size());
        //    } catch (Exception e) {
        //        LOGGER.error("ApplicatieImport > Failed to read lines from file.", e);
        //    }
        //
        return csvLines;
    }
}
