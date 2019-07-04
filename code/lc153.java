package code;
/*
 * 153. Find Minimum in Rotated Sorted Array
 * 题意：反转数组找最小值
 * 难度：Medium
 * 分类：Array, Binary Search
 * 思路：
 * Tips：边界条件想清楚
 */
public class lc153 {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while(left<right){
            int mid = (left+right)/2;
            if(nums[left]<nums[mid]){   //左边有序
                if(nums[left]<nums[right]){ //在左边找
                    right = mid-1;
                }else{
                    left = mid;
                }
            }else{  //右边有序
                if(nums[right]<nums[mid]){  //边界条件想清楚
                    left = mid+1;
                }else{
                    right = mid;
                }
            }
        }
        return nums[left];
    }
}
