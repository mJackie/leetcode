package code;
/*
 * 188. Best Time to Buy and Sell Stock IV
 * 题意：买卖股票最大利润，可以买卖k次
 * 难度：Hard
 * 分类：Dynamic Programming
 * 思路：二维dp, dp[i][j] 表示i次交易，在数组prices[0~j]上的最大利润
 *      dp[i][j] = Max( dp[i][j-1], dp[i-1][jj]+prices[j]-prices[jj] )   { jj in range of [0, j-1] }
 *               = Max( dp[i][j-1], prices[j]+ max(dp[i-1][jj]-prices[jj]) ) 转化为这一步，少了一层循环
 *      dp[0][j] = 0;  dp[i][0] = 0;
 * Tips：lc121, lc309, lc188, lc123, lc714
 */
public class lc188 {
    public int maxProfit(int k, int[] prices) {
        if(prices.length==0) return 0;
        int n = prices.length;
        //if k >= n/2, then you can make maximum number of transactions.
        if (k >=  n/2) {
            int maxPro = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i-1])
                    maxPro += prices[i] - prices[i-1];
            }
            return maxPro;
        }

        int[][] dp = new int[k+1][prices.length];
        for (int i = 1; i <= k ; i++) {
            int localMax = -prices[0];
            for (int j = 1; j < prices.length ; j++) {  //jj的计算和这一维合并，总的复杂度是二次方而不是三次
                dp[i][j] = Math.max(dp[i][j-1], prices[j]+localMax);
                localMax = Math.max(localMax, dp[i-1][j]-prices[j]);
            }
        }
        return dp[k][prices.length-1];
    }
}
