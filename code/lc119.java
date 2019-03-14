package code;

import java.util.ArrayList;
import java.util.List;

/*
 * 119. Pascal's Triangle II
 * 题意：和118一样，就是输出不一样
 * 难度：Easy
 * 分类：Array
 * 思路：记一下 ArrayList.set 方法，不用重新 new ArrayList
 * Tips：
 */
public class lc119 {
    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> res = new ArrayList<>();
        res.add(0,1);
        while(rowIndex-->0){
            res.add(0,1);
            for (int i = 1; i < res.size()-1 ; i++) {
                res.set(i, res.get(i)+res.get(i+1));
            }
        }
        return res;
    }
}
