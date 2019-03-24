package code;
/*
 * 922. Sort Array By Parity II
 * 题意：奇数位置上都是奇数，偶数位置上都是偶数
 * 难度：Easy
 * 分类：Array, Sort
 * 思路：题看似简单，但最优的方法并不好写
 * Tips：
 */
public class lc922 {
    public int[] sortArrayByParityII(int[] A) { //O(N^2)
        for (int i = 0; i < A.length ; i++) {
            if( A[i]%2==i%2 ) continue;
            for (int j = i+1; j < A.length ; j++) {
                if(A[i]%2!=A[j]%2) {
                    int temp = A[i];
                    A[i] = A[j];
                    A[j] = temp;
                    break;
                }
            }
        }
        return A;
    }

    public int[] sortArrayByParityII2(int[] A) { //很巧妙的方法  O(N)时间， O(1)空间
        int cur = 1;    //奇数位置的位置
        for (int i = 0; i < A.length ; i+=2) { //这里+2 只判断偶数位置上是否符合
            if(A[i]%2==1){
                while(A[cur]%2==1) cur+=2;
                int temp = A[cur];
                A[cur] = A[i];
                A[i] = temp;
            }
        }
        return A;
    }
}
