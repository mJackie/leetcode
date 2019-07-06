package code;
/*
 * 199. Binary Tree Right Side View
 * 题意：二叉树的右视图
 * 难度：Medium
 * 分类：Tree, Depth-first Search, Breadth-first Search
 * 思路：1.记录当前递归最大深度，每次把第一次出现深度的节点值输出即可
 *      2.层次遍历
 * Tips：
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class lc199 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    int max_depth = 0;
    List<Integer> res = new ArrayList();
    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, 1);
        return res;
    }

    public void dfs(TreeNode root, int depth){
        if(root==null) return;  //别忘了null
        if(depth>max_depth) {
            max_depth = depth;
            res.add(root.val);
        }
        dfs(root.right, depth+1);
        dfs(root.left, depth+1);
    }

    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> res = new ArrayList();
        Queue<TreeNode> qu = new LinkedList();  //是一个队列，用LinkedList
        if(root!=null) qu.add(root);
        while(!qu.isEmpty()){
            int size = qu.size();
            while(size>0){
                TreeNode tn = qu.remove();
                if(size==1) res.add(tn.val);    //==1的时候添加
                if(tn.left!=null) qu.add(tn.left);
                if(tn.right!=null) qu.add(tn.right);
                size--;
            }
        }
        return res;
    }
}
