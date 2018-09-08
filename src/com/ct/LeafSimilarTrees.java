package com.ct;

/**
 * @ Author     ：Cao Tuo
 * @ Date       ：Created in 17:47 2018/9/5
 * @ Description：
 */
public class LeafSimilarTrees {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();
        getSequence(root1,sb1);
        getSequence(root2,sb2);
        return sb1.toString().equals(sb2.toString());
    }

    private void getSequence(TreeNode root,StringBuffer sb){
        if(root!=null){
            if(root.left == null && root.right == null) {
                sb.append(String.valueOf(root.val));
            }
            getSequence(root.left,sb);
            getSequence(root.right,sb);
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
     }
}
