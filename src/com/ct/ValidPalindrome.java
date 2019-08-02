package com.ct;

/**
 * @ Author     ：Cao Tuo
 * @ Date       ：Created in 21:19 2019/8/2
 * @ Description：LeetCode-125. Valid Palindrome
 */
public class ValidPalindrome {

    public static void main(String[] args){
        String string = "0P";
        System.out.println('P'-'0');
        System.out.println(new ValidPalindrome().isPalindrome(string));
    }

    public boolean isPalindrome(String s) {
        boolean re = true;
        int left = 0;
        int right = s.length()-1;
        s = s.toLowerCase();
        while (left<right){

            if(!isCharacter(s.charAt(left))){
                left++;
            }else if(!isCharacter(s.charAt(right))){
                right--;
            }else{
                if(s.charAt(left) == s.charAt(right)){
                    left++;
                    right--;
                }else{
                    re = false;
                    break;
                }
            }
        }
        return re;
    }

    private boolean isCharacter(char c){

        return (c>='a'&& c<='z') || (c>='0'&&c<='9');
    }
}
