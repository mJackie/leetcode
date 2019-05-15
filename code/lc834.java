package code;

import java.util.HashMap;
import java.util.HashSet;
/*
 * 834. Sum of Distances in Tree
 * 题意：求树中每个节点的值，到其他节点的距离和
 * 难度：Hard
 * 分类：Tree, Depth-first Search
 * 思路：真的难，我是做不出来
 *      两次遍历，第一次后续遍历，计算出每个节点为根的树，有几个孩子节点，并计算出root的结果
 *      根据前一步的计算结果，开始先序遍历，一步步计算出其他节点的结果
 *      res[node] = res[parent]-2*count[node]+count.length;
 *      https://leetcode.com/problems/sum-of-distances-in-tree/discuss/130583/C%2B%2BJavaPython-Pre-order-and-Post-order-DFS-O(N)
 *      https://leetcode.com/problems/sum-of-distances-in-tree/discuss/130567/Two-traversals-O(N)-python-solution-with-Explanation
 * Tips：
 */
public class lc834 {
    public static void main(String[] args) {
        int[][] arr = {{0,1},{0,2},{2,3},{2,4},{2,5}};
        sumOfDistancesInTree(6, arr);
    }

    static int[] count;
    static int[] res;
    static HashMap<Integer, HashSet<Integer>> hm = new HashMap();
    public static int[] sumOfDistancesInTree(int N, int[][] edges) {
        if(edges.length==0) return new int[]{0};
        count = new int[N]; //记录n为跟的树，下边有多少个节点
        res = new int[N];
        for (int i = 0; i < edges.length ; i++) {   //双向都添加，遍历的时候判断一下，因为并不一定0就是根
            HashSet<Integer> hs = hm.getOrDefault(edges[i][0], new HashSet());
            hs.add(edges[i][1]);
            hm.put(edges[i][0], hs);
            hs = hm.getOrDefault(edges[i][1], new HashSet());
            hs.add(edges[i][0]);
            hm.put(edges[i][1], hs);
        }
        helper1(0, -1);
        helper2(0, -1);
        return res;
    }

    public static int helper1(int node, int parent){ //后序遍历，求root对应的结果，计算每个节点的count
        HashSet<Integer> hs = hm.getOrDefault(node, new HashSet());
        for (Integer i:hs) {
            if(i==parent) continue;     //是parent的话直接略过
            count[node] += helper1(i, node);
            res[node] += res[i] + count[i];
        }
        count[node]++;
        return count[node];
    }

    public static void helper2(int node, int parent){   //先序遍历，求结果
        HashSet<Integer> hs = hm.getOrDefault(node, new HashSet());
        if(node!=0)
            res[node] = res[parent]-2*count[node]+count.length; //转移计算
        for (Integer i:hs) {
            if(i==parent) continue; //是parent的话直接略过
            helper2(i, node);
        }
    }
}
