package code;
/*
 * 122. Best Time to Buy and Sell Stock III
 * 题意：买卖股票最大利润，只能买卖2次
 * 难度：Hard
 * 分类：Array, Dynamic Programming
 * 思路：两种思路，第一种是分成两块，每块按lc121的算法进行计算，最后合并结果
 *      第二种思路设置4个变量，分别为第一次买，第一次卖，第二次买，第二次卖的价格
 * Tips：只想到了O(N^2)的方法
 *      lc121, lc309, lc188, lc123, lc714
 */
public class lc123 {
    public int maxProfit(int[] prices) {
        int buy1 = Integer.MAX_VALUE, buy2 = Integer.MAX_VALUE, sell1 = 0, sell2 = 0;
        for (int i = 0; i < prices.length ; i++) {
            buy1 = Math.min(buy1, prices[i]);   //第一次购买的最低价格
            sell1 = Math.max(sell1, prices[i] - buy1);
            buy2 = Math.min(buy2, prices[i]-sell1); //记住第二项 prices[i]-sell1
            sell2 = Math.max(sell2, prices[i]-buy2);    //当只购买一次时，会传递的
        }
        return sell2;
    }

    public int maxProfit2(int[] prices) {   //常规方法，分为两块，O(N^2)
        int res = 0;
        for (int i = 0; i <prices.length ; i++) {
            int res1 = Math.max(0, helper(prices,0,i));
            int res2 = Math.max(0, helper(prices, i, prices.length));
            res = Math.max(res, res1+res2);
        }
        return res;
    }
    public int helper(int[] prices, int begin, int end) {
        int min = Integer.MAX_VALUE, res=0;
        for(int i=begin; i<end; i++){
            min = Math.min(min, prices[i]);
            res = Math.max(res, prices[i]-min);
        }
        return res;
    }
}
