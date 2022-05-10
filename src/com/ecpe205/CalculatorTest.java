package com.ecpe205;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CalculatorTest {
    Calculator calc;

    @BeforeAll
    void setup(){
        calc = new Calculator();
    }

    //CREATE A TEST TO TEST isEven
    @Test
    void shouldCheckValueIsEven() {
        assertEquals(true,calc.isEven(2));
        assertEquals(false,calc.isEven(1));
    }

    @Test
    void shouldCheckValueIsOdd() {
        assertEquals(true,calc.isOdd(1));
        assertEquals(false,calc.isOdd(2));
    }


    @Test
    @DisplayName("Sum 2 encoded values")
    void shouldSumTwoEncodedValues() {

        // 1 + 2 = 3
        assertEquals(3, calc.sum(1,2) );
        assertEquals(9, calc.sum(5,4) );
        assertEquals(5, calc.sum(3,2) );
        assertEquals(14, calc.sum(5,9) );
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5})
    void shouldSumValueWithOne( int value ) {
        assertEquals(value + 1, calc.sum(value, 1));
    }

    @ParameterizedTest
    @MethodSource("sumInputValues")
    void shouldSumTwoInputValues(int a, int b) {
        assertEquals(a + b, calc.sum(a, b));
    }

    static Stream<Arguments> sumInputValues () {
        return Stream.of(
                Arguments.of(1,2),
                Arguments.of(4,6),
                Arguments.of(2,7),
                Arguments.of(3,7),
                Arguments.of(3,0)
        );
    }

    @ParameterizedTest
    @MethodSource("BasePower")
    void shouldSolveExponent(double a, double b) {
        assertEquals(Math.pow(a,b), calc.exponent(a, b));
    }

    static Stream<Arguments> BasePower () {
        return Stream.of(
                Arguments.of(1,2),
                Arguments.of(4,6),
                Arguments.of(2,7),
                Arguments.of(3,7),
                Arguments.of(3,0)
        );
    }
    @ParameterizedTest
    @ValueSource(ints = {3,4,5,6,7})
    void factorialTest(int n) {
        assertEquals(120, calc.factor(n));
    }

    @ParameterizedTest
    @ValueSource(strings = {"civic","radar", "sean", "refer", "rotor" })
    void isPalindromeTest(String n) {
        assertEquals(true, calc.isPalindrome(n));
    }
    @ParameterizedTest
    @MethodSource("arrayOfIntegerSets")
    void shouldSortArray(int [] array){//testing for bubbleSort() method
        assertEquals("[0, 2, 2, 4, 4]", calc.bubbleSort(array));
    }//I just compared the ascending sorting of bubbleSort and shellSort

    static Stream<Arguments> arrayOfIntegerSets () {
        return Stream.of(
                Arguments.of(new int[]{0,3,3,7,1}),
                Arguments.of(new int[]{6,3,5,1,0}),
                Arguments.of(new int[]{4,2,0,2,4}),
                Arguments.of(new int[]{1,3,4,1,7}),
                Arguments.of(new int[]{9,0,1,3,2})

        );
    }