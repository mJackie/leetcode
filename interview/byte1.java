package interview;

import java.util.Scanner;

public class byte1 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int res = Integer.MIN_VALUE;
        int[] dp = new int[n];
        dp[0] = arr[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i-1], arr[i]+i);
        }
        for (int i = 1; i < n ; i++) {
            res = Math.max(arr[i]-i+dp[i-1], res);
        }
        System.out.println(res);
    }

    public static void main2 (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int res = 0;
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < i ; j++) {
                int temp = arr[i]+arr[j]-i+j;
                res = Math.max(res, temp);
            }
        }
        System.out.println(res);
    }
}

