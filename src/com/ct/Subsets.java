package com.ct;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ Author     ：Cao Tuo
 * @ Date       ：Created in 10:15 2018/9/12
 * @ Description：LeetCode-78. Subsets
 */
public class Subsets {

    public static void main(String[] args){
        Subsets subsets = new Subsets();
        int[] nums = {1,2,3,4,5,6,7};
        System.out.println(subsets.subsets(nums));
    }

    /*
    ArrayList 基于动态数组，LinkedList基于双向链表，两者效率不一样
     */

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums.length == 0){
            return ans;
        }else{
            subsets(nums,0,new LinkedList<>(),ans);
            return ans;
        }
    }

    public void subsets(int[] nums,int cur,List<Integer> list,List<List<Integer>> ans){
        if(cur == nums.length){
            List<Integer> temp = new ArrayList<>(list);
            ans.add(temp);
        }else{
            list.add(nums[cur]);
            subsets(nums,cur+1,list,ans);
            list.remove(list.size()-1);
            subsets(nums,cur+1,list,ans);
        }
    }
}
