package code;
/*
 * 51. N-Queens
 * 题意：8皇后问题
 * 难度：Hard
 * 分类：Backtracking
 * 思路：回溯+判断，注意怎么判断两个斜线方向
 * Tips：
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class lc51 {
    StringBuilder ss = new StringBuilder();
    HashSet<String> hs = new HashSet();
    public List<List<String>> solveNQueens(int n) {
        for (int i = 0; i < n-1 ; i++) {
            ss.append(".");
        }
        return dfs(new ArrayList<>(), new ArrayList(), n, 0);
    }

    public List<List<String>> dfs(List<List<String>> res, List curr, int n, int row){
        if(row==n){
            res.add(new ArrayList<>(curr));
            return res;
        }
        for (int i = 0; i < n ; i++) {
            if(isValid(row, i)){
                curr.add(new StringBuilder(ss).insert(i,"Q").toString());
                int a = row+i;  // row+col 作为key
                int b = row-i;  // row-col 作为key
                hs.add("row"+row); hs.add("col"+i); hs.add("k1"+a); hs.add("k2"+b);
                dfs(res, curr, n, row+1);
                curr.remove(curr.size()-1);
                hs.remove("row"+row); hs.remove("col"+i); hs.remove("k1"+a); hs.remove("k2"+b); //别忘了删掉
            }
        }
        return res;
    }

    public boolean isValid(int row, int col){
        int a = row+col;
        int b = row-col;
        if(hs.contains("row"+row)||hs.contains("col"+col)||hs.contains("k1"+a)||hs.contains("k2"+b)) return false;
        return true;
    }
}
