package com.company;

public class Main {

    public static void main(String[] args) {
        ArabicRomanConverter ar = new ArabicRomanConverter();
        RomanArabicConverter ra = new RomanArabicConverter();

        ar.setArabicResult(999);
        ar.convert();
        String a = ar.getRomanValue();
        System.out.println(a);

        ra.setRomanValue(a);
        ra.convert();
        System.out.println(ra.getArabicValue());
    }
}
