package code;

import java.util.Stack;
/*
 * 99. Recover Binary Search Tree
 * 题意：二叉搜索树中两个节点错位了，恢复二叉搜索树，用O(1)空间
 * 难度：Hard
 * 分类：Tree, Depth-first Search
 * 思路：只要记录错乱的节点就可以了，最后交换两个节点的值
 *      先序遍历  在print那个地方加上逻辑代码
 * Tips：
 */
public class lc99 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    TreeNode tn1 = null;
    TreeNode tn2 = null;
    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp = tn1.val;
        tn1.val = tn2.val;
        tn2.val = temp;
    }

    public void inorder(TreeNode root){
        TreeNode pre = null;
        Stack<TreeNode> st = new Stack();
        while(root!=null || !st.isEmpty()){
            while(root!=null){
                st.add(root);
                root = root.left;
            }
            root = st.pop();
            if(pre!=null && pre.val>root.val && tn1==null)
                tn1 = pre;
            if(pre!=null && pre.val>root.val && tn1!=null)   //可能被执行多次  eg  3 2 1  tn2 先被赋值2 后被赋值1
                tn2 = root;
            pre = root;
            root = root.right;
        }
    }
}
