package pl.dpotyralski;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

class _9_JUnitAssertionLibrariesTest {

    @Test
    void testEquity() {
        String actual = "text";
        String expected = "text";

        org.hamcrest.MatcherAssert.assertThat(actual, equalTo(expected)); // Hamcrest
        Assertions.assertThat(actual).isEqualTo(expected); // AssertJ
    }

    @Test
    void testCollections() {
        //given
        List<String> values = List.of("a", "b", "c");

        //expect
        Assertions.assertThat(values).contains("b", "c"); // AssertJ
        Assertions.assertThat(values).containsExactly("a", "b", "c"); // AssertJ
        Assertions.assertThat(values).containsOnly("c", "b", "a"); // AssertJ

        org.hamcrest.MatcherAssert.assertThat(values, hasItems("b", "c")); // Hamcrest
        org.hamcrest.MatcherAssert.assertThat(values, contains("a", "b", "c")); // Hamcrest
        org.hamcrest.MatcherAssert.assertThat(values, containsInAnyOrder("c", "b", "a")); // Hamcrest
    }

}
