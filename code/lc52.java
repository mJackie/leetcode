package code;

import java.util.HashSet;
/*
 * 52. N-Queens II
 * 题意：8皇后问题
 * 难度：Hard
 * 分类：Backtracking
 * 思路：和 lc51 一样，输出变为种类数，反而简单了
 * Tips：
 */
public class lc52 {
    HashSet<String> hs = new HashSet();
    int res = 0;
    public int totalNQueens(int n) {
        dfs(n, 0);
        return res;
    }

    public void dfs(int n, int row){
        if(row==n){
            res++;
        }
        for (int i = 0; i < n ; i++) {
            if(isValid(row, i)){
                int a = row+i;  // row+col 作为key
                int b = row-i;  // row-col 作为key
                hs.add("row"+row); hs.add("col"+i); hs.add("k1"+a); hs.add("k2"+b);
                dfs(n, row+1);
                hs.remove("row"+row); hs.remove("col"+i); hs.remove("k1"+a); hs.remove("k2"+b); //别忘了删掉
            }
        }
    }

    public boolean isValid(int row, int col){
        int a = row+col;
        int b = row-col;
        if(hs.contains("row"+row)||hs.contains("col"+col)||hs.contains("k1"+a)||hs.contains("k2"+b)) return false;
        return true;
    }
}
