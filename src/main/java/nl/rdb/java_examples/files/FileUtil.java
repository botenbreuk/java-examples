package nl.rdb.java_examples.files;

import static lombok.AccessLevel.PRIVATE;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.function.Consumer;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor(access = PRIVATE)
public class FileUtil {

    public static void readFile(String fileName, Consumer<String> stringSupplier) {
        readFile(fileName, stringSupplier, Charset.defaultCharset());
    }

    public static void readFile(String fileName, Consumer<String> stringSupplier, Charset charset) {
        try (final BufferedReader file = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), charset))) {
            for (String line = file.readLine(); line != null; line = file.readLine()) {
                stringSupplier.accept(line);
            }
        } catch (Exception e) {
            log.error("Problem reading file.");
        }
    }

    public static void writeFile(String fileName, byte[] bytes) {
        try (final FileOutputStream fileOut = new FileOutputStream(fileName)) {
            fileOut.write(bytes);
        } catch (Exception e) {
            log.error("Problem writing file.");
        }
    }
}
