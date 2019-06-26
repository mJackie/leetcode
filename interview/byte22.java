package interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class byte22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        String[] str_arr = str2.split(" ");
        List<String> str_list = new ArrayList<>();
        for(String s : str_arr) str_list.add(s);
        System.out.println(helper(str1, str_list));
    }



    public static String helper(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i = 1; i < dp.length ; i++) {
            for (int j = 0; j < i ; j++) {  //遍历之前计算出来的结果
                if( dp[j]==true && wordDict.contains(s.substring(j,i)))
                    dp[i] = true;
            }
        }
        if(dp[s.length()]) return "True";
        return "Fales";
    }

}
