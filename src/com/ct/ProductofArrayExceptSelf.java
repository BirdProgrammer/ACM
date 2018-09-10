package com.ct;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @ Author     ：Cao Tuo
 * @ Date       ：Created in 10:23 2018/9/9
 * @ Description：LeetCode-238. Product of Array Except Self
 */
public class ProductofArrayExceptSelf {

    public static void main(String[] args){
        int[] nums = new int[]{1,2,3,0};
        System.out.println(Arrays.toString(new ProductofArrayExceptSelf().productExceptSelf(nums)));
    }

    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        int product = 1;
        int first_zero=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0) {
                product *= nums[i];
            }else{
                if(first_zero==-1){
                    first_zero = i;
                }else{
                    return ans;
                }
            }
        }
        if(first_zero == -1){
            for(int i=0;i<nums.length;i++){
                ans[i] = product/nums[i];
            }
        }else{
            ans[first_zero] = product;
        }
        return ans;
    }
}
