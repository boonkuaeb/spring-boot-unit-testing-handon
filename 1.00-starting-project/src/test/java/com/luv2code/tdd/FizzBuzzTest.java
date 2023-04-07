package com.luv2code.tdd;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FizzBuzzTest {
//      If number is divisible by 3, print Fizz
 @Test
    @DisplayName("Divisible by Three")
    @Order(1)
    void testForDivisibleByThree()
    {
        String expected = "Fizz";
        assertEquals(expected,FizzBuzz.compute(3),"Should return Fizz");
    }
//      If number is divisible by 5, print Buzz
    @Test
    @DisplayName("Divisible by Five")
    @Order(2)
    void testForDivisibleByFive()
    {
        String expected = "Buzz";
        assertEquals(expected,FizzBuzz.compute(5),"Should return Buzz");
    }

    //      If number is divisible by 3 and 5, print FizzBuzz
    @Test
    @DisplayName("Divisible by Three And Five")
    @Order(3)
    void testForDivisibleByThreeAndFive()
    {
        String expected = "FizzBuzz";
        assertEquals(expected,FizzBuzz.compute(15),"Should return FizzBuzz");
    }

    //      If number is not divisible by 3 or 5, then print the number
    @Test
    @DisplayName("No Divisible by Three Or Five")
    @Order(4)
    void testForNotDivisibleByThreeOrFive()
    {
        String expected = "7";
        assertEquals(expected,FizzBuzz.compute(7),"Should return 7");
    }

    @DisplayName("Testing with small data file")
    @Order(5)
    @ParameterizedTest(name = "value={0},expected={1}")
    @CsvFileSource(resources = "/small-test-data.csv")
    void testSmallDataFile(int value, String expected)
    {
        assertEquals(expected,FizzBuzz.compute(value));
    }

    @DisplayName("Testing with medium data file")
    @Order(6)
    @ParameterizedTest(name = "value={0},expected={1}")
    @CsvFileSource(resources = "/medium-test-data.csv")
    void testMediumDataFile(int value, String expected)
    {
        assertEquals(expected,FizzBuzz.compute(value));
    }

    @DisplayName("Testing with large data file")
    @Order(7)
    @ParameterizedTest(name = "value={0},expected={1}")
    @CsvFileSource(resources = "/large-test-data.csv")
    void testLargeDataFile(int value, String expected)
    {
        assertEquals(expected,FizzBuzz.compute(value));
    }
}
