package pl.dpotyralski;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;


//Mockito's inline mock maker supports static mocks based on the Instrumentation API
class _17_JUnitMockStaticTest {

    @Test
    void shouldShowHowHandleStatic() {
        //given
        boolean expectedResult = true;

//        assertEquals(expectedResult, FinalClassFromSomewhere.someStaticMethod());
        try (MockedStatic<UtilityClass> utilities = Mockito.mockStatic(UtilityClass.class)) {
            utilities.when(() -> UtilityClass.someStaticMethod()).thenReturn(true);
            assertEquals(expectedResult, UtilityClass.someStaticMethod());
        }
//        assertEquals(expectedResult, FinalClassFromSomewhere.someStaticMethod());
    }


    @Test
    void shouldStubStatic() {
        //given
        int expectedResult = 5;

//        assertEquals(expectedResult, FinalClassFromSomewhere.someStaticMethod(5));
        try (MockedStatic<UtilityClass> utilities = Mockito.mockStatic(UtilityClass.class)) {
            utilities.when(() -> UtilityClass.someStaticMethod(2)).thenReturn(5);
            assertEquals(expectedResult, UtilityClass.someStaticMethod(2));
        }

        //then
//        assertEquals(expectedResult, FinalClassFromSomewhere.someStaticMethod(5));
    }
}


