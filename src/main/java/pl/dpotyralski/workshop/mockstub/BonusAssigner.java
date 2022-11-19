package pl.dpotyralski.workshop.mockstub;

import pl.dpotyralski.Customer;

import java.math.BigDecimal;

public interface BonusAssigner {

    boolean assignBonus(Customer customer, BigDecimal amount);

}
