package code;
/*
 * 139. Word Break
 * 题意：是否能够分词
 * 难度：Medium
 * 分类：Dynamic Programming
 * 思路：动态规划
 * Tips：巧妙的方法，防止了复杂的操作，通过遍历之前计算出来的结果
 *       递归的方法本质和dp是一样的，记住用备忘录算法，把之前的结果记下来
 *       lc140
 */
import java.util.HashMap;
import java.util.List;

public class lc139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i = 1; i < dp.length ; i++) {
            for (int j = 0; j < i ; j++) {  //遍历之前计算出来的结果
                if( dp[j]==true && wordDict.contains(s.substring(j,i)))
                    dp[i] = true;
            }
        }
        return dp[s.length()];
    }

    HashMap<String, Boolean> hm = new HashMap();
    public boolean wordBreak2(String s, List<String> wordDict) {
        if(hm.containsKey(s)) return hm.get(s);
        if(s.length() == 0) return true;
        Boolean flag = false;
        for(String word:wordDict){
            if(s.startsWith(word)) flag = flag||wordBreak(s.substring(word.length()), wordDict);    //注意函数 startsWith
        }
        hm.put(s, flag);
        return flag;
    }
}
