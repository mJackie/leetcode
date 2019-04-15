package code;
/*
 * 1027. Longest Arithmetic Sequence
 * 题意：最长等差数列
 * 难度：Medium
 * 分类：Dynamic Programming
 * 思路：还是要在每个位置上都记录一下，不是说一个大的数组就可以了。因为相同长度的等差，后续数字往上接的时候不一定接哪一个，都要保存，并不是说一定去接小的那个。
 *      二维dp, 一维记录位置，一维记录差分
 * Tips：很棒的题
 */
public class lc1027 {
    public static int longestArithSeqLength(int[] A) {
        int res = 0;
        int[][] dp = new int[A.length][20000];
        for (int i = 0; i < A.length ; i++) {
            for (int j = 0; j < i ; j++) {
                int ind = A[i]-A[j]+10000;
                dp[i][ind] = dp[j][ind] + 1;
                res = Math.max(res, dp[i][ind]);
            }
        }
        return res+1; //加1
    }
}
