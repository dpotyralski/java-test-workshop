package pl.dpotyralski.workshop.tdd;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class Product {

    BigDecimal price;
    ProductSize size;

}
