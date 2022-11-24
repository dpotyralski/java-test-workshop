package pl.dpotyralski.workshop.tdd;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShippingCalculatorTest {

    ShippingCalculator calculator = new ShippingCalculator();

    @Test
    void calculate() {
        //when
        BigDecimal actualPrice = calculator.calculate(new Product(BigDecimal.ZERO, ProductSize.S));
        //then
        assertEquals(BigDecimal.TEN, actualPrice);
    }

    @Test
    void calculatePriceForMSize() {
        //when
        BigDecimal actualPrice = calculator.calculate(new Product(BigDecimal.ZERO, ProductSize.M));
        //then
        assertEquals(new BigDecimal("12"), actualPrice);
    }

    @Test
    void calculatePriceForLSize() {
        //when
        BigDecimal actualPrice = calculator.calculate(new Product(BigDecimal.ZERO, ProductSize.L));
        //then
        assertEquals(new BigDecimal("14"), actualPrice);
    }

    @Test
    void calculatePriceForXXLSize() {
        //when
        BigDecimal actualPrice = calculator.calculate(new Product(BigDecimal.ZERO, ProductSize.XXL));
        //then
        assertEquals(new BigDecimal("44"), actualPrice);
    }

    @Test
    void calculatePriceForSSize() {
        //when
        BigDecimal actualPrice = calculator.calculate(new Product(new BigDecimal(100), ProductSize.S));
        //then
        assertEquals(new BigDecimal("9.0"), actualPrice);
    }


}
