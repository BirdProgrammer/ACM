package com.ct;

/**
 * @ Author     ：Cao Tuo
 * @ Date       ：Created in 9:47 2018/9/9
 * @ Description：LeetCOde-540. Single Element in a Sorted Array
 */
public class SingleElementinaSortedArray {

    public static void main(String[] args){
        int[] nums = new int[]{2,2,3,3,4,5,5,6,6};
        System.out.println(new SingleElementinaSortedArray().singleNonDuplicate(nums));
    }

    public int singleNonDuplicate(int[] nums) {
        return singleNonDuplicate(nums,0,nums.length-1);
    }

    public int singleNonDuplicate(int[] nums,int left,int right){
        if(left >= right){
            return nums[left];
        }else{
            int temp = (left+right)/2;
            if(nums[temp-1] == nums[temp]){
                if((temp-2-left+1)%2 != 0){
                    return singleNonDuplicate(nums,left,temp-2);
                }else{
                    return singleNonDuplicate(nums,temp+1,right);
                }
            }else if(nums[temp] == nums[temp+1]){
                if((temp-1-left+1)%2 != 0){
                    return singleNonDuplicate(nums,left,temp-1);
                }else{
                    return singleNonDuplicate(nums,temp+2,right);
                }
            }else{
                return nums[temp];
            }
        }
    }
}
