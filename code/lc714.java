package code;
/*
 * 714. Best Time to Buy and Sell Stock with Transaction Fee
 * 题意：买卖股票，不限次数，但有交易费用，求最大利润
 * 难度：Medium
 * 分类：Array, Dynamic Programming, Greedy
 * 思路：和309思路一致，每次卖出的时候减去交易费用
 *      buy[i] = max( buy[i-1], sell[i-1]-price[i] )
 *      sell[i] = max( sell[i-1], buy[i-1]+price[i]-2 )
 * Tips：
 *      总结一下买卖股票的问题  交易1次，2次，任意多次都可在O(N)完成交易
 *      交易k次时，时间复杂度为O(NM),M为交易次数
 *      冷却时间和交易费用的解法一致，都是分买和卖两个状态，进行dp
 */
public class lc714 {
    public int maxProfit(int[] prices, int fee) {
        if(prices.length==0) return 0;
        int b1 = -prices[0];
        int s1=0, b = 0, s = 0;
        for (int i = 0; i < prices.length ; i++) {
            b = Math.max(b1, s1-prices[i]);
            s = Math.max(s1, b1+prices[i]-fee);
            s1 = s;
            b1 = b;
        }
        return Math.max(s,b);
    }
}
