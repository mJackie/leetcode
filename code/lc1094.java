package code;
/*
 * 1094. Car Pooling
 * 题意：
 * 难度：Medium
 * 分类：
 * 思路： lc56 类似的题，但该题的集合没有传递覆盖的特性，所以遍历的时候又加了个循环，N^2
 *       非常巧妙的方法，每次记录上车，下车人数，然后遍历一遍进行模拟上下车
 * Tips：lc253, lc56
 */
import java.util.Arrays;
import java.util.Comparator;

public class lc1094 {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, new Comparator<int[]>() {  // 记住这种写法
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]!=o2[1])
                    return o1[1] - o2[1];
                else
                    return o2[2] - o1[2];
            }
        });
        for (int i = 0; i < trips.length ; i++) {
            int current = trips[i][0];
            for (int j = i-1; j >=0 ; j--) { //往前找是否重叠
                if(trips[j][2]>trips[i][1]) current += trips[j][0];
            }
            if(current>capacity) return false;
        }
        return true;
    }

    public boolean carPooling2(int[][] trips, int capacity) {
        int stops[] = new int[1001];
        for (int t[] : trips) {
            stops[t[1]] += t[0];
            stops[t[2]] -= t[0];
        }
        for (int i = 0; capacity >= 0 && i < 1001; ++i) capacity -= stops[i];
        return capacity >= 0;
    }
}
