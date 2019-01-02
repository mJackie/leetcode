package code;
/*
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 * 题意：根据先序和中序，构造二叉树
 * 难度：Medium
 * 分类：Array, Tree, Depth-first Search
 * 思路：通过递归的方式，找左节点和右节点
 * Tips：思路记一下，自己想不起来
 */
public class lc105 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {

    }

    public TreeNode Recursion(int[] preorder, int[] inorder, int val, int start, int end){   //start,end代表在inorder上搜索的范围
        if(start>end || start >inorder.length)
            return null;
        for (int i = 0; i < ; i++) {
            
        }
    }
}
