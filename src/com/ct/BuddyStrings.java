package com.ct;

import java.util.HashSet;
import java.util.Set;

/**
 * @ Author     ：Cao Tuo
 * @ Date       ：Created in 17:55 2018/9/8
 * @ Description：
 */
public class BuddyStrings {

    public static void main(String[] args){
        String s1 = "aa";
        String s2 = "aa";
        System.out.println(new BuddyStrings().buddyStrings(s1,s2));
    }

    public boolean buddyStrings(String A, String B) {
        if(A.length()!=B.length()){
            return false;
        }
        Set<Character> set = new HashSet<>();
        boolean flag = false;
        int first=-1,last=-1;
        for(int i=0;i<A.length();i++){
            if(!flag){
                if(set.contains(A.charAt(i))){
                    flag = true;
                }else{
                    set.add(A.charAt(i));
                }
            }
            if(A.charAt(i) != B.charAt(i)){
                if(first==-1){
                    first = i;
                }else{
                    if(last==-1){
                        last = i;
                    }else{
                        return false;
                    }
                }
            }
        }

        if((first==-1&&flag) || (first!=-1&&last!=-1&&A.charAt(first)==B.charAt(last) && A.charAt(last)==B.charAt(first))){
            return true;
        }else{
            return false;
        }
    }
}
