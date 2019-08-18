package code;
/*
 * 153. Find Minimum in Rotated Sorted Array
 * 题意：反转数组找最小值
 * 难度：Medium
 * 分类：Array, Binary Search
 * 思路：想清楚，不用那么多判断
 * Tips：边界条件想清楚
 *       nums[mid]和nums[right]比就行了
 */
public class lc153 {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while(left<right){
            int mid = (left+right)/2;
            if(nums[mid]<nums[right]){
                right = mid;    //这不加1
            }else{
                left = mid+1;
            }
        }
        return nums[left];
    }
}
