package code;
/*
 * 121. Best Time to Buy and Sell Stock
 * 题意：股票买卖1次，最大利润
 * 难度：Easy
 * 分类：Arryas, Dynamic Programming
 * Tips：lc121, lc309, lc188, lc123, lc714
 */
public class lc121 {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE, res=0;
        for(int i=0; i<prices.length; i++){
            min = Math.min(min, prices[i]);
            res = Math.max(res, prices[i]-min);
        }
        return res;
    }
}
