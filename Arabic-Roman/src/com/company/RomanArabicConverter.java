package com.company;

import java.util.ArrayList;
import java.util.List;

public class RomanArabicConverter extends MainNumbersSymbols {
    private int arabicValue;
    private String romanValue;

    private List<Integer> numbersByCategory = new ArrayList<>();

    void setArabicValue(int newValue){
        arabicValue = newValue;
    }

    int getArabicValue(){
        return arabicValue;
    }

    void setRomanValue(String newValue){
        romanValue = newValue;
    }

    String getRomanValue(){
        return romanValue;
    }

    void devideByCategory(){
        for(int i = 0; i < romanValue.length(); i++){
            for(int j = 0; j < mainSymbolsOne.length; j++){
                if(romanValue.charAt(i) == mainSymbolsOne[j]){
                    numbersByCategory.add(mainNumbersOne[j]);
                    break;
                }
            }

            for(int k = 0; k < mainNumbersFive.length; k++){
                if(romanValue.charAt(i) == mainSymbolsFive[k]){
                    numbersByCategory.add(mainNumbersFive[k]);
                    break;
                }
            }
        }
    }

    void convert(){
        devideByCategory();
        int result = 0;
        int i = 0;
        while(i < numbersByCategory.size()){
            for(int j = 0; j < mainNumbersFive.length; j++){
                if(numbersByCategory.get(i) == mainNumbersFive[j]){
                    result += numbersByCategory.get(i);
                    break;
                }
            }

            for(int j = 0; j < mainNumbersOne.length - 1; j++){
                if(numbersByCategory.get(i) == mainNumbersOne[j]){
                    if(i < numbersByCategory.size() - 1){
                        if(numbersByCategory.get(i+1) == mainNumbersOne[j+1] || numbersByCategory.get(i+1) == mainNumbersFive[j]) {
                            result += numbersByCategory.get(i + 1) - numbersByCategory.get(i);
                            i++;
                            break;
                        } else {
                            result += numbersByCategory.get(i);
                            break;
                        }
                    } else {
                        result += numbersByCategory.get(i);
                        break;
                    }
                }
            }
            i++;
        }

        setArabicValue(result);
    }

    void print(){
        for(int i = 0; i < numbersByCategory.size(); i++){
            System.out.println(numbersByCategory.get(i));
        }
    }

}
