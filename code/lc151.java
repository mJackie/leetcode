package code;

import java.util.Arrays;
import java.util.Collections;
/*
 * 151. Reverse Words in a String
 * 题意：反转字符串中的单词
 * 难度：Medium
 * 分类：String
 * 思路：难点在中间的空格可能是多个空格，注意如何解决
 * Tips：
 */
public class lc151 {
    public String reverseWords(String s) {
        String[] words = s.trim().split(" +"); //+号匹配多个
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }
}
