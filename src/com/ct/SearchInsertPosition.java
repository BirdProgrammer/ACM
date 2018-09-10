package com.ct;

/**
 * @ Author     ：Cao Tuo
 * @ Date       ：Created in 16:07 2018/9/10
 * @ Description：LeetCode-35. Search Insert Position
 */
public class SearchInsertPosition {

    public static void main(String[] args){
        int[] nums = {1,3};
        int target = 0;
        System.out.println(new SearchInsertPosition().searchInsert(nums,target));
    }

    public int searchInsert(int[] nums,int target) {
        return searchInsert(nums,target,0,nums.length-1);
    }

    public int searchInsert(int[] nums,int target,int left,int right){

        if(left >= right) {
            if(target <= nums[left]){
                return left;
            }else{
                return left+1;
            }
        }else{
            int temp = (left+right)/2;
            if(nums[temp] == target){
                return temp;
            }else if(nums[temp] > target){
                return searchInsert(nums,target,left,temp-1);
            }else{
                return searchInsert(nums,target,temp+1,right);
            }
        }
    }
}
