package org.katasLeanMind;

import org.katasLeanMind.exceptions.InvalidFormatException;
import org.katasLeanMind.exceptions.NegativeNumberException;


public class StringCalculator {
    public StringCalculator() {
    }

    public int add(String numberText) throws InvalidFormatException, NegativeNumberException {
        if (numberText.equals("")) return 0;

        if (numberText.contains(",\n"))
            throw new InvalidFormatException("Error, Invalid format, you can't use ,\\n");

        String[] numbersText;
        if (numberText.startsWith("/")) {
            numbersText = getNumberWithSeparator(numberText);
        } else {
            numbersText = getNumbersWithoutSeparator(numberText);
        }

        int numberOfNumbers = numbersText.length;
        if (numberOfNumbers > 2) return 0;

        return sum(numbersText);
    }

    private int sum(String[] numbers) throws NegativeNumberException {
        int total = 0;

        for (String number : numbers) {
            int actualNumber = Integer.parseInt(number);

            if (actualNumber < 0)
                throw new NegativeNumberException("Error, no supported negative numbers");

            if (actualNumber <= 1000) total += actualNumber;
        }

        return total;
    }

    private String[] getNumbersWithoutSeparator(String numbers) {
        return numbers.split("[\n,]");
    }

    private String[] getNumberWithSeparator(String numbers) {
        String[] contentsText = numbers.split("\n");

        String separator = contentsText[0].substring(contentsText[0].length() - 1);

        return contentsText[1].split(separator);
    }

}
