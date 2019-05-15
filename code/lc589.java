package code;

import java.util.ArrayList;
import java.util.List;

/*
 * 589. N-ary Tree Preorder Traversal
 * 题意：多叉树先序遍历
 * 难度：Easy
 * 分类：Tree
 * 思路：
 * Tips：
 */
public class lc589 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    List<Integer> res;
    public List<Integer> preorder(Node root) {
        res = new ArrayList<>();
        helper(root);
        return res;
    }

    public void helper(Node root){
        if(root==null) return;
        res.add(root.val);
        for(Node nd:root.children){
            helper(nd);
        }
    }
}
