package pl.dpotyralski;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class _18_JunitMockitoFinalTest {

    ExampleFinalClass mock = mock(ExampleFinalClass.class);

    MoreComplicatedService finalCallExample = new MoreComplicatedService(mock);

    @Test
    void shouldMockFinalClass() {
        //given
        when(mock.methodIWantToMock()).thenReturn(true);
        boolean expectedResult = true;

        //when
        boolean actualResult = finalCallExample.useMethodFromFinalClass();

        //then
        assertEquals(expectedResult, actualResult);
        verify(mock, times(1)).methodIWantToMock();
    }
}


