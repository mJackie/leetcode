package code;

import java.util.Arrays;
/*
 * 213. House Robber II
 * 题意：数组最大和，不能选取相邻的两个数。数组首尾是连着的
 * 难度：Medium
 * 分类：Dynamic Programming
 * 思路：分别把第一个元素置0和最后一个元素置0，用lc198的解法
 *
 * Tips：lc198
 */
public class lc213 {
    public int rob(int[] nums) { //分别把第一个元素置0和最后一个元素置0，用lc198的解法
        if(nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];
        int res1 = helper(Arrays.copyOf(nums, nums.length-1));
        nums[0] = 0;
        int res2 = helper(nums);
        return Math.max(res1, res2);
    }

    public int helper(int[] nums) {
        if(nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length ; i++) {
            dp[i] = Math.max((dp[i-2] + nums[i]),dp[i-1]);  //dp[i] 表示以 0~i 的数组的结果
        }
        return dp[nums.length-1];
    }
}
