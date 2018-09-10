package com.ct;

/**
 * @ Author     ：Cao Tuo
 * @ Date       ：Created in 19:45 2018/9/10
 * @ Description：LeetCode-58. Length of Last Word
 */
public class LengthofLastWord {

    public static void main(String[] args){
        String s = "Hello World   ";
        System.out.println(new LengthofLastWord().lengthOfLastWord_V2(s));
    }

    public int lengthOfLastWord(String s) {
        String[] strings = s.split(" ");
        if (strings.length==0){
            return 0;
        }else{
            return strings[strings.length-1].length();
        }
    }

    public int lengthOfLastWord_V2(String s) {
        int length = 0;
        int i = s.length()-1;
        while(i>=0 && s.charAt(i)==' '){
            i--;
        }
        for(;i>=0;i--){
            if(s.charAt(i)==' ') {
                break;
            }else{
                length++;
            }
        }
        return length;
    }
}
