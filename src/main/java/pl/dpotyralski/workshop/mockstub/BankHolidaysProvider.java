package pl.dpotyralski.workshop.mockstub;

import java.time.MonthDay;
import java.util.List;

public interface BankHolidaysProvider {

    List<MonthDay> bankHolidaysByCountry(String country);

}
