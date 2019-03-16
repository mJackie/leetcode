package code;
/*
 * 43. Multiply Strings
 * 题意：大数相乘
 * 难度：Medium
 * 分类：Math, String
 * 思路：每个位置上的数字都相乘，把位置排好，加起来
 *      https://leetcode.com/problems/multiply-strings/discuss/17605/Easiest-JAVA-Solution-with-Graph-Explanation
 * Tips：挺难的，好多细节
 */
public class lc43 {
    public String multiply(String num1, String num2) {
        int[] res = new int[num1.length()+num2.length()];   //最高位 index 是 0
        for (int i = num1.length()-1; i>=0 ; i--) { //从后往前，解决重复进位
            for (int j = num2.length()-1; j>=0 ; j--) {
                int a = i+j;
                int b = i+j+1;
                int mul = (num1.charAt(i) -'0') * (num2.charAt(j) - '0');
                mul += res[b];  //解决进位
                res[b] = mul%10;    //右边的直接=，因为上一步已经+了
                res[a] += mul/10;   //左边+=
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i:res) if(!(sb.length()==0&&i==0)) sb.append(i);
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
