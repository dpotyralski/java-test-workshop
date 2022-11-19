package pl.dpotyralski.workshop.mockstub;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.mockito.Mockito.mock;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CustomerBonusAssignerTest {

    BankHolidaysProvider bankHolidaysProvider = mock(BankHolidaysProvider.class);
    BonusConfiguration bonusConfiguration = mock(BonusConfiguration.class);
    BonusAssigner bonusAssigner = mock(BonusAssigner.class);

    CustomerBonusAssigner customerBonusAssigner = new CustomerBonusAssigner(bankHolidaysProvider, bonusConfiguration, bonusAssigner);

    @Test
    void assignBonus() {
        //given
        //when
        //then
    }


}