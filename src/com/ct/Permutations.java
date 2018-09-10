package com.ct;

import java.util.LinkedList;
import java.util.List;

/**
 * @ Author     ：Cao Tuo
 * @ Date       ：Created in 17:17 2018/9/10
 * @ Description：LeetCode-46. Permutations
 */
public class Permutations {

    public static void main(String[] args){
        int nums[] = {1,2,3};
        System.out.println(new Permutations().permute(nums));
    }

    List<List<Integer>> ans = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        permute(nums,0);
        return ans;
    }

    public void permute(int[] nums,int cur){
        if(cur == nums.length){
            List<Integer> list = new LinkedList<>();
            for(int i=0;i<nums.length;i++){
                list.add(nums[i]);
            }
            ans.add(list);
        }else{
            for(int i=cur;i<nums.length;i++){
                swap(nums,i,cur);
                permute(nums,cur+1);
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
