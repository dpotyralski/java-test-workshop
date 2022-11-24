package pl.dpotyralski.workshop;

public class FizzBuzzResolver {

    private final int fizz;
    private final int buzz;

    public FizzBuzzResolver() {
        this.fizz = 3;
        this.buzz = 5;
    }

    public FizzBuzzResolver(int fizz, int buzz) {
        this.fizz = fizz;
        this.buzz = buzz;
    }

    public String resolve(int number) {
        if (number % fizz == 0 && number % buzz == 0) {
            return "FizzBuzz";
        }
        if (number % fizz == 0) {
            return "Fizz";
        }
        if (number % buzz == 0) {
            return "Buzz";
        }
        return String.valueOf(number);
    }

}