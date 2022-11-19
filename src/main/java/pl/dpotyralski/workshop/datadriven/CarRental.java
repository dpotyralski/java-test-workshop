package pl.dpotyralski.workshop.datadriven;

import lombok.Value;

import java.time.Year;

@Value
public class CarRental {
    CarType type;
    Year productionYear;
    boolean childrenSeat;
    int days;
}
