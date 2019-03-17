package code;

/*
 * 31. Search in Rotated Sorted Array
 * 题意：在翻转有序数组中查找指定数
 * 难度：Medium
 * 分类：Array, Binary Search
 * 思路：二分查找的思路，多了一步判断，判断哪部分有序，是否在这部分中
 * Tips：注意边界判断，是否有等号。挺麻烦的，没有输入样本，很难想通边边角角
 *       lc81
 */
public class lc33 {
    public static void main(String[] args) {
        int[] nums = {1,3};
        System.out.println(search(nums, 3));
    }

    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        while(start<=end){
            if(start==end){
                if(nums[start]==target)
                    return start;
                return -1;
            }
            int mid = (start+end)/2;
            if(target == nums[mid])
                return mid;
            if(nums[mid]>nums[end]){//左边是有序的
                if(nums[start]<=target && target<=nums[mid])
                    end = mid-1;
                else
                    start = mid+1;
            }else{//右边是有序的
                if(nums[mid]<=target && target<=nums[end])
                    start = mid+1;
                else
                    end =mid-1;
            }
        }
        return -1;
    }

    public int search2(int[] nums, int target) {
        int begin = 0, end = nums.length-1;
        while(begin<=end){
            int mid = (begin+end)/2;
            if(target==nums[mid]) return mid;
            if(nums[begin]<=nums[mid]){  //左边有序，别忘了=，begin==end
                if(target>=nums[begin]&&target<nums[mid]){
                    end = mid-1;
                }else{
                    begin = mid+1;
                }
            }else{  //右边有序
                if(target>nums[mid]&&target<=nums[end]){ //别忘了=
                    begin = mid+1;
                }else{
                    end = mid-1;
                }
            }
        }
        return -1;
    }
}
