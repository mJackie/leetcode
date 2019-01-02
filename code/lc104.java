package code;
/*
 * 104. Maximum Depth of Binary Tree
 * 题意：二叉树最大深度
 * 难度：Easy
 * 分类：Tree, Depth-first Search
 * 思路：深度优先搜索，递归实现
 * Tips：
 */
public class lc104 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
    }
}
