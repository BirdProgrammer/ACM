package com.ct;

/**
 * @ Author     ：Cao Tuo
 * @ Date       ：Created in 13:18 2018/10/7
 * @ Description：LeetCode-171. Excel Sheet Column Number
 */
public class ExcelSheetColumnNumber {

    public static void main(String[] args){
        String s = "ZY";
        System.out.println(new ExcelSheetColumnNumber().titleToNumber(s));
    }

    public int titleToNumber(String s) {
        int result = 0;
        int temp;
        for(char c : s.toCharArray()){
            temp = c-'A'+1;
            result = result*26+temp;
        }
        return result;
    }
}
