package com.ct;

/**
 * @ Author     ：Cao Tuo
 * @ Date       ：Created in 18:35 2018/10/7
 * @ Description：LeetCode-263. Ugly Number
 */
public class UglyNumber {

    public static void main(String[] args){
        int num = -2147483648;
        System.out.println(new UglyNumber().isUgly(num));
    }

    public boolean isUgly(int num) {
        for(int i=2;i<6&&num>1;i++){
            while(num%i == 0){
                num /= i;
            }
        }
        return num==1;
    }

}
