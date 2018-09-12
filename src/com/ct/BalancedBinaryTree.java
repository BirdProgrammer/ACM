package com.ct;

import java.util.HashMap;
import java.util.Map;

/**
 * @ Author     ：Cao Tuo
 * @ Date       ：Created in 23:26 2018/9/12
 * @ Description：LeetCode-110. Balanced Binary Tree
 */
public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        Map<TreeNode,Integer> map = new HashMap<>();
        if(root == null){
            return true;
        }else{
            map.put(null,0);
            dfs(root,map);
            return idBalanced(root,map);
        }
    }

    public void dfs(TreeNode root,Map<TreeNode,Integer> map){
        if(root.left != null){
            dfs(root.left,map);
        }
        if(root.right != null){
            dfs(root.right,map);
        }
        int left = map.get(root.left);
        int right = map.get(root.right);
        map.put(root,Math.max(left,right)+1);
    }
    public boolean idBalanced(TreeNode root,Map<TreeNode,Integer> map){
        if(root == null){
            return true;
        }
        int left = map.get(root.left);
        int right = map.get(root.right);
        return isBalanced(root.left) && isBalanced(root.right) && (left==right || left-right==1 || left-right==-1);
    }

    boolean result = true;
    public boolean isBalanced_V2(TreeNode root) {
        maxDepth(root);
        return result;
    }

    public int maxDepth(TreeNode root) {
        if (result){
            if (root == null)
                return 0;
            int l = maxDepth(root.left);
            int r = maxDepth(root.right);
            if (Math.abs(l - r) > 1)
                result = false;
            return 1 + Math.max(l, r);
        }else{
            return 0;
        }
    }

    //Definition for a binary tree node.
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
