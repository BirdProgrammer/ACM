package com.ct;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ Author     ：Cao Tuo
 * @ Date       ：Created in 14:20 2018/9/13
 * @ Description：LeetCode-144. Binary Tree Preorder Traversal
 */
public class BinaryTreePreorderTraversal {

    // TODO: 2018/9/13
    //  迭代实现先序遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        queue.offer(root);
        while(queue.size() != 0){
            int length = queue.size();
            while (length != 0){
                TreeNode treeNode = queue.poll();
                if(treeNode != null){
                    ans.add(treeNode.val);
                    queue.offer(treeNode.left);
                    queue.offer(treeNode.right);
                }
                length--;
            }
        }
        return ans;
    }
}
