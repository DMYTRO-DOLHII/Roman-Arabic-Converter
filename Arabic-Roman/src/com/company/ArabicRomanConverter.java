package com.company;

import java.util.ArrayList;
import java.util.List;

public class ArabicRomanConverter extends MainNumbersSymbols{
    private int arabicValue;
    private String romanValue;

    private List<Integer> numbersByCategory = new ArrayList<>();

    int getArabicValue(){
        return arabicValue;
    }

    void setArabicResult(int newArabicValue){
        this.arabicValue = newArabicValue;
    }

    String getRomanValue(){
        return romanValue;
    }

    void setRomanValue(String newValue){
        romanValue = newValue;
    }


    void devideByCategory(){
        String number = String.valueOf(arabicValue);
        for(int i = 0; i < number.length(); i++){
            String n = number.charAt(i) + zero(number.length() - i - 1);
            if(Integer.parseInt(n) != 0){
                int nResult = Integer.parseInt(n);
                numbersByCategory.add(nResult);
            }
        }
    }

    String zero(int count){
        String z = "";
        for(int i = 0; i < count; i++){
            z = z + "0";
        }
        return z;
    }


    void convert(){
        devideByCategory();
        String result = "";
        int i = 0;
        while(i < numbersByCategory.size()){
            for(int j = 0; j < mainNumbersOne.length - 1; j++){
                if(numbersByCategory.get(i) > mainNumbersOne[j] && numbersByCategory.get(i) < mainNumbersOne[j+1]){
                    if(numbersByCategory.get(i) > mainNumbersFive[j]){
                        if(numbersByCategory.get(i) == mainNumbersOne[j+1] - mainNumbersOne[j]){
                            result += mainSymbolsOne[j];
                            result += mainSymbolsOne[j+1];
                            break;
                        } else{
                            result += mainSymbolsFive[j];
                            int n = (numbersByCategory.get(i) - mainNumbersFive[j]) / mainNumbersOne[j];
                            for(int k = 0; k < n; k++){
                                result += mainSymbolsOne[j];
                            }
                            break;
                        }
                    } else if(numbersByCategory.get(i) < mainNumbersFive[j]){
                        if(numbersByCategory.get(i) == mainNumbersFive[j] - mainNumbersOne[j]){
                            result += mainSymbolsOne[j];
                            result += mainSymbolsFive[j];
                            break;
                        } else{
                            int n = numbersByCategory.get(i) / mainNumbersOne[j];
                            for(int k = 0; k < n; k++){
                                result += mainSymbolsOne[j];
                            }
                            break;
                        }
                    } else{
                        result += mainSymbolsFive[j];
                        break;
                    }
                } else{
                    if(numbersByCategory.get(i) == mainNumbersOne[j]){
                        result += mainSymbolsOne[j];
                        break;
                    } else if(numbersByCategory.get(i) == mainNumbersOne[j+1]){
                        result += mainSymbolsOne[j + 1];
                        break;
                    }
                }
            }
            i++;
        }
        setRomanValue(result);
    }

    void print(){
        for(int i = 0; i < numbersByCategory.size(); i++){
            System.out.println(numbersByCategory.get(i));
        }
    }


}
