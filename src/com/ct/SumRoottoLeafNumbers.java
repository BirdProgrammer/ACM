package com.ct;

/**
 * @ Author     ：Cao Tuo
 * @ Date       ：Created in 20:50 2018/9/19
 * @ Description：LeetCode-129. Sum Root to Leaf Numbers
 */
public class SumRoottoLeafNumbers {

    public int sumNumbers(TreeNode root) {
        return sumNumbers(root,0);
    }

    public int sumNumbers(TreeNode root,int base){
        if(root == null){
            return 0;
        }else{
            int sum = sumNumbers(root.left,base*10+root.val)+sumNumbers(root.right,base*10+root.val);
            if(sum == 0){
                return base*10+root.val;
            }else{
                return sum;
            }
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
