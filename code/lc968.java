package code;
/*
 * 968. Binary Tree Cameras
 * 题意：在树上放置camera, 覆盖整棵树，一个camera可以监视自身，父节点和孩子节点，问最少camera数量
 * 难度：Hard
 * 分类：Dynamic Programming, Tree, Depth-first Search
 * 思路：贪心算法，尽量让父节点放置
 * Tips：
 */
public class lc968 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    int res;
    public int minCameraCover(TreeNode root) {
        if(root==null) return 0;
        int flag = dfs(root);
        if(flag==3) return res+1; //如果是3，代表root没被覆盖
        return res;
    }

    public int dfs(TreeNode tn){
        // 1代表被覆盖了，但该点没有camera。left,right都不为3的话，贪心算法，父节点不需要放置
        // 2代表被覆盖了，该点有camera，父节点不需要放置
        // 3代表没有被覆盖，所以父节点要放置
        if(tn==null) return 1;
        int left = dfs(tn.left);
        int right = dfs(tn.right);
        if( left==3 || right==3){
            res+=1; //在该节点放置
            return 2;
        }
        if( left==2 || right==2 ) return 1;
        return 3;
    }
}
