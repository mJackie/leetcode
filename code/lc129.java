package code;
/*
 * 129. Sum Root to Leaf Numbers
 * 题意：一条路径上的数字组成一个数字，求所有从跟到叶子的路径和
 * 难度：Medium
 * 分类：Tree, Depth-first Search
 * 思路：dfs
 * Tips：lc112, lc113, lc437, lc129, lc124, lc337
 */
public class lc129 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    public int sumNumbers(TreeNode root) {
        if(root==null) return 0;
        return helper(root, 0);
    }
    public int helper(TreeNode root, int sum){
        if(root==null) return 0;    //一条路径，另一边返回0
        if(root.left==null&&root.right==null) return sum*10+root.val;   //这点注意，是叶子节点直接返回了
        return helper(root.left, sum*10+root.val) + helper(root.right, sum*10+root.val);
    }
}
