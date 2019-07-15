package code;
import java.util.Arrays;

/*
 * 132. Palindrome Partitioning II
 * 题意：最少切几刀，回文串
 * 难度：Hard
 * 分类：Dynamic Programming
 * 思路：和lc300思路很像，只是多了判断。dp[i]表示从0到i这一段切法的最小值，每次遍历前边的结果，看能否接上。
 *      可以把判断回文和dp两个合并，因为用dp的形式判断回文
 * Tips：lc300
 *      bingo!
 */

public class lc132 {
    public int minCut(String s) {
        int[] dp = new int[s.length()+1];
        Arrays.fill(dp, s.length());    //fill最大值
        dp[0] = 0;
        for(int i=1; i<dp.length; i++){
            for(int j=0; j<=i; j++){    //注意<=
                if(dp[j]!=s.length() && isPalindrome(s.substring(j,i)))
                    dp[i] = Math.min(dp[i], dp[j]+1);
            }
        }
        return dp[s.length()]-1; //要-1 最后一刀是在末尾
    }

    public Boolean isPalindrome(String str){
        if(new StringBuilder(str).reverse().toString().equals(str)) return true;   //reverse一下
        else return false;
    }

    public int minCut2(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        int[] cut = new int[n];
        boolean[][] pal = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            int min = i;
            for(int j = 0; j <= i; j++) {
                if(c[j] == c[i] && (j + 1 > i - 1 || pal[j + 1][i - 1])) {
                    pal[j][i] = true;
                    min = j == 0 ? 0 : Math.min(min, cut[j - 1] + 1);
                }
            }
            cut[i] = min;
        }
        return cut[n - 1];
    }
}
