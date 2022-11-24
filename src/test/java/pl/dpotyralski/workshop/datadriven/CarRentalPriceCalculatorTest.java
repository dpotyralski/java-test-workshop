package pl.dpotyralski.workshop.datadriven;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.time.Year;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarRentalPriceCalculatorTest {

    CarRentalPriceCalculator calculator = new CarRentalPriceCalculator();

    private static Stream<Arguments> getCarRentals() {
        return Stream.of(
                Arguments.of(new CarRental(CarType.REGULAR, Year.of(2019), true, 3), new BigDecimal("54")),
                Arguments.of(new CarRental(CarType.PREMIUM, Year.of(2019), false, 2), new BigDecimal("50")),
                Arguments.of(new CarRental(CarType.PREMIUM, Year.of(2014), true, 2), new BigDecimal("58"))
        );
    }

    @ParameterizedTest
    @MethodSource({"getCarRentals"})
    void calculate_returnPrice_forProvidedCarRentals(CarRental rental, BigDecimal expectedPrice) {
        //when
        BigDecimal actualPrice = calculator.calculate(rental);

        //then
        assertEquals(expectedPrice, actualPrice);
    }
}