package com.tdd.fizzbuzz;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class FizzBuzz {

    public static final String FIZZ = "Fizz";
    public static final String BUZZ = "Buzz";
    public static final String FIZZBUZZ = "FizzBuzz";

    public static String fizzBuzz(ArrayList<Integer> numbers){
        ArrayList<String> results = new ArrayList<>();

        numbers.forEach(number -> {results.add(performSingleFizzBuzz(number));});

        return results.stream().collect(Collectors.joining(","));
    }

    private static String performSingleFizzBuzz(Integer number) {
        boolean isFactorOf3 = number % 3 == 0;
        boolean isFactorOf5 = number % 5 == 0;
        boolean isFactorOf3And5 = isFactorOf3 && isFactorOf5;

        if (isFactorOf3And5) {
            return FIZZBUZZ;
        } else if(isFactorOf3) {
            return FIZZ;
        } else if(isFactorOf5) {
            return BUZZ;
        } else {
            return number.toString();
        }
    }
}
