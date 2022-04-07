package org.katasLeanMind;

public class StringCalculator {
    public StringCalculator() {}

    public int add(String numberText){
        if (numberText.equals("")) return 0;

        String[] numbersText = numberText.split(",");
        int numberOfNumbers = numberText.length();

        if (numberOfNumbers > 3) return 0;

        return 1000;
    }

}
