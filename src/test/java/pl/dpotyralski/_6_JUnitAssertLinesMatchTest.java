package pl.dpotyralski;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class _6_JUnitAssertLinesMatchTest {

    @Test
    void testLinesMatch() {
        List<String> actualList = List.of("a", "b", "c", "d", "e");
        List<String> expectedSet = List.of("a", "b", "c", "d", "e");

        Assertions.assertLinesMatch(actualList, expectedSet);
    }

}
