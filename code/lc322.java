package code;
/*
 * 322. Coin Change
 * 题意：不同面额零钱组合成总值，用的零钱数最少
 * 难度：Medium
 * 分类：Dynamic Programming
 * 思路：和lc279一样的思路，注意下没解的情况
 * Tips：不用Set, 加一个dp[0]=0，可以直接递归出结果
 */
import java.util.Arrays;
import java.util.HashSet;

public class lc322 {
    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{2}, 3));
    }
    public static int coinChange(int[] coins, int amount) {
        if(amount==0) return 0;
        int[] dp = new int[amount];
        Arrays.fill(dp, Integer.MAX_VALUE);
        HashSet<Integer> s = new HashSet();
        for (int i = 0; i < coins.length ; i++) {
            s.add(coins[i]);
        }
        for (int i = 0; i < amount ; i++) {
            if(s.contains(i+1))
                dp[i] = 1;
            else{
                for (int j = 0; j < coins.length ; j++) {
                    if( i+1-coins[j]>0 && dp[i - coins[j]]!=Integer.MAX_VALUE ) {   // 注意子结构没解的情况
                        dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
                    }
                }
            }
        }
        return dp[amount-1]==Integer.MAX_VALUE ? -1 : dp[amount-1];     //没解返回-1
    }

    public static int coinChange2(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);   //表示无解
        dp[0] = 0;  //dp[0]=0 不用先把零钱设为1了
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];   //判断一下
    }
}
