package org.katasLeanMind;

import org.katasLeanMind.exceptions.InvalidFormatException;
import org.katasLeanMind.exceptions.NegativeNumberException;

import java.util.Arrays;

public class StringCalculator {
    public StringCalculator() {
    }

    public int add(String numberText) throws InvalidFormatException, NegativeNumberException {
        if (numberText.equals("")) return 0;

        if (numberText.contains(",\n"))
            throw new InvalidFormatException("Error, Invalid format, you can't use ,\\n");


        if (numberText.startsWith("//"))
            return sum(getNumberWithSeparator(numberText));

        return sum(getNumbersWithoutSeparator(numberText));
    }

    private int sum(String[] numbers) throws NegativeNumberException {
        int total = 0;

        if (numbers.length == 0){
            return 0;
        }

        int number = Integer.parseInt(numbers[0]);

        if (number < 0) {
            throw new NegativeNumberException("Error, no supported negative numbers");
        }

        if (number <= 1000) {
            total += number;
        }

        return total + sum(Arrays.copyOfRange(numbers, 1, numbers.length));
    }

    private String[] getNumbersWithoutSeparator(String numbers) {
        return numbers.split("[\n,]");
    }

    private String[] getNumberWithSeparator(String numbers) {
        String[] contentsText = numbers.split("\n");

        String separator = "";

        int index = 0;

        while (index != contentsText[0].length()){
            int indexOfStartSeparator = contentsText[0].indexOf("[", index) + 1;
            int indexOfEndSeparator = contentsText[0].indexOf("]", index);
            separator += contentsText[0].substring(indexOfStartSeparator, indexOfEndSeparator) + "|";

            index = indexOfEndSeparator + 1;
        }

        separator = separator.substring(0, separator.length() -1);

        return contentsText[1].split(separator);
    }

}
