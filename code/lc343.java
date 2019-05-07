package code;
/*
 * 343. Integer Break
 * 题意：给定一个正整数，找出一组数字和为该数，且这组数的乘积最大
 * 难度：Medium
 * 分类：Math, Dynamic Programming
 * 思路：能减3的减3，因为3得到的乘积最大
 * Tips：
 */
public class lc343 {
    public int integerBreak(int n) {
        if(n==2) return 1;
        if(n==3) return 2;
        return helper(n);
    }

    public int helper(int n){
        if(n==2) return 2;
        if(n==3) return 3;
        if(n==4) return 4;
        if(n==5) return 6;
        else return helper(n-3)*3;
    }
}
