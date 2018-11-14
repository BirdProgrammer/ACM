package com.ct;

/**
 * @ Author     ：Cao Tuo
 * @ Date       ：Created in 13:27 2018/10/7
 * @ Description：LeetCode-258. Add Digits
 */
public class AddDigits {

    public static void main(String[] args){
        int num = 11;
        System.out.println(new AddDigits().addDigits(num));
    }
    int addDigits(int num) {
        if(num < 10){
            return num;
        }else{
            int temp = 0;
            while(num != 0){
                temp += num%10;
                num /= 10;
            }
            return addDigits(temp);
        }
    }
}
