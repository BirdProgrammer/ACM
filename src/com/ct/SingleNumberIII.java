package com.ct;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @ Author     ：Cao Tuo
 * @ Date       ：Created in 17:57 2018/10/7
 * @ Description：LeetCode-260. Single Number III
 */
public class SingleNumberIII {

    public static void main(String[] args){
        int[] nums = {1,2,1,3,2,5};
        System.out.println(Arrays.toString(new SingleNumberIII().singleNumber_V2(nums)));
    }

    public int[] singleNumber(int[] nums) {
        int firstNumber =0 ;
        int lastNumber = 0;
        int xorNumber = 0;
        int index = 0;
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            xorNumber = xorNumber^nums[i];
        }

        for(int i=0;i<32;i++){
            if(((xorNumber>>i)&1) == 1){
                index = i;
                break;
            }
        }

        for(int i=0;i<nums.length;i++){
            if(((nums[i]>>index)&1) == 1){
                list1.add(nums[i]);
            }else{
                list2.add(nums[i]);
            }
        }

        for(int i=0;i<list1.size();i++){
            firstNumber = firstNumber^list1.get(i);
        }
        for(int i=0;i<list2.size();i++){
            lastNumber = lastNumber^list2.get(i);
        }

        return new int[]{firstNumber,lastNumber};
    }

    public int[] singleNumber_V2(int[] nums) {
        int firstNumber =0 ;
        int lastNumber = 0;
        int xorNumber = 0;
        int helper = 1;

        for(int i=0;i<nums.length;i++){
            xorNumber = xorNumber^nums[i];
        }
        while((xorNumber&helper) == 0){
            helper <<= 1;
        }
        for(int i=0;i<nums.length;i++){
            if((helper&nums[i]) == helper){
                firstNumber ^= nums[i];
            }else{
                lastNumber ^= nums[i];
            }
        }

        return new int[]{firstNumber,lastNumber};
    }
}
