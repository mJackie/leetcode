package code;
/*
 * 978. Longest Turbulent Subarray
 * 题意：小，大，小，大 这种最大长度是多少
 * 难度：Medium
 * 分类：Array, Dynamic Porgramming, Sliding Windows
 * 思路：O(n) 遍历一遍就能解决，不用dp
 * Tips：lc53
 */
public class lc978 {
    public int maxTurbulenceSize(int[] A) {
        int inc = 1, dec = 1, result = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] < A[i - 1]) {  // +1 并且重置另一个统计量
                dec = inc + 1;
                inc = 1;
            } else if (A[i] > A[i - 1]) {
                inc = dec + 1;
                dec = 1;
            } else {
                inc = 1;
                dec = 1;
            }
            result = Math.max(result, Math.max(dec, inc));
        }
        return result;
    }
}
