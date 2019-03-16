package code;
/*
 * 35. Search Insert Position
 * 题意：找到数组中 target 插入的位置
 * 难度：
 * 分类：Array, Binary Search
 * 思路：二分查找
 * Tips：
 */
public class lc35 {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while(left<=right){
            int mid = (left + right)/2;
            if(nums[mid]==target) return mid;
            else if(nums[mid]<target) left = mid+1;
            else right = mid-1;
        }
        return left;
    }
}
