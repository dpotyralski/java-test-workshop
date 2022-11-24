package pl.dpotyralski.workshop.datadriven;

import java.math.BigDecimal;

import static pl.dpotyralski.workshop.datadriven.CarType.REGULAR;

class CarRentalRegularPriceCalculation implements CarRentalPriceCalculation {

    private static final BigDecimal CHILDREN_SEAT_PRICE = new BigDecimal("8");

    @Override
    public BigDecimal calculate(CarRental carRental) {
        BigDecimal resultPrice = BigDecimal.ZERO;

        if (carRental.getType() == REGULAR && carRental.isChildrenSeat()) {
            resultPrice = resultPrice.add(CHILDREN_SEAT_PRICE);
        }

        if (carRental.getType() == REGULAR) {
            resultPrice = resultPrice.add(new BigDecimal("10"));
        }

        return resultPrice.multiply(new BigDecimal(carRental.getDays()));
    }

    @Override
    public CarType getType() {
        return CarType.REGULAR;
    }
}
