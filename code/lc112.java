package code;
/*
 * 112. Path Sum
 * 题意：是否存在跟到叶子节点的和为sum
 * 难度：Easy
 * 分类：
 * 思路：
 * Tips：lc112, lc113, lc437, lc129, lc124, lc337
 * 总结一下 lc112 找跟到叶子和为sum的路径是否存在
 *         lc113 把lc112的路径找出来
 *         lc437 是任意一条向下走的路径
 *         lc129 计算所有的和
 *         lc124 任意一条路径
 *         lc337 树的dp
 */
public class lc112 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null) return false;
        if(root.val==sum&&root.left==null&&root.right==null) return true;
        return hasPathSum(root.left, sum-root.val)||hasPathSum(root.right, sum-root.val);
    }
}
