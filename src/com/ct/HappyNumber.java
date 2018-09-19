package com.ct;

import java.util.HashSet;
import java.util.Set;

/**
 * @ Author     ：Cao Tuo
 * @ Date       ：Created in 22:40 2018/9/19
 * @ Description：LeetCode-202. Happy Number
 */
public class HappyNumber {

    public static void main(String[] args){
        int n = 19;
        System.out.println(new HappyNumber().isHappy(n));
    }
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while(!set.contains(n)){
            if (n == 1){
                return true;
            }else{
                set.add(n);
                int temp = 0;
                while(n != 0){
                    temp += (n%10)*(n%10);
                    n /= 10;
                }
                n = temp;
            }
        }
        return false;
    }
}
