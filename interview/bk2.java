package interview;

public class bk2 {
    public static void main(String[] args) {
        
    }

    public int lengthOfLIS2(int[] nums) {
        if(nums.length<2)
            return nums.length;
        int size = 0;   //size指dp中递增的长度。  dp[0~i] 表示了长度为 i+1 的递增子数组，且最后一个值是最小值
        int[] dp = new int[nums.length];    //dp存储递增的数组，之后更新这个数组。如果x>最后一个值，则插入到末尾，否则更新对应位置上的值为该值。
        for (int i = 0; i < nums.length ; i++) {
            int left = 0;
            int right = size;
            while(left!=right){ //得到要插入的位置
                int mid = (left+right)/2;
                if(dp[mid]<nums[i])
                    left = mid+1;
                else
                    right = mid;
            }
            dp[left] = nums[i];
            if(left==size) size++;
        }
        return size;
    }
}
