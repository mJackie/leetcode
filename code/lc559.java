package code;

import java.util.List;

/*
 * 559. Maximum Depth of N-ary Tree
 * 题意：多叉树的最大深度
 * 难度：Easy
 * 分类：Tree, Depth-first Search, Breadth-first Search
 * 思路：BFS 也能做和 lc104思路一样
 * Tips：lc104, lc111
 */

public class lc559 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public int maxDepth(Node root) {
        if(root==null) return 0;
        int res = 0;
        for (Node nd : root.children) {
            res = Math.max(maxDepth(nd), res);
        }
        return res+1;
    }

}
