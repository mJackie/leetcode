package code;

import java.util.Arrays;

/*
 * 493. Reverse Pairs
 * 题意：逆序对
 * 难度：Hard
 * 分类：Binary Search, Divide and Conquer, Sort, Binary Indexed Tree, Segment Tree
 * 思路：归并排序的思路 或者 树相关的数据结构
 *      排序前先count
 *      负数怎么解决？ 不用考虑，因为排序前先count
 * Tips：lc315
 */
public class lc493 {
    public static void main(String[] args) {
        reversePairs(new int[]{1,3,2,3,1});
        System.out.println(res);
    }

    static int res = 0;
    public static int reversePairs(int[] nums) {
        mergeSort(nums, 0, nums.length-1);
        return res;
    }

    public static void mergeSort(int[] nums, int left, int right){
        if(left<right){
            int mid = (left + right)/2;
            mergeSort(nums, left, mid);
            mergeSort(nums, mid+1, right);
            merge(nums, left, mid, right);
        }
    }

    public static void merge(int[] nums, int left, int mid, int right){
        //count elements
        int pos1 = left;
        int pos2 = mid+1;
        int count = 0;
        while(pos1<=mid){       //双指针 统计逆序对
            if(pos2>right||nums[pos1]<=(double)nums[pos2]*2) {
                pos1++;
                res+=count;
            }
            else{
                pos2++;
                count++;
            }
        }

        Arrays.sort(nums, left, right + 1);

//        int[] nums_copy = nums.clone();     //耗时，大样例过不了
//        pos1 = left;    //注意pos1, pos2重新赋值
//        pos2 = mid+1;
//        int cur = left;
//        while( pos1<=mid && pos2<=right ){
//            if(nums_copy[pos1]<=nums_copy[pos2]){
//                nums[cur] = nums_copy[pos1];
//                pos1++;
//                cur++;
//            } else {
//                nums[cur] = nums_copy[pos2];
//                pos2++;
//                cur++;
//            }
//        }
//        while(pos1<=mid){
//            nums[cur] = nums_copy[pos1];
//            cur++;
//            pos1++;
//        }
//        while(pos2<=right){
//            nums[cur] = nums_copy[pos2];
//            cur++;
//            pos2++;
//        }
    }


}
