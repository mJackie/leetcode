package code;
/*
 * 912. Sort an Array
 * 题意：数组排序
 * 难度：Medium
 * 分类：
 * 思路：
 * Tips：注意和lc215区别
 *      lc215
 */
public class lc912 {
    public static void main(String[] args) {
        int[] arr = sortArray2(new int[]{5,2,3,1});
        for(int i: arr){
            System.out.println(i);
        }
    }

    // 快排
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length-1);
        return nums;
    }
    public void quickSort(int[] nums, int left, int right){
        if(left>=right) return; //注意返回
        int l = left;
        int r = right;
        int pivot = nums[left];
        while(left<right){
            while(left<right && nums[right]>=pivot) right--;
            int temp = nums[right]; nums[right] = nums[left]; nums[left]=temp;  //交换
            while(left<right && nums[left]<pivot ) left++;
            temp = nums[right]; nums[right] = nums[left]; nums[left]=temp;
        }
        nums[left] = pivot;
        quickSort(nums, left+1, r);
        quickSort(nums, l, right-1);
    }

    // 归并
    public static int[] sortArray2(int[] nums) {
        mergeSort(nums, 0, nums.length-1);
        return nums;
    }
    public static void mergeSort(int[] nums, int left, int right){
        if(left<right) {
            int mid = (left+right)/2;
            mergeSort(nums, left, mid);
            mergeSort(nums, mid+1, right);
            merge(nums, left, mid, right);
        }
    }
    public static void merge(int[] nums, int left, int mid, int right){
        int[] temp = nums.clone();  //记住这个方法
        int cur = left;
        int pos1 = left;
        int pos2 = mid+1;
        while(pos1<=mid && pos2<=right){
            if(temp[pos1]<temp[pos2]) { //注意是temp 复制后的
                nums[cur] = temp[pos1];
                pos1++;
                cur++;
            }
            else {
                nums[cur] = temp[pos2];
                pos2++;
                cur++;
            }
        }
        while(pos1<=mid){
            nums[cur] = temp[pos1];
            pos1++;
            cur++;
        }
        while(pos2<=right){
            nums[cur] = temp[pos2];
            pos2++;
            cur++;
        }
    }
}
