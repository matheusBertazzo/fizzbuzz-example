package com.tdd.fizzbuzz;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.google.common.collect.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FizzBuzzTestOptionalRefactor {

    public static final String FIZZ = "Fizz";
    public static final String BUZZ = "Buzz";
    public static final String FIZZBUZZ = "FizzBuzz";
    private static String expectedResultWithFourFizzes;
    private static String expectedResultWithFourBuzzes;
    private static String expectedResultWithFourFizzBuzzes;
    private static String expectedResultForAllKindsOfNumbers;
    private static ArrayList<Integer> allKindsOfNumbers;

    @BeforeAll
    static void setup(){
        allKindsOfNumbers = newArrayList(-5, -3, 1, 2, 3, 4, 5, 6, 10, 15, 30);

        expectedResultWithFourFizzes = createCommaSeparatedList(newArrayList(FIZZ, FIZZ, FIZZ, FIZZ));
        expectedResultWithFourBuzzes = createCommaSeparatedList(newArrayList(BUZZ, BUZZ, BUZZ, BUZZ));
        expectedResultWithFourFizzBuzzes = createCommaSeparatedList(newArrayList(FIZZBUZZ, FIZZBUZZ, FIZZBUZZ, FIZZBUZZ));
        expectedResultForAllKindsOfNumbers = createCommaSeparatedList(newArrayList(
                BUZZ, FIZZ, "1", "2", FIZZ, "4", BUZZ, FIZZ, BUZZ, FIZZBUZZ, FIZZBUZZ
        ));
    }

    @ParameterizedTest
    @MethodSource("provideValidNumberParameters")
    void should_returnFizzOrBuzzOrFizzBuzzCorrectly_when_fizzBuzz_given_aListWithValidNumberParameters(ArrayList<Integer> list, String expectedResult, String clue){
        String result = FizzBuzz.fizzBuzz(list);
        assertEquals(expectedResult, result, clue);
    }

    private static Stream<Arguments> provideValidNumberParameters(){
        return Stream.of(
            Arguments.of(newArrayList(3), FIZZ, "Should return just Fizz given a single factor of 3."),
            Arguments.of(newArrayList(3, 6, 9, 12), expectedResultWithFourFizzes, "Should return just Fizzes given a list with only factors of 3."),
            Arguments.of(newArrayList(5), BUZZ, "Should return just Buzz given a single factor of 5."),
            Arguments.of(newArrayList(5, 10, 20, 25), expectedResultWithFourBuzzes, "Should return just Buzzes given a list with only factors of 5."),
            Arguments.of(newArrayList(15), FIZZBUZZ, "Should return just FizzBuzz given a single factor of both 3 and 5."),
            Arguments.of(newArrayList(15, 30, 45, 60), expectedResultWithFourFizzBuzzes, "Should return just FizzBuzzes given a list with only factors of 3 and 5."),
            Arguments.of(newArrayList(1), "1", "Should return the number itself given a number that is not a factor of 3 or 5"),
            Arguments.of(allKindsOfNumbers, expectedResultForAllKindsOfNumbers, "Should return Fizz, Buzz or FizzBuzz correctly given a list of random numbers")
        );
    }

    private static String createCommaSeparatedList(ArrayList<String> arrayList) {
        return arrayList.stream().collect(Collectors.joining(","));
    }
}