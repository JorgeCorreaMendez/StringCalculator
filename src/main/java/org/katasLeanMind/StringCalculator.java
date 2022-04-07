package org.katasLeanMind;

import org.katasLeanMind.exceptions.InvalidFormatException;


public class StringCalculator {
    public StringCalculator() {
    }

    public int add(String numberText) throws InvalidFormatException {
        if (numberText.equals("")) return 0;
        if (numberText.contains(",\n"))
            throw new InvalidFormatException("Error, Invalid format, you can't use ,\\n");

        String[] contentsText = numberText.split("\n");
        String separator = contentsText[0].substring(contentsText[0].length() - 1);

        String[] numbersText = contentsText[1].split(separator);

        int numberOfNumbers = numbersText[1].length();
        if (numberOfNumbers > 2) return 0;

        return sum(numbersText);
    }

    private int sum(String[] numbers) {
        int total = 0;

        for (String number : numbers) {
            total += Integer.parseInt(number);
        }

        return total;
    }


}
