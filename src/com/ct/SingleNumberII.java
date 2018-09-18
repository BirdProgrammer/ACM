package com.ct;

import java.util.Arrays;

/**
 * @ Author     ：Cao Tuo
 * @ Date       ：Created in 15:17 2018/9/18
 * @ Description：LeetCode-137. Single Number II
 */
public class SingleNumberII {

    public static void main(String[] args){
        int[] nums = {2,2,1,2};
        System.out.println(new SingleNumberII().singleNumber(nums));
    }

    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        for(;i<nums.length-2;i+=3){
            if(nums[i]==nums[i+1] && nums[i+1]==nums[i+2]){
                continue;
            }else{
                return nums[i];
            }
        }
        return nums[i];
    }
}
