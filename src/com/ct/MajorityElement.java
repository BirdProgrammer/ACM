package com.ct;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @ Author     ：Cao Tuo
 * @ Date       ：Created in 21:11 2018/9/20
 * @ Description：LeetCode-169. Majority Element
 */
public class MajorityElement {

    public static void main(String[] args){
        int[] nums = {1,1,2,2,1,1,2,2,2,2,3};
        MajorityElement majorityElement = new MajorityElement();
        System.out.println(majorityElement.majorityElement_V2(nums));
    }

    // a very simple approach
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
    
    // divide and conquer approach
    public int majorityElement_V2(int[] nums){
        return majorityElementRecurse(nums,0,nums.length-1);
    }
    public int majorityElementRecurse(int[] nums,int low,int high){
        if(low == high){
            return nums[low];
        }else{
            int middle = (low+high)/2;
            int lowNumber = majorityElementRecurse(nums,low,middle);
            int highNumber = majorityElementRecurse(nums,middle+1,high);
            if(lowNumber == highNumber){
                return lowNumber;
            }else{
                int lowTimes = getFoundTimes(nums,lowNumber,low,high);
                int highTimes = getFoundTimes(nums,highNumber,low,high);
                return lowTimes>highTimes? lowNumber : highNumber;
            }
        }
    }
    public int getFoundTimes(int[] nums,int target,int low,int high){
        int times = 0;
        for(int i=low;i<=high;i++){
            if(target == nums[i]){
                times ++;
            }
        }
        return times;
    }
}
