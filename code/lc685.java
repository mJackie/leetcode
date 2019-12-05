package code;
/*
 * 685. Redundant Connection II
 * 题意：一个图，删掉一个边，使其成为一个根树
 * 难度：Hard
 * 分类：Tree, Depth-first Search, Union Find, Graph
 * 思路：要把问题想清楚
 *      判断是否有某个节点父节点有两个, 记为e1, e2
 *      再判断是否有环
 *      4种情况，分别想清楚返回什么
 *      自己没想清楚两种情况的交叉，以为判断完第一步就可直接返回
 *      如何判断有环，可以利用并查集的思想
 * Tips：https://leetcode.com/problems/redundant-connection-ii/discuss/108045/C%2B%2BJava-Union-Find-with-explanation-O(n)
 */
public class lc685 {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] can1 = {-1, -1};
        int[] can2 = {-1, -1};
        int[] parent = new int[edges.length + 1];
        for (int i = 0; i < edges.length; i++) {
            if (parent[edges[i][1]] == 0) {
                parent[edges[i][1]] = edges[i][0];
            } else {
                can2 = new int[] {edges[i][0], edges[i][1]};
                can1 = new int[] {parent[edges[i][1]], edges[i][1]};
                edges[i][1] = 0;
            }
        }
        for (int i = 0; i < edges.length; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < edges.length; i++) {
            if (edges[i][1] == 0) {
                continue;
            }
            int child = edges[i][1], father = edges[i][0];
            if (root(parent, father) == child) {    //判断father的父节点是不是child
                if (can1[0] == -1) {
                    return edges[i];
                }
                return can1;
            }
            parent[child] = father;
        }
        return can2;
    }

    int root(int[] parent, int i) {
        while (i != parent[i]) {    //找到根为止
            parent[i] = parent[parent[i]];
            i = parent[i];
        }
        return i;
    }
}
