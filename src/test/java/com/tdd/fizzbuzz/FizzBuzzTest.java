package com.tdd.fizzbuzz;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.google.common.collect.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTest {

    public static final String FIZZ = "Fizz";
    public static final String BUZZ = "Buzz";
    public static final String FIZZBUZZ = "FizzBuzz";

    @ParameterizedTest
    @MethodSource("provideExclusivelyFactorsOf3Parameters")
    void should_returnOnlyFizz_when_fizzBuzz_given_aListWithNumbersThatAreExclusivelyFactorsOf3(ArrayList<Integer> list, String expectedResult){
        String result = FizzBuzz.fizzBuzz(list);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> provideExclusivelyFactorsOf3Parameters(){
        String expectedResultWithFourFizzes = newArrayList(FIZZ, FIZZ, FIZZ, FIZZ).stream().collect(Collectors.joining(","));

        return Stream.of(
            Arguments.of(newArrayList(3), FIZZ),
            Arguments.of(newArrayList(3, 6, 9, 12), expectedResultWithFourFizzes)
        );
    }

    @ParameterizedTest
    @MethodSource("provideExclusivelyFactorsOf5Parameters")
    void should_returnOnlyBuzz_when_fizzBuzz_given_aListWithNumbersThatAreExclusivelyFactorsOf5(ArrayList<Integer> list, String expectedResult){
        String result = FizzBuzz.fizzBuzz(list);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> provideExclusivelyFactorsOf5Parameters(){
        String expectedResultWithFourBuzzes = newArrayList(BUZZ, BUZZ, BUZZ, BUZZ).stream().collect(Collectors.joining(","));

        return Stream.of(
                Arguments.of(newArrayList(5), BUZZ),
                Arguments.of(newArrayList(5, 10, 20, 25), expectedResultWithFourBuzzes)
        );
    }

    @ParameterizedTest
    @MethodSource("provideExclusivelyFactorsOf3And5Parameters")
    void should_returnFizzBuzz_when_fizzBuzz_given_aListWithNumbersThatAreFactorsOf3And5(ArrayList<Integer> list, String expectedResult){
        String result = FizzBuzz.fizzBuzz(list);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> provideExclusivelyFactorsOf3And5Parameters(){
        String expectedResultWithFourFizzBuzzes = newArrayList(FIZZBUZZ, FIZZBUZZ, FIZZBUZZ, FIZZBUZZ).stream().collect(Collectors.joining(","));

        return Stream.of(
                Arguments.of(newArrayList(15), FIZZBUZZ),
                Arguments.of(newArrayList(15, 30, 45, 60), expectedResultWithFourFizzBuzzes)
        );
    }

    @Test
    void should_returnTheNumberItself_when_fizzBuzz_given_aListWithANumberThatsNotAFactorOf3Or5(){
        int NOT_A_FACTOR_OF_3_OR_5 = 1;

        ArrayList<Integer> list = newArrayList(NOT_A_FACTOR_OF_3_OR_5);
        String result = FizzBuzz.fizzBuzz(list);
        assertEquals(String.valueOf(NOT_A_FACTOR_OF_3_OR_5), result);
    }

    @Test
    void should_returnTheCorrectOutput_when_fizzBuzz_given_aListWithAllKindsOfNumbers(){
        ArrayList<Integer> list = newArrayList(-5, -3, 1, 2, 3, 4, 5, 6, 10, 15, 30);
        String expectedResult = newArrayList(
                BUZZ, FIZZ, "1", "2", FIZZ, "4", BUZZ, FIZZ, BUZZ, FIZZBUZZ, FIZZBUZZ
        )
        .stream()
        .collect(Collectors.joining(","));

        String result = FizzBuzz.fizzBuzz(list);

        assertEquals(expectedResult, result);
    }
}