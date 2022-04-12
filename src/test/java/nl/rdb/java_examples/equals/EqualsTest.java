package nl.rdb.java_examples.equals;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import org.junit.jupiter.api.Nested;
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

    @Nested
    class EqualsStringTest {

        @Test
        void testStringEquals() {
            String test = "test";
            assertTrue(test.equals("test"));
            assertTrue(test == "test");

            String test2 = "test";
            assertTrue(test.equals(test2));
            assertTrue(test == test2);

            test = test2;
            assertTrue(test.equals(test2));
            assertTrue(test == test2);

            String test3 = test;
            assertTrue(test.equals(test2));
            assertTrue(test.equals(test3));
            assertTrue(test == test2);
            assertTrue(test == test3);
        }

        // Test based on example in https://www.delftstack.com/howto/java/java-string-equals-vs-/
        @Test
        void testStringEquals_withStringConstructor() {
            String str1 = "name";
            String str2 = "name";
            String str3 = new String("name");
            assertTrue(str1.equals(str2));
            assertTrue(str1 == str2);
            assertTrue(str1.equals(str3));
            assertFalse(str3 == str1);
        }
    }
}
