package com.ct;

/**
 * @ Author     ：Cao Tuo
 * @ Date       ：Created in 11:41 2018/9/12
 * @ Description：LeetCode-100. Same Tree
 */
public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null){
            return true;
        }else if(p!=null && q!=null){
            return p.val==q.val && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }else{
            return false;
        }
    }
}
