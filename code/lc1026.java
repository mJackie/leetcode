package code;
/*
 * 1025. Maximum Difference Between Node and Ancestor
 * 题意：父节点减子节点的绝对值最大
 * 难度：
 * 分类：
 * 思路：自己写的自下向上，返回的时候再计算。
 *      可以自顶向下的，把路径上的最大值和最小值传到叶子节点，到叶子节点再计算
 * Tips：
 */
public class lc1026 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    int res_val = 0;
    public int maxAncestorDiff(TreeNode root) {
        helper(root);
        return res_val;
    }

    public int[] helper(TreeNode root){
        int[] res = new int[2]; //存一个最大，一个最小
        if(root.left==null&&root.right==null){
            res[0] = root.val;
            res[1] = root.val;
            return res;
        }
        int[] left = new int[2];
        int[] right = new int[2];
        left[0] = Integer.MIN_VALUE;
        right[0] = Integer.MIN_VALUE;
        left[1] = Integer.MAX_VALUE;
        right[1] = Integer.MAX_VALUE;
        if(root.left!=null) left = helper(root.left);   //可能为空，只有一边有节点
        if(root.right!=null) right = helper(root.right);
        res_val = Math.max(Math.abs(root.val - Math.max(left[0], right[0])), res_val);
        res_val = Math.max(Math.abs(root.val - Math.min(left[1], right[1])), res_val);
        res[0] = Math.max(Math.max(left[0], right[0]), root.val);   //别忘了和root节点本身的值比
        res[1] = Math.min(Math.min(left[1], right[1]), root.val);
        return res;
    }

    public int maxAncestorDiff2(TreeNode root) {
        return dfs(root, root.val, root.val);
    }

    public int dfs(TreeNode root, int mn, int mx) {
        if (root == null) return mx - mn;
        mx = Math.max(mx, root.val);
        mn = Math.min(mn, root.val);
        return Math.max(dfs(root.left, mn, mx), dfs(root.right, mn, mx));
    }
}
