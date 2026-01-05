package nl.rdb.java_examples.files;

import static nl.rdb.java_examples.files.FileUtil.readFile;
import static nl.rdb.java_examples.files.FileUtil.writeFile;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;
import nl.rdb.java_examples.scanner.Example;

@Slf4j
public class ReadAndWriteExample {

    @Example
    void readAndWrite() {
        String path = "";
        String fileNameIn = "";

        try (final BufferedReader file = new BufferedReader(new InputStreamReader(new FileInputStream("%s/%s".formatted(path, fileNameIn))))) {
            StringBuilder builder = new StringBuilder();

            for (String line = file.readLine(); line != null; line = file.readLine()) {
                builder.append(Arrays.stream(line.split(";"))
                        .collect(Collectors.joining("\";\"", "\"", "\"")));
                builder.append('\n');
            }

            try (final FileOutputStream fileOut = new FileOutputStream(fileNameIn)) {
                fileOut.write(builder.toString().getBytes());
            }
        } catch (Exception e) {
            log.error("Problem reading file.");
        }
    }

    @Example
    void readAndWriteWithFileReader() {
        String path = "";
        String fileNameIn = "";

        StringBuilder builder = new StringBuilder();

        readFile("%s/%s".formatted(path, fileNameIn), line -> {
            builder.append(Arrays.stream(line.split(";"))
                    .collect(Collectors.joining("\";\"", "\"", "\"")));
            builder.append('\n');
        });

        writeFile(fileNameIn, builder.toString().getBytes());
    }
}
