package pl.dpotyralski.workshop.datadriven;

import java.math.BigDecimal;

interface CarRentalPriceCalculation {
    BigDecimal calculate(CarRental carRental);

    CarType getType();
}