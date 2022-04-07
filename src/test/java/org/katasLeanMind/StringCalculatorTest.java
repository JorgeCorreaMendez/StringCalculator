package org.katasLeanMind;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

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
}
