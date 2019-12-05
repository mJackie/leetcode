package code;
/*
 * 983. Minimum Cost For Tickets
 * 题意：两个数组，days代表那一天得去玩，costs表示玩1天，2天，7天的花费，问怎么玩可以把days覆盖，并且花费最少
 * 难度：Medium
 * 分类：Dynamic Programming
 * 思路：猛一看题，感觉很难
 *      想了以后，会发现就是典型的数组dp，难的地方主要在于数组不代表每天，如何把days中的天全部覆盖到
 *      方法是将days转换为一个365长的arr，代表每一天
 *      如果这一天不在days中，则 dp[i] = dp[i-1]， 否则 dp[i] = min(dp[i-1]+cost , dp[i-2]+cost ,dp[i-7]+cost )
 * Tips：
 */
public class lc983 {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[366];    //366,把0空出来
        int days_cur = 0;
        for (int i = 1; i < dp.length ; i++) {
            if(i==days[days_cur]) { //在days中
                int minCost = dp[Math.max(0, i-1)]+costs[0];
                minCost = Math.min( minCost, dp[Math.max(0, i-7)]+costs[1] );
                minCost = Math.min( minCost, dp[Math.max(0, i-30)]+costs[2] );
                dp[i] = minCost;
                if(days_cur<days.length-1) days_cur++;  //防止越界
            }else{
                dp[i] = dp[i-1];
            }
        }
        return dp[dp.length-1];
    }
}
