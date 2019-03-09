package code;

import java.util.LinkedList;
import java.util.List;

/*
 * 95. Unique Binary Search Trees II
 * 题意：1~n可以组成的二叉搜索树
 * 难度：Medium
 * 分类：Dynamic Programming, Tree
 * 思路：96只要求计算数量，dp就行，当要把所有情况都输出的时候，往往递归更方便一些
 *      返回的的是跟的List，不用把整颗数的节点都复制了，所以下层的叶子节点是被多个父节点指向
 *      暴力，子情况被计算了多遍，为什么不用mem呢？？？
 * Tips：lc96
 */
public class lc95 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<TreeNode> generateTrees(int n) {
        if(n==0) return new LinkedList();
        return generateSubtrees(1, n);
    }

    private List<TreeNode> generateSubtrees(int s, int e) {
        List<TreeNode> res = new LinkedList<TreeNode>();
        if (s > e) {
            res.add(null); // empty tree
            return res;
        }

        for (int i = s; i <= e; ++i) {
            List<TreeNode> leftSubtrees = generateSubtrees(s, i - 1);
            List<TreeNode> rightSubtrees = generateSubtrees(i + 1, e);

            for (TreeNode left : leftSubtrees) {
                for (TreeNode right : rightSubtrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
