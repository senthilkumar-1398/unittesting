package com.example.unittest11_08_2021.calculationtest;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculationValidationTest {
    CalculationValidation calculationValidation = new CalculationValidation();

    @Test
    public void addition_isCorrect() {
        int addition = calculationValidation.addTwoNumbers( 2, 2 );
        assertEquals( "Addition", 4, addition );
    }

    @Test
    public void subtraction_isCorrect() {
        int subtraction = calculationValidation.subtractTwoNumbers( 8, 5 );
        assertEquals( "Subtraction", 3, subtraction );
    }

    @Test
    public void multiply_isCorrect() {
        int multiply = calculationValidation.multiplyTwoNumbers( 2, 4 );
        assertEquals( "Multiply", 8, multiply );
    }

    @Test
    public void division_isCorrect() {
        int division = calculationValidation.divideTwoNumbers( 8, 4 );
        assertEquals( "Division", 2, division );
    }

}