package interview;

import java.util.Scanner;

public class bk4 {
    public static void main(String[] args) {
        //int[] arr = new int[]{1,4,3,2,5};
        int[] arr = new int[]{1,2,3,4,5,8};
        //int[] arr = new int[]{8,7,6,5,4,3};
        System.out.println(func(arr));
    }
    public static int func(int[] arr){
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int cur = 0;
            int max1 = -1;
            int j = 0;
            for (; j < i; j++) {
                max1 = Math.max(max1+1, j>0?arr[j-1]:0);
                cur += Math.max(max1 - arr[j]+1, 0);
            }
            max1 = Math.max(max1, j>0?arr[j-1]:0);
            int max2 = -1;
            j = arr.length-1;
            for (; j>i ; j--) {
                max2 = Math.max(max2+1, j<arr.length-1?arr[j+1]:0);
                cur += Math.max(max2 - arr[j] + 1, 0);
            }
            max2 = Math.max(max2, j<arr.length-1?arr[j+1]:0);
            cur += Math.max(Math.max(max1, max2) + 1 - arr[i], 0);
            res = Math.min(res, cur);
        }
        return res;
    }

    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [] nums = new int [n];
        for(int i = 0; i < n; i ++) {
            nums[i] = scanner.nextInt();
        }
        int [] temp = new int [n];
        for(int i = 0; i < n; i ++) {
            temp[i] = nums[i];
        }
        int count = Integer.MAX_VALUE;
        int sum = 0;
        for(int i = 1; i < n; i ++) {
            if(nums[i] <= nums[i - 1]) {
                sum += nums[i - 1] + 1 - nums[i];
                nums[i] = nums[i - 1] + 1;
            }
        }
        if(sum < count)
            count = sum;
        for(int i = 0; i < n; i ++) {
            nums[i] = temp[i];
        }
        sum = 0;
        for(int j = n - 2; j >= 0 ; j --) {
            if(nums[j] <= nums[j + 1]) {
                sum += nums[j + 1] + 1 - nums[j];
                nums[j] = nums[j + 1] + 1;
            }
        }
        if(sum < count)
            count = sum;
        for(int i = 0; i < n; i ++) {
            nums[i] = temp[i];
        }
        for(int i = 1; i < n - 1; i ++) {
            sum = 0;
            int j = 1;
            for(; j < i; j ++) {
                if(nums[j] <= nums[j - 1]) {
                    sum += nums[j - 1] + 1 - nums[j];
                    nums[j] = nums[j - 1] + 1;
                }
            }
            j --;
            int k = n - 2;
            for(; k > i; k--) {
                if(nums[k] <= nums[k + 1]) {
                    sum += nums[k + 1] + 1 - nums[k];
                    nums[k] = nums[k + 1] + 1;
                }
            }
            k ++;
            int res = Math.max(nums[j], nums[k]);
            if(nums[i] <= res) {
                sum += res + 1 - nums[i];
            }
            if(sum < count)
                count = sum;
            for(int l = 0; l < n; l ++) {
                nums[l] = temp[l];
            }
        }
        System.out.println(count);
    }
}
