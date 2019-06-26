package code;
/*
 * 81. Search in Rotated Sorted Array II
 * 题意：在翻转有序数组中查找指定数，数组中可能有相等的元素
 * 难度：Medium
 * 分类：Array, Binary Search
 * 思路：多加了一种情况，就是 nums[mid]==nums[begin]==nums[end]
 * Tips：注意边界判断，是否有等号
 *       lc33
 */
public class lc81 {
    public boolean search(int[] nums, int target) {
        int begin = 0, end = nums.length-1;
        while(begin<=end){
            int mid = (begin+end)/2;
            if(target==nums[mid]) return true;
            if(nums[begin]==nums[end]&& nums[end]==nums[mid]) end--;
            else if(nums[begin]<=nums[mid]){  //左边有序
                if(target>=nums[begin]&&target<nums[mid]){
                    end = mid-1;
                }else{
                    begin = mid+1;
                }
            }else if(nums[mid]<nums[end]){  //右边有序
                if(target>nums[mid]&&target<=nums[end]){
                    begin = mid+1;
                }else{
                    end = mid-1;
                }
            }else{
                end--;
            }
        }
        return false;
    }
}
