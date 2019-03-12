package code;

import java.util.List;
/*
 * 120. Triangle
 * 题意：三角形的矩阵，求值最小的路径
 * 难度：Medium
 * 分类：Array, Dynamic Porgramming
 * 思路：动态规划 dp[i] = min(dp[i-1],dp[i]) + val
 * Tips：
 */
public class lc120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.get(triangle.size()-1).size();
        int[] dp = new int[len];
        int[] dp2 = new int[len];
        int index = 0;
        int res = Integer.MAX_VALUE;
        while(index<triangle.size()){
            List<Integer> ls = triangle.get(index);
            res = Integer.MAX_VALUE;
            for (int i = 0; i < ls.size() ; i++) {
                if(i==0) dp2[i] = dp[i] + ls.get(i);
                else if(i==ls.size()-1) dp2[i] = dp[i-1] + ls.get(i);   //注意是 i==ls.size()-1
                else dp2[i] = Math.min(dp[i-1],dp[i]) + ls.get(i);
                res = Math.min(dp2[i], res);
            }
            dp = dp2;   //两个一维数组
            dp2 = new int[len];
            index++;
        }
        return res;
    }
}
