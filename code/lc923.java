package code;
import java.util.Arrays;
import java.util.HashMap;

/*
 * 923. 3Sum With Multiplicity
 * 题意：3Sum有几种？数组中有重复数字
 * 难度：Medium
 * 分类：Two Pointers
 * 思路：由于本题只要求给出多少种Int值，所以不一定非要用3Sum的思路，有很多更简答的方法
 *      3种思路
 * Tips：
 */
public class lc923 {
    public int threeSumMulti(int[] A, int target) {
        int res = 0;
        HashMap<Integer, Integer> hm = new HashMap();
        for (int i = 0; i < A.length ; i++) {
            res = (res+hm.getOrDefault(target-A[i],0))%1000000007;  // i之前的数字，两个组合起来，是否 == target-A[i]
            for (int j = 0; j < i ; j++) {
                hm.put(A[i]+A[j], hm.getOrDefault(A[i]+A[j], 0)+1);
            }
        }
        return res;
    }
    public int threeSumMulti2(int[] A, int target) {    //3Sum的思路
        int res = 0;
        Arrays.sort(A);
        for (int i = 0; i < A.length-2 ; i++) {
            int left = i+1, right = A.length-1;
            while(left<right){
                if(A[i]+A[left]+A[right]<target) left++;
                else if(A[i]+A[left]+A[right]>target) right--;
                else if(A[left]==A[right]) {    //如果相等，则直接 C N 取 2，计算出来，然后break
                    res = (res + (right-left)*(right-left+1)/2)%1000000007;
                    break;  //不用继续移动指针了
                } else {
                    int leftcount = 1, rightcount = 1;
                    while(A[left]==A[left+1]) {
                        left++;
                        leftcount++;
                    }
                    while(A[right]==A[right-1]) {
                        right--;
                        rightcount++;
                    }
                    res = (res + leftcount*rightcount)%1000000007;
                    left++;     //别忘了，最后还要操作一下
                    right--;
                }
            }
        }
        return res;
    }

    public int threeSumMulti3(int[] A, int target) {    //直接数学计算
        long[] c = new long[101];
        for (int a : A) c[a]++;
        long res = 0;
        for (int i = 0; i <= 100; i++)  // 题目给了值不超过100
            for (int j = i; j <= 100; j++) {
                int k = target - i - j;
                if (k > 100 || k < 0) continue;
                if (i == j && j == k)
                    res += c[i] * (c[i] - 1) * (c[i] - 2) / 6;
                else if (i == j && j != k)
                    res += c[i] * (c[i] - 1) / 2 * c[k];
                else if (j < k)
                    res += c[i] * c[j] * c[k];
            }
        return (int)(res % (1e9 + 7));
    }
}
