package com.ct;

/**
 * @ Author     ：Cao Tuo
 * @ Date       ：Created in 9:21 2018/9/21
 * @ Description：LeetCode-53. Maximum Subarray
 */
public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int curSum = 0;
        int result = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            curSum = curSum+nums[i]>nums[i] ? curSum+nums[i] : nums[i];
            result = result>curSum? result : curSum;
        }
        return result;
    }

    // divide and conquer approach
    public int maxSubArray_V2(int[] nums){
        if (nums.length == 0){
            return 0;
        }else{
            return getMaxSubArraySumm(nums,0,nums.length-1);
        }
    }
    public int getMaxSubArraySumm(int[] nums,int left,int right){
        if(left >= right){
            return nums[left];
        }else{
            int middle = (left+right)/2;
            int leftMaxSum = getMaxSubArraySumm(nums,left,middle-1);
            int rightMaxSum = getMaxSubArraySumm(nums,middle+1,right);
            int middleMaxSum = nums[middle];
            int temp = middleMaxSum;
            for(int i=middle-1;i>=left;i--){
                temp += nums[i];
                middleMaxSum = middleMaxSum>=temp ? middleMaxSum : temp;
            }
            temp = middleMaxSum;
            for(int i=middle+1;i<=right;i++){
                temp += nums[i];
                middleMaxSum = middleMaxSum>=temp ? middleMaxSum : temp;
            }
            return Math.max(leftMaxSum,Math.max(rightMaxSum,middleMaxSum));
        }
    }
}

