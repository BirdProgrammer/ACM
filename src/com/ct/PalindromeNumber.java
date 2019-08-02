package com.ct;
/**
 * @ Author     ：Cao Tuo
 * @ Date       ：Created in 21:13 2018/9/19
 * @ Description：LeetCode-9. Palindrome Number
 */

public class PalindromeNumber {

    public static void main(String[] args){
        PalindromeNumber palindromeNumber = new PalindromeNumber();
        System.out.println(palindromeNumber.isPalindrome(-121));

    }
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        int index;
        int result = 0;
        int temp = x;
        while(temp!=0){
            index = temp%10;
            temp /= 10;
            result = result*10 +index;
        }
        return result==x;
    }
}
