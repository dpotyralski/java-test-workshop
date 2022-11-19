package pl.dpotyralski;

import lombok.Value;

@Value
public class Customer {
    int id;
    String fullName;
    String country;
}
