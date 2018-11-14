package com.ct;

/**
 * @ Author     ：Cao Tuo
 * @ Date       ：Created in 10:49 2018/9/18
 * @ Description：LeetCode-112. Path Sum
 */
public class PathSum {


    public boolean hasPathSum(TreeNode root, int sum) {
        return hasPathSum(root,sum,0);
    }

    public boolean hasPathSum(TreeNode root, int sum,int currentTotal) {
        if (root == null){
            return false;
        }
        currentTotal+=root.val;
        if(root.left==null && root.right==null){
            return sum==currentTotal;
        }
        return hasPathSum(root.left,sum,currentTotal) || hasPathSum(root.right,sum,currentTotal);
    }
}
