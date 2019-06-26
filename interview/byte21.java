package interview;

import java.util.Scanner;

public class byte21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int b = sc.nextInt();
        int[][] dp = new int[5000][2];
        int i = 1;
        dp[0][0] = 1;
        dp[0][1] = 1;
        for (; i < 5000; i++) {
            if(w-i>=0){
                dp[i][0] = dp[i-1][0] + dp[i-1][1];//白
                w=w-i;
            }else{
                dp[i][0] = 0;
            }
            if(b-i>=0){
                dp[i][1] = dp[i-1][0] + dp[i-1][1];//黑
                b = b-i;
            }else{
                dp[i][1] = 0;
            }
            if(dp[i][0]==0&&dp[i][1]==0) break;
        }
        System.out.println(i-1);
        System.out.println(dp[i-1][0]+dp[i-1][1]);
    }
}
