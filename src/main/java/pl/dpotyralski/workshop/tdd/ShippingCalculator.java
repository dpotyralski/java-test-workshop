package pl.dpotyralski.workshop.tdd;

import java.math.BigDecimal;

class ShippingCalculator {

    private static BigDecimal resolvePriceForProduct(Product product) {
        return switch (product.getSize()) {
            case S -> BigDecimal.TEN;
            case M -> new BigDecimal(12);
            case L -> new BigDecimal(14);
            case XXL -> new BigDecimal(44);
            default -> BigDecimal.ZERO;
        };
    }

    private static BigDecimal calculateDiscount(BigDecimal baseShippingPrice, BigDecimal val) {
        return baseShippingPrice.multiply(val);
    }

    public BigDecimal calculate(Product product) {
        BigDecimal baseShippingPrice = resolvePriceForProduct(product);

        if (product.getSize() == ProductSize.XXL) {
            return baseShippingPrice;
        }

        if (product.getPrice().compareTo(new BigDecimal("100")) >= 0) {
            return calculateDiscount(baseShippingPrice, BigDecimal.valueOf(0.9));
        }

        if (product.getPrice().compareTo(new BigDecimal("200")) >= 0) {
            return calculateDiscount(baseShippingPrice, BigDecimal.valueOf(0.6));
        }

        return baseShippingPrice;
    }

}

