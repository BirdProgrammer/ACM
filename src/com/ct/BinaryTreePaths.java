package com.ct;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author     ：Cao Tuo
 * @ Date       ：Created in 23:00 2018/9/19
 * @ Description：LeetCode-257. Binary Tree Paths
 */
public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        binaryTreePaths(root,ans,list);
        return ans;
    }

    public void binaryTreePaths(TreeNode root,List<String> ans,List<Integer> list){
        if(root == null){
            return;
        }
        if(root.left==null && root.right==null){
            StringBuilder sb = new StringBuilder();
            for(Integer integer : list){
                sb.append(integer+"->");
            }
            sb.append(root.val);
            ans.add(sb.toString());
        }else{
            list.add(root.val);
            binaryTreePaths(root.left,ans,list);
            binaryTreePaths(root.right,ans,list);
            list.remove(list.size()-1);
        }
    }
}
