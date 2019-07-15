package code;

import java.util.ArrayList;
import java.util.List;
/*
 * 113. Path Sum II
 * 题意：找从root到叶子节点和为sum的路径
 * 难度：Medium
 * 分类：Tree, Depth-first Search
 * 思路：回溯，注意因为节点上可能正值，可能负值，所以不能剪枝
 * Tips：lc112, lc113, lc437, lc129, lc124, lc337
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
        List<List<Integer>> res = new ArrayList();
        helper(res, new ArrayList(), root, sum);
        return res;
    }
    public void helper(List<List<Integer>> res, List<Integer> cur, TreeNode root, int sum){
        if(root==null) return;
        cur.add(root.val);
        if(root.left==null&&root.right==null&&root.val==sum){   //到叶子节点
            res.add(new ArrayList(cur));
        }else{
            helper(res, cur, root.left, sum-root.val);
            helper(res, cur, root.right, sum-root.val);
        }
        cur.remove(cur.size()-1);
        return;
    }
}
