package org.katasLeanMind;

import org.junit.Test;
import org.katasLeanMind.exceptions.InvalidFormatException;
import org.katasLeanMind.exceptions.NegativeNumberException;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for simple App.
 */
public class StringCalculatorTest {
    StringCalculator newStringCalculator = new StringCalculator();

    @Test
    public void parse_zero_when_not_receive_number() {
        try {
            assertEquals(0, newStringCalculator.add(""));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void parse_zero_when_receive_more_of_two_numbers() {
        try {
            assertEquals(0, newStringCalculator.add("1,2,3"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void sum_numbers_when_receive_numbers() {
        try {
            assertEquals(5, newStringCalculator.add("5"));
            assertEquals(10, newStringCalculator.add("5,5"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void sum_numbers_when_receive_two_numbers_with_separator() {
        try {
            assertEquals(6, newStringCalculator.add("1\n5"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(expected = InvalidFormatException.class)
    public void throw_exception_when_receive_two_numbers_with_bad_format() throws InvalidFormatException, NegativeNumberException {
        newStringCalculator.add("1,\n8");
    }

    @Test
    public void sum_number_when_receive_two_numbers_with_specific_separator() {
        try {
            assertEquals(3, newStringCalculator.add("//[;]\n1;2"));
            assertEquals(3, newStringCalculator.add("//[%%]\n1%%2"));
            assertEquals(3, newStringCalculator.add("//[***]\n1***2"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(expected = NegativeNumberException.class)
    public void throw_exception_when_receive_negative_numbers() throws InvalidFormatException, NegativeNumberException {
        newStringCalculator.add("//[;]\n-1;-1");
    }

    @Test
    public void sum_numbers_but_if_the_number_is_higher_than_one_thousand_ignore_it(){
        try {
            assertEquals(2, newStringCalculator.add("//[;]\n2;1001"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
