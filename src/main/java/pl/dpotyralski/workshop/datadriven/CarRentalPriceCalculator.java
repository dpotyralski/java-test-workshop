package pl.dpotyralski.workshop.datadriven;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

class CarRentalPriceCalculator {

    private final List<CarRentalPriceCalculation> strategies = Arrays.asList(new CarRentalPremiumPriceCalculation(), new CarRentalRegularPriceCalculation());

    public BigDecimal calculate(CarRental carRental) {
        return strategies.stream()
                .filter(calculation -> carRental.getType() == calculation.getType())
                .findFirst()
                .get()
                .calculate(carRental);
    }

}
