package com.ct;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ Author     ：Cao Tuo
 * @ Date       ：Created in 23:10 2018/9/12
 * @ Description：LeetCode-102. Binary Tree Level Order Traversal
 */
public class BinaryTreeLevelOrderTraversal {



    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null){
            return ans;
        }
        List<Integer> list;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(queue.size() != 0){
            int length = queue.size();
            list = new ArrayList<>();
            while(length != 0){
                TreeNode temp = queue.poll();
                list.add(temp.val);
                if(temp.left != null){
                    queue.offer(temp.left);
                }
                if(temp.right != null){
                    queue.offer(temp.right);
                }
                length--;
            }
            ans.add(new ArrayList<>(list));
        }
        return ans;
    }

    //Definition for a binary tree node.
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}

