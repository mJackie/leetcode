package code;

import java.util.Arrays;
/*
 * 16. 3Sum Closest
 * 题意：找出3个数的和最接近target
 * 难度：Medium
 * 分类：Array, Two Pointers
 * 思路：3sum的思路，每次记下最接近的res即可
 * Tips：
 */
public class lc16 {
    public int threeSumClosest(int[] nums, int target) {
        int res = nums[0]+nums[1]+nums[2];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2 ; i++) {
            int start = i+1;
            int end = nums.length-1;
            while(start<end){
                int sum = nums[i] + nums[start] + nums[end];
                if(sum==target) return target;
                else if(sum<target) start++;
                else if(sum>target) end--;
                if(Math.abs(sum-target)<Math.abs(res-target)) res = sum;
            }
        }
        return res;
    }
}
