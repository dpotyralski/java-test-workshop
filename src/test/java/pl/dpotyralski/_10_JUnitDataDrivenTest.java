package pl.dpotyralski;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Month;
import java.util.EnumSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class _10_JUnitDataDrivenTest {

    OddNumberResolver oddNumberResolver = new OddNumberResolver();

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, -3, 15, Integer.MAX_VALUE})
    void shouldHaveOddNumbersForPassed(int number) {
        //expect
        assertTrue(oddNumberResolver.isNotOdd(number));
    }

    @ParameterizedTest
    @ValueSource()
//    @NullSource
    @NullAndEmptySource
    void shouldHaveFiveLengthStrings(String text) {
        //expect
        assertEquals(5, text.length());
    }

    @ParameterizedTest
    @EnumSource(value = Month.class)
    void shouldListEveryMonth(Month month) {
        //given
        int monthNumber = month.getValue();

        //expect
        assertTrue(monthNumber >= 1 && monthNumber <= 12);
    }

    @ParameterizedTest
    @EnumSource(value = Month.class, names = {"JANUARY"})
    void shouldGetOnlyJanuary(Month month) {
        //given
        Month january = Month.JANUARY;
        int monthNumber = january.getValue();

        //expect
        assertTrue(monthNumber == 1);
    }

    @ParameterizedTest
    @EnumSource(value = Month.class, names = {"JANUARY", "DECEMBER"}, mode = EnumSource.Mode.EXCLUDE)
    void shouldGetAllExceptJanuaryAndDecember(Month month) {
        //given
        int monthNumber = month.getValue();

        //expect
        assertTrue(monthNumber >= 2 && monthNumber <= 11);
    }

    @ParameterizedTest
    @EnumSource(value = Month.class, names = ".+ARY", mode = EnumSource.Mode.MATCH_ALL)
    void shouldGetMonthsWithARYEnding(Month month) {
        //given
        EnumSet<Month> expectedMonths = EnumSet.of(Month.JANUARY, Month.FEBRUARY);

        //expect
        assertTrue(expectedMonths.contains(month));
    }

    @ParameterizedTest
    @CsvSource({"TEST,test", "tEst,test", "Java,java"})
    void shouldLowercasePassedValues(String input, String expected) {
        //given
        String actualValue = input.toLowerCase();

        //expect
        assertEquals(expected, actualValue);
    }

    @ParameterizedTest
    @CsvSource(value = {"TEST;test", "tEst;test", "Java;java"}, delimiter = ';')
    void shouldLowercasePassedValuesWithConfiguredDelimiter(String input, String expected) {
        //given
        String actualValue = input.toLowerCase();

        //expect
        assertEquals(expected, actualValue);
    }

    @ParameterizedTest
    @CsvFileSource(resources = {"/example.csv"}, delimiter = '|', useHeadersInDisplayName = true)
    void shouldValidateEmailsFromCSVFile(String id, String firstName, String email) {
        //given
        String expected = firstName.toLowerCase() + "@company.pl";

        //expect
        assertEquals(expected, email);
    }

    static class OddNumberResolver {
        boolean isNotOdd(int value) {
            return value % 2 != 0;
        }
    }

}
