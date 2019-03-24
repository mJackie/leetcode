package code;

import java.util.Stack;
/*
 * 921. Minimum Add to Make Parentheses Valid
 * 题意：最少添加符号个数，使得表达式有效
 * 难度：Medium
 * 分类：Stack, Greedy
 * 思路：匹配的都出栈，最后剩下的栈中没匹配的个数，就是需要添加的个数
 * Tips：
 */
public class lc921 {
    public int minAddToMakeValid(String S) {
        char[] ch_arr = S.toCharArray();
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < ch_arr.length ; i++) {
            if(ch_arr[i]==')' && !st.isEmpty() && st.peek()=='('){
                st.pop();
            }else{
                st.push(ch_arr[i]);
            }
        }
        return st.size();
    }
}
