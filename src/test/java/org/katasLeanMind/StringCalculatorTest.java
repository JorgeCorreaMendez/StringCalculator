package org.katasLeanMind;

import org.junit.Ignore;
import org.junit.Test;
import org.katasLeanMind.exceptions.InvalidFormatException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class StringCalculatorTest {
    StringCalculator newStringCalculator = new StringCalculator();

    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void parse_zero_when_not_receive_number(){
        assertEquals(0, newStringCalculator.add(""));
    }

    @Test
    public void parse_zero_when_receive_more_of_two_numbers(){
        assertEquals(0, newStringCalculator.add("1,2,3"));
    }

    @Test
    public void sum_numbers_when_receive_two_numbers(){
        assertEquals(10, newStringCalculator.add("5,5"));
    }

    @Test
    public void sum_numbers_when_receive_two_numbers_with_separator(){
        assertEquals(2, newStringCalculator.add("1/n5"));
    }


    @Ignore
    @Test(expected = InvalidFormatException.class)
    public void throw_exception_when_receive_two_numbers_with_bad_format(){
        assertEquals(10, newStringCalculator.add("1,/n8"));
    }
}
