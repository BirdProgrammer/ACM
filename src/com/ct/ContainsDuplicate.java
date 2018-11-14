package com.ct;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @ Author     ：Cao Tuo
 * @ Date       ：Created in 13:31 2018/10/7
 * @ Description：LeetCode-217. Contains Duplicate
 */
public class ContainsDuplicate {

    public static void main(String[] args){
        int[] nums = {1,2,3,4,2};
        System.out.println(new ContainsDuplicate().containsDuplicate(nums));
    }

    // use hash table
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for(int num : nums){
            if(!hashSet.add(num)){
                return true;
            }
        }
        return false;
    }

    // use sorting
    public boolean containsDuplicate_V2(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
            if(nums[i] == nums[i+1]){
                return true;
            }
        }
        return false;
    }
}
