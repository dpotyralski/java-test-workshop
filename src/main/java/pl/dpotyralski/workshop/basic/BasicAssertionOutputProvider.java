package pl.dpotyralski.workshop.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class BasicAssertionOutputProvider {

    public String sayHello(String name) {
        return "Hello, " + name;
    }

    public boolean isEven(int value) {
        return value % 2 == 0;
    }

    public List<String> splitString(String value) {
        return Arrays.asList(value.split(""));
    }

    public List<String> removesDuplicates(List<String> strings) {
        HashSet<String> noDuplicates = new HashSet<>(strings);
        return new ArrayList<>(noDuplicates);
    }

    public Set<Integer> filtersAllAboveGivenValue(Set<Integer> integerSet, int maxValue) {
        return integerSet.stream()
                .filter(integer -> integer > maxValue)
                .collect(Collectors.toSet());
    }

}
