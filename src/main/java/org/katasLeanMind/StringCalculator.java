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
