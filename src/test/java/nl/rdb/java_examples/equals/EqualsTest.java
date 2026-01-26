package nl.rdb.java_examples.equals;

import static org.assertj.core.api.Assertions.assertThat;

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

        assertThat(testObjects2).isEqualTo(testObjects);
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
            assertThat(test.equals("test")).isTrue();
            assertThat(test == "test").isTrue();

            String test2 = "test";
            assertThat(test.equals(test2)).isTrue();
            assertThat(test == test2).isTrue();

            test = test2;
            assertThat(test.equals(test2)).isTrue();
            assertThat(test == test2).isTrue();

            String test3 = test;
            assertThat(test.equals(test2)).isTrue();
            assertThat(test.equals(test3)).isTrue();
            assertThat(test == test2).isTrue();
            assertThat(test == test3).isTrue();
        }

        // Test based on example in https://www.delftstack.com/howto/java/java-string-equals-vs-/
        @Test
        void testStringEquals_withStringConstructor() {
            String str1 = "name";
            String str2 = "name";
            String str3 = new String("name");
            assertThat(str1.equals(str2)).isTrue();
            assertThat(str1 == str2).isTrue();
            assertThat(str1.equals(str3)).isTrue();
            assertThat(str3 == str1).isFalse();
        }
    }
}
