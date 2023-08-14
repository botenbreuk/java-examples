package nl.rdb.java_examples.gson;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import nl.rdb.java_examples.scanner.Example;

import com.google.gson.Gson;

@Slf4j
public class JsonExample {

    @Example
    public void gsonClassModel() {
        Gson gson = new Gson();
        log.info("{}", gson.toJson(new TestObj()));
    }

    private class TestObj {

        private String stringTest;
        private Long longTest;
        private List<String> listTest;

        public TestObj() {
        }

        public String getStringTest() {
            return stringTest;
        }

        public void setStringTest(String stringTest) {
            this.stringTest = stringTest;
        }
    }
}
