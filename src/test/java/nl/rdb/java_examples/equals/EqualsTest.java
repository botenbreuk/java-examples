package nl.rdb.java_examples.equals;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import org.junit.jupiter.api.Test;

class EqualsTest {

    @Test
    void equalsListTest() {
        List<TestObject> testObjects = new ArrayList<>();
        List<TestObject> testObjects2 = new ArrayList<>();

        TestListObject testListObject1 = new TestListObject("Piet", 21);
        TestListObject testListObject2 = new TestListObject("Pietje", 21);

        testObjects.add(new TestObject("test1", List.of(testListObject1)));
        testObjects2.add(new TestObject("test1", List.of(testListObject2)));

        assertEquals(testObjects, testObjects2);
    }

    @Getter
    @EqualsAndHashCode
    private class TestObject {
        private final String name;
        private final List<TestListObject> objs;

        public TestObject(String name, List<TestListObject> objs) {
            this.name = name;
            this.objs = objs;
        }
    }

    @Getter
    @EqualsAndHashCode
    private class TestListObject {
        @EqualsAndHashCode.Exclude
        private final String name;
        private final int age;

        public TestListObject(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
}
