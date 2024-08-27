package nl.rdb.java_examples.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;
import nl.rdb.java_examples.scanner.Example;

@Slf4j
public class FileReaderExample {

    @Example
    void fromResources() {
        String fileName = "/files/text.txt";
        InputStream stream = FileReaderExample.class.getResourceAsStream(fileName);
        if (stream == null) {
            log.info("File not found: {}", fileName);
            return;
        }

        printContent(new InputStreamReader(stream));
    }

    @Example(disabled = true)
    void fromLocation() throws FileNotFoundException {

        log.info("File location");
        String location = new Scanner(System.in).nextLine();
        File file = new File(location);

        if (!file.exists()) {
            log.info("File not found: {}", file.getName());
            return;
        }

        printContent(new FileReader(file));
    }

    private void printContent(Reader reader) {
        List<String> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(reader)) {
            String line;
            while ((line = br.readLine()) != null) {
                list.add(line.replace("\"", ""));
            }
        } catch (Exception e) {
            log.error("Error: {}", e.getMessage());
        }

        log.info("{}", list.stream().collect(Collectors.joining("\n", "\n", "")));
    }
}
