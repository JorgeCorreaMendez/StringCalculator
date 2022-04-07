package org.katasLeanMind;

public class StringCalculator {
    public StringCalculator() {
    }

    public int add(String numberText) {
        if (numberText.equals("")) return 0;

        String[] numbersText = numberText.split(",");
        int numberOfNumbers = numbersText.length;

        if (numberOfNumbers > 2) return 0;

        return 1000;
    }

    public int sum(int[] numbers) {
        int total = 0;

        for (int number: numbers) {
            total =+ number;
        }

        return total;
    }
}
