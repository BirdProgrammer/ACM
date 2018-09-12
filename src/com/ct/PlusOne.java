package com.ct;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @ Author     ：Cao Tuo
 * @ Date       ：Created in 22:41 2018/9/12
 * @ Description：LeetCode-66. Plus One
 */
public class PlusOne {

    public static void main(String[] args){
        int[] digits = {9};
        PlusOne plusOne = new PlusOne();
        System.out.println(Arrays.toString(plusOne.plusOne(digits)));
    }

    public int[] plusOne(int[] digits) {
        int temp =1;
        LinkedList<Integer> list = new LinkedList<>();
        for(int i=digits.length-1;i>=0;i--){
            if(temp == 1){
                if(digits[i]+1 > 9){
                    list.addFirst((digits[i]+1)%10);
                }else{
                    list.addFirst(digits[i]+1);
                    temp = 0;
                }
            }else{
                list.addFirst(digits[i]);
            }
        }
        if(temp == 1){
            list.addFirst(1);
        }
        int[] ans = new int[list.size()];
        for(int i=0;i<list.size();i++){
            ans[i] = list.get(i);
        }
        return ans;
    }

    // best answer
    public int[] plusOne_V2(int[] digits){
        int length = digits.length;
        for(int i=length-1; i>=0; i--){
            if(digits[i] < 9){
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int temp[] = new  int[length+1];
        temp[0] = 1;
        return temp;
    }
}
