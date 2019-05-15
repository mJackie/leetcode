package code;

import java.util.ArrayList;
import java.util.List;

public class lc590 {
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
    public List<Integer> postorder(Node root) {
        res = new ArrayList<>();
        helper(root);
        return res;
    }

    public void helper(Node root){
        if(root==null) return;
        for(Node nd:root.children){
            helper(nd);
        }
        res.add(root.val);
    }
}
