package com.ct;

import java.util.*;

/**
 * @ Author     ：Cao Tuo
 * @ Date       ：Created in 18:55 2018/9/10
 * @ Description：LeetCode-47. Permutations II
 */
public class PermutationsII {

    public static void main(String[] args){
        int nums[] = {1,1,2};
        System.out.println(Arrays.toString(new boolean[4]));
    }

    Set<List<Integer>> hashSet = new HashSet<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        permuteUnique(nums,0);
        return new ArrayList<>(hashSet);
    }

    public void permuteUnique(int[] nums,int cur){
        if(cur == nums.length){
            List<Integer> list = new LinkedList<>();
            for(int i=0;i<nums.length;i++){
                list.add(nums[i]);
            }
            System.out.println(hashSet.add(list));
        }else{
            for(int i=cur;i<nums.length;i++){
                swap(nums,i,cur);
                permuteUnique(nums,cur+1);
                swap(nums,i,cur);
            }
        }
    }
    public void swap(int[]nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
