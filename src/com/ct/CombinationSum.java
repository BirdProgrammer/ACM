package com.ct;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author     ：Cao Tuo
 * @ Date       ：Created in 21:49 2019/8/2
 * @ Description：LeetCode-39. Combination Sum
 */
public class CombinationSum {

    public static void main(String[] args){
        int candidates[] = {2,3,5};
        int target = 8;
        CombinationSum combinationSum = new CombinationSum();
        System.out.println(combinationSum.combinationSum(candidates,target));
    }

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    List<Integer> temp;
    int sum = 0;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        combinationSumHelper(candidates,target,0);
        return ans;
    }

    public void combinationSumHelper(int[] candidates, int target,int index) {
        if(index == candidates.length){
            if(sum == target){
                temp = new ArrayList<>(list);
                ans.add(temp);
            }
        }else{
            int count = (target-sum)/candidates[index];
            for(int i=0;i<count;i++){
                sum += candidates[index];
                list.add(candidates[index]);
            }
            for(int i=0;i<count;i++){
                combinationSumHelper(candidates,target,index+1);
                list.remove(list.size()-1);
                sum -= candidates[index];
            }
            combinationSumHelper(candidates,target,index+1);
        }
    }
}
