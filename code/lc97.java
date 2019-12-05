package code;
/*
 * 97. Interleaving String
 * 题意：两个字符串，穿插成第三个字符串
 * 难度：Hard
 * 分类：String, Dynamic Programming
 * 思路：递归+记忆；动态规划
 * Tips：dp空间还可以压缩
 *       注意字符串下标index
 */
public class lc97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length()) return false;
        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
        for(int i=0; i<=s1.length(); i++){  //从0到<=
            for(int j=0; j<=s2.length(); j++){
                if(i==0&&j==0) dp[i][j]=true;
                else if(i==0) dp[i][j] = (s3.charAt(i+j-1)==s2.charAt(j-1)&&dp[i][j-1]);    //注意减一
                else if(j==0) dp[i][j] = (s3.charAt(i+j-1)==s1.charAt(i-1)&&dp[i-1][j]);
                else dp[i][j] = s3.charAt(i+j-1)==s2.charAt(j-1)&&dp[i][j-1] || s3.charAt(i+j-1)==s1.charAt(i-1)&&dp[i-1][j];
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
