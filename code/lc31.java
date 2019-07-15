package code;
/*
 * 31. Next Permutation
 * 题意：找出排列组合的下一个排列
 * 难度：Medium
 * 分类：Array
 * 思路：从后往前找第一个变小的数x，从后往前找出比第一个x大的数，交换，再把之后的数逆序即可
 * Tips：很典型的排列组合题，思路方法记忆一下。注意比较时是否有=。
 */
public class lc31 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        nextPermutation(nums);
        for (int i:nums){
            System.out.println(i);
        }
    }

    public static void nextPermutation(int[] nums) {
        int ptr = nums.length-1;

        //从后往前找第一个变小的数x 从后往前找出比第一个x大的数
        while(ptr>0&&nums[ptr-1]>=nums[ptr]){// 注意是 >= {5,1,1} , 等于--
            ptr--;
        }
        ptr--;
        if(ptr!=-1){
            //从后往前，找比
            int val = nums[ptr];
            int ptr2 = nums.length-1;
            while(ptr2>ptr){
                if(nums[ptr2]>nums[ptr]) break;
                ptr2--;
            }
            nums[ptr] = nums[ptr2];
            nums[ptr2] = val;
        }

        //把之后的数逆序
        ReverseNums(nums,ptr+1,nums.length-1);  //+1，不包含ptr那个位置
    }
    public static void ReverseNums(int[] nums, int start, int end){
        int l = end+start;
        for (int i = start; i < (start+end+1)/2 ; i++) {
            int temp = nums[i];
            nums[i] = nums[l-i];
            nums[l-i] = temp;
        }
    }
}
