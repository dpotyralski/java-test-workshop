package pl.dpotyralski;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pl.dpotyralski.workshop.FizzBuzzResolver;

class TddShowOff {


    @ParameterizedTest
    @CsvSource({"1,1", "2,2", "3,Fizz", "6,Fizz", "5,Buzz"})
    void shouldResolveFizzBuzz(int input, String result) {
        //given
        FizzBuzzResolver resolver = new FizzBuzzResolver();

        //when
        String resolve = resolver.resolve(input);

        //then
        Assertions.assertThat(resolve).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource({"2, Fizz", "7, Buzz"})
    void shouldResolveFizzBuzzForNonDefaultSetOfNumbers(int input, String result) {
        //given
        FizzBuzzResolver resolver = new FizzBuzzResolver(2, 7);

        //when
        String resolve = resolver.resolve(input);

        //then
        Assertions.assertThat(resolve).isEqualTo(result);
    }


}
