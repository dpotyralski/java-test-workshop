package pl.dpotyralski;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

class _16_JUnitStubDefaultReturnValuesMockitoTest {

    ExampleInterface mock = mock(ExampleInterface.class);

    @Test
    void shouldGetDefaultCharValue() {
        //then
        assertEquals(0, mock.getChar());
    }

    @Test
    void shouldGetDefaultFloatValue() {
        //then
        assertEquals(0f, mock.getFloat());
    }

    @Test
    void shouldGetDefaultShortValue() {
        //then
        assertEquals(0, mock.getShort());
    }

    @Test
    void shouldGetDefaultCollectionValue() {
        //then
        assertTrue(mock.getCollection().isEmpty());
    }

    @Test
    void shouldGetDefaultMapValue() {
        //then
        assertTrue(mock.getMap().isEmpty());
    }

    @Test
    void shouldGetDefaultLongValue() {
        //then
        assertEquals(0, mock.getLong());
    }


    @Test
    void shouldGetDefaultDoubleValue() {
        //then
        assertEquals(0, mock.getDouble());
    }


    @Test
    void shouldGetDefaultIntValue() {
        //then
        assertEquals(0, mock.getInt());
    }

    @Test
    void shouldGetDefaultIntegerValue() {
        //then
        assertEquals(0, mock.getInteger());
    }

    @Test
    void shouldGetDefaultByteValue() {
        //then
        assertEquals(0, mock.getByte());
    }

    interface ExampleInterface {

        char getChar();

        float getFloat();

        short getShort();

        Collection getCollection();

        Map getMap();

        long getLong();

        double getDouble();

        int getInt();

        Integer getInteger();

        byte getByte();

    }

}


