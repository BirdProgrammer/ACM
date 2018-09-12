package com.ct;

import java.util.*;

/**
 * @ Author     ：Cao Tuo
 * @ Date       ：Created in 10:55 2018/9/12
 * @ Description：LeetCode-90. Subsets II
 */
public class SubsetsII {

    public static void main(String[] args){
        int nums[] = {1,2,2};
        SubsetsII  subsetsII = new SubsetsII();
        System.out.println(subsetsII.subsetsWithDup(nums));
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        subsetsWithDup(nums,0,list,ans);
        return ans;
    }
    public void subsetsWithDup(int[] nums,int cur,List<Integer> list,List<List<Integer>> ans){
        ans.add(new ArrayList<>(list));
        for(int i=cur;i<nums.length;i++){
            if(i>cur && nums[i]==nums[i-1]){
                continue;
            }else{
                list.add(nums[i]);
                subsetsWithDup(nums,i+1,list,ans);
                list.remove(list.size()-1);
            }
        }
    }
}
