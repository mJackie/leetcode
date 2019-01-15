package code;
/*
 * 312. Burst Balloons
 * 题意：踩气球，求怎样踩，值最大
 * 难度：Hard
 * 分类：Divide and Conquer, Dynamic Programming
 * 思路：假设第n个气球是最后一个被踩爆，则从第n个气球开始，数组可以分为无前后相关性的两块
 * Tips：太难了，弃疗了，不会写。直接粘答案。
 */
public class lc312 {
    public static void main(String[] args) {
        System.out.println(maxCoins(new int[]{3,1,5,8}));
    }
    public static int maxCoins(int[] iNums) {
        int[] nums = new int[iNums.length + 2];
        int n = 1;
        for (int x : iNums) if (x > 0) nums[n++] = x;
        nums[0] = nums[n++] = 1;


        int[][] memo = new int[n][n];
        int res =  burst(memo, nums, 0, n - 1);
        return res;
    }

    public static int burst(int[][] memo, int[] nums, int left, int right) {
        if (left + 1 == right) return 0;
        if (memo[left][right] > 0) return memo[left][right];
        int ans = 0;
        for (int i = left + 1; i < right; ++i)
            ans = Math.max(ans, nums[left] * nums[i] * nums[right]
                    + burst(memo, nums, left, i) + burst(memo, nums, i, right));
        memo[left][right] = ans;
        return ans;
    }

}
