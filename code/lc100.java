package code;
/*
 * 100. Same Tree
 * 题意：判断两棵树是否一样
 * 难度：Easy
 * 分类：
 * 思路：
 * Tips：
 */
public class lc100 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null) return true;
        if( (p==null&&q!=null)||(q==null&&p!=null) ) return false;
        if(p.val!=q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
