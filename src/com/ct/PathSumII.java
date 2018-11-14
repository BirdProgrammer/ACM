package com.ct;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author     ：Cao Tuo
 * @ Date       ：Created in 11:15 2018/9/18
 * @ Description：LeetCode-113. Path Sum II
 */
public class PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        pathSum(root,sum,0,ans,new ArrayList<>());
        return ans;
    }
    // 如果所有的values都不小于0的话，可以使用剪枝函数，但是这里的values可以是负数
    public void pathSum(TreeNode root,int sum,int currentTotal,List<List<Integer>> ans,List<Integer> list){
        if (root != null){
            currentTotal+=root.val;
            list.add(root.val);
            if(sum==currentTotal && root.left==null && root.right==null){
                ans.add(new ArrayList<>(list));
            }else{
                pathSum(root.left,sum,currentTotal,ans,list);
                pathSum(root.right,sum,currentTotal,ans,list);
            }
            list.remove(list.size()-1);
        }
    }
}
