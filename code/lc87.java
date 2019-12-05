package code;
/*
 * 87. Scramble String
 * 题意：把字符串写成二叉树的形式，问是否可以交换非叶子节点的左右孩子，生成新的字符串
 * 难度：Hard
 * 分类：String, Dynamic Programming
 * 思路：递归的方法，判断交换两段是否满足
 * Tips：注意先判断两个字符串是否字符一样，用map的方法，否则长的字符串会超时
 */
public class lc87 {
    public boolean isScramble(String s1, String s2) {
        if(s1.equals(s2)) return true;
        if(s1.length()!=s2.length()) return false;
        int[] cur_map = new int[26];
        for(int i=0; i<s1.length(); i++){
            cur_map[s1.charAt(i)-'a']++;
            cur_map[s2.charAt(i)-'a']--;
        }
        for(int i=0; i<26; i++) if(cur_map[i]!=0) return false;
        for(int i=1; i<s1.length(); i++){
            if( isScramble(s1.substring(0,i), s2.substring(0,i)) && isScramble(s1.substring(i), s2.substring(i))) return true;
            if( isScramble(s1.substring(0,i), s2.substring(s1.length()-i)) && isScramble(s1.substring(i), s2.substring(0,s1.length()-i))) return true;
        }
        return false;
    }
}
