package code;
/*
 * 9. Palindrome Number
 * 题意：判断数字是否是回文数字
 * 难度：Easy
 * 分类：Math
 * 思路：不转换字符串的思路就是把数字反转了以后，比较是否相等
 * Tips：
 */
public class lc9 {
    public boolean isPalindrome(int x) {
        int rev = 0;
        int temp = x;
        while(x>0){
            rev = rev*10 + x%10;
            x = x/10;
        }
        return rev == temp;
    }
}
