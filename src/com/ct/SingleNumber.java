package com.ct;

import java.util.Arrays;

/**
 * @ Author     ：Cao Tuo
 * @ Date       ：Created in 15:00 2018/9/18
 * @ Description：LeetCode-136. Single Number
 */
public class SingleNumber {

    public static void main(String[] args){
        int[] nums = {2,2,1};
        System.out.println(new SingleNumber().singleNumber(nums));
    }

    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        int j = 1;
        for(;i<nums.length && j<nums.length;i+=2,j+=2){
            if(nums[i] != nums[j]){
                return nums[i];
            }
        }
        return nums[i];
    }

    // 利用了异或操作的性质，太灵性了！！！
    public int singleNumber_V2(int[] nums){
         int temp = 0;
         for(int x : nums){
             temp ^= x;
         }
         return temp;
    }
}
