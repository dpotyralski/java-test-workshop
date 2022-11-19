package pl.dpotyralski.workshop.datadriven;

import java.math.BigDecimal;
import java.time.Year;

import static pl.dpotyralski.workshop.datadriven.CarType.PREMIUM;
import static pl.dpotyralski.workshop.datadriven.CarType.REGULAR;

class CarRentalPriceCalculator {

    private static final BigDecimal CHILDREN_SEAT_PRICE = new BigDecimal("8");
    private static final BigDecimal PREMIUM_CHILDREN_SEAT_PRICE = new BigDecimal("14");

    public BigDecimal calculate(CarRental carRental) {

        BigDecimal resultPrice = BigDecimal.ZERO;

        if (carRental.getType() == REGULAR && carRental.isChildrenSeat()) {
            resultPrice = resultPrice.add(CHILDREN_SEAT_PRICE);
        }

        if (carRental.getType() == REGULAR) {
            resultPrice = resultPrice.add(new BigDecimal("10"));
        }

        if (carRental.getType() == PREMIUM && carRental.isChildrenSeat()) {
            resultPrice = resultPrice.add(PREMIUM_CHILDREN_SEAT_PRICE);
        }

        if (carRental.getType() == PREMIUM && carRental.getProductionYear().compareTo(Year.of(2015)) > 0) {
            resultPrice = resultPrice.add(new BigDecimal("25"));
        }

        if (carRental.getType() == PREMIUM && carRental.getProductionYear().compareTo(Year.of(2015)) <= 0) {
            resultPrice = resultPrice.add(new BigDecimal("15"));
        }

        return resultPrice.multiply(new BigDecimal(carRental.getDays()));
    }
}
