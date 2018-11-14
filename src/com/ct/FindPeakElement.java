package com.ct;

/**
 * @ Author     ：Cao Tuo
 * @ Date       ：Created in 12:57 2018/10/7
 * @ Description：LeetCode-162. Find Peak Element
 */
public class FindPeakElement {

    public static void main(String[] args){
        FindPeakElement findPeakElement = new FindPeakElement();
        int[] nums = {1,2};
        System.out.println(findPeakElement.findPeakElement(nums));
    }

    // recursively
    public int findPeakElement(int[] nums) {
        int result = findPeakElement(nums,0,nums.length-1);
        if(result == -1){
            if(nums.length==1 || nums[0]>nums[1]){
                return 0;
            }else{
                return nums.length-1;
            }
        }else{
            return result;
        }

    }
    public int findPeakElement(int[] nums,int start,int end) {
        if(end-start <= 1){
            return -1;
        }else{
            int middle = (start+end)/2;
            if(nums[middle-1]<nums[middle] && nums[middle]>nums[middle+1]){
                return middle;
            }else{
                int left = findPeakElement(nums,start,middle);
                if(left != -1){
                    return left;
                }else {
                    int right = findPeakElement(nums,middle,end);
                    return right;
                }
            }
        }
    }
}
