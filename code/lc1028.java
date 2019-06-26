package code;

import java.util.Stack;
/*
 * 1028. Recover a Tree From Preorder Traversal
 * 题意：从先序遍历恢复二叉树
 * 难度：Hard
 * 分类：Depth-first Search
 * 思路：用栈存储，迭代比较就可以了
 * Tips：
 */
public class lc1028 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    public TreeNode recoverFromPreorder(String S) {
        int level, val;
        Stack<TreeNode> stack = new Stack<>();
        for (int i = 0; i < S.length();) {
            for (level = 0; S.charAt(i) == '-'; i++) {
                level++;
            }
            for (val = 0; i < S.length() && S.charAt(i) != '-'; i++) {  //数字可能是大于9
                val = val * 10 + (S.charAt(i) - '0');
            }
            while (stack.size() > level) {  //用stack的size和depth比就可以了
                stack.pop();
            }
            TreeNode node = new TreeNode(val);
            if (!stack.isEmpty()) {
                if (stack.peek().left == null) {
                    stack.peek().left = node;
                } else {
                    stack.peek().right = node;
                }
            }
            stack.add(node);
        }
        while (stack.size() > 1) {
            stack.pop();
        }
        return stack.pop();
    }
}
