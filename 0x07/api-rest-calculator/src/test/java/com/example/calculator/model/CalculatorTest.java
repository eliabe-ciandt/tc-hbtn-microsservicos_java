package com.example.calculator.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    void createCalc() {
        this.calculator = new Calculator();
    }

    @Test
    void sumTest() {
        assertEquals(3, calculator.sum(2.0, 1.0));
        assertThrows(NullPointerException.class, () -> calculator.sum(null, 2.0));
    }

    @Test
    void subTest() {
        assertEquals(1992, calculator.sub(1991.0, -1.0));
    }

    @Test
    void divideTest() {
        assertEquals(15, calculator.divide(45.0, 3.0));
        assertThrows(ArithmeticException.class, () -> calculator.divide(3.0, 0.0));
    }

    @Test
    void factorialTest() {
        assertEquals(120, calculator.factorial(5));
    }

    @Test
    void integerToBinaryTest() {
        assertEquals(1, calculator.integerToBinary(1));
        assertEquals(101, calculator.integerToBinary(5));
        assertEquals(10100, calculator.integerToBinary(20));
    }

    @Test
    void integerToHexadecimalTest() {
        assertEquals("aa", calculator.integerToHexadecimal(170));
    }

    @Test
    void calculeDayBetweenDateTest() {
    }
}