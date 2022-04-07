package org.katasLeanMind;

import org.junit.Ignore;
import org.junit.Test;
import org.katasLeanMind.exceptions.InvalidFormatException;
import org.katasLeanMind.exceptions.negativeNumberException;

import java.net.PortUnreachableException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class StringCalculatorTest {
    StringCalculator newStringCalculator = new StringCalculator();

    @Test
    public void parse_zero_when_not_receive_number() throws InvalidFormatException {
        assertEquals(0, newStringCalculator.add(""));
    }

    @Test
    @Ignore
    public void parse_zero_when_receive_more_of_two_numbers() throws InvalidFormatException {
        assertEquals(0, newStringCalculator.add("1,2,3"));
    }

    @Test
    @Ignore
    public void sum_numbers_when_receive_two_numbers() throws InvalidFormatException {
        assertEquals(10, newStringCalculator.add("5,5"));
    }

    @Test
    @Ignore
    public void sum_numbers_when_receive_two_numbers_with_separator() throws InvalidFormatException {
        assertEquals(6, newStringCalculator.add("1\n5"));
    }

    @Test(expected = InvalidFormatException.class)
    @Ignore
    public void throw_exception_when_receive_two_numbers_with_bad_format() throws InvalidFormatException {
        newStringCalculator.add("1,\n8");
    }

    @Test
    public void sum_number_when_receive_two_numbers_with_specific_separator() throws InvalidFormatException {
        assertEquals(3, newStringCalculator.add("//;\n1;2"));
    }

    @Test(expected = negativeNumberException.class)
    public void throw_exception_when_receive_negative_numbers() throws InvalidFormatException {
        newStringCalculator.add("//;\n-1;-1");
    }


}
