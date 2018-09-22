package com.ct;

/**
 * @ Author     ：Cao Tuo
 * @ Date       ：Created in 21:33 2018/9/22
 * @ Description：
 */
public class RemoveDuplicatesfromSortedArray {

    public static void main(String[] args){
        RemoveDuplicatesfromSortedArray removeDuplicatesfromSortedArray = new RemoveDuplicatesfromSortedArray();
        int[] nums = {2,2,3,3,4};
        System.out.println(removeDuplicatesfromSortedArray.removeDuplicates(nums));
    }

    public int removeDuplicates(int[] nums) {
        if(nums.length < 2){
            return nums.length;
        }else{
            int left = 0;
            int right = 1;
            while(right<nums.length){
                while(nums[right] == nums[right-1]){
                    right++;
                    if(right == nums.length){
                        return left+1;
                    }
                }
                left++;
                nums[left] = nums[right];
                right++;
            }
            return left+1;
        }
    }
}
