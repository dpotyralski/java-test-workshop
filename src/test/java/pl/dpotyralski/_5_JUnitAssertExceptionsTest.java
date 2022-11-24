package pl.dpotyralski;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class _5_JUnitAssertExceptionsTest {

    ExceptionProvider exceptionProvider = new ExceptionProvider();

    @Test
    void testException() {
        //expect
        assertThrows(UnsupportedOperationException.class, () -> exceptionProvider.operationUnsupported());
    }

    @Test
    void testNoException() {
        //expect
        assertDoesNotThrow(() -> exceptionProvider.withoutException());
    }

    @Test
    @Disabled
    void testNoExceptions() {
        //expect
        Assertions.assertAll(
                () -> exceptionProvider.operationUnsupported(),
                () -> exceptionProvider.illegalStateException(),
                () -> exceptionProvider.withoutException()
        );
    }

}
