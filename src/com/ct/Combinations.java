package com.ct;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author     ：Cao Tuo
 * @ Date       ：Created in 13:13 2018/9/12
 * @ Description：LeetCode-77. Combinations
 */
public class Combinations {
    public static void main(String[] args){
        Combinations combinations = new Combinations();
        System.out.println(combinations.combine(4,2));
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(n,k,1,list,ans);
        return ans;
    }

    // 深度优先搜索
    public void dfs(int n,int k,int cur,List<Integer> list,List<List<Integer>> ans){
        if(list.size() == k){
            ans.add(new ArrayList<>(list));
        }else{
            for(int i=cur;i<=n;i++){
                list.add(i);
                dfs(n,k,i+1,list,ans);
                list.remove(list.size()-1);
            }
        }
    }
}
