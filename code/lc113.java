package code;

import java.util.ArrayList;
import java.util.List;
/*
 * 113. Path Sum II
 * 题意：找从root到叶子节点和为sum的路径
 * 难度：Medium
 * 分类：Tree, Depth-first Search
 * 思路：回溯，注意因为节点上可能正值，可能负值，所以不能剪枝
 * Tips：lc124
 */
public class lc113 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, root, sum, 0, new ArrayList<>());
        return res;
    }
    public void helper(List<List<Integer>> res, TreeNode root, int sum, int curr, List<Integer> curr_ls) {
        if(root==null) return;
        curr_ls.add(root.val);
        if(curr+root.val==sum && root.left==null && root.right==null) { //到叶子节点
            res.add(new ArrayList<>(curr_ls));
            curr_ls.remove(curr_ls.size()-1);
            return;
        }
        helper(res, root.left, sum, curr+root.val, curr_ls);
        helper(res, root.right, sum, curr+root.val, curr_ls);
        curr_ls.remove(curr_ls.size()-1);
    }
}
