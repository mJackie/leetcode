package code;
/*
 * 978. Longest Turbulent Subarray
 * 题意：小，大，小，大 这种最大长度是多少
 * 难度：Medium
 * 分类：Array, Dynamic Porgramming, Sliding Windows
 * 思路：O(n) 遍历一遍就能解决，不用dp
 * Tips：lc53
 */
public class lc978 {
    public int maxTurbulenceSize(int[] A) { //太难想了
        int inc = 1, dec = 1, result = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] < A[i - 1]) {  // +1 并且重置另一个统计量
                dec = inc + 1;
                inc = 1;
            } else if (A[i] > A[i - 1]) {
                inc = dec + 1;
                dec = 1;
            } else {
                inc = 1;
                dec = 1;
            }
            result = Math.max(result, Math.max(dec, inc));
        }
        return result;
    }

    public int maxTurbulenceSize2(int[] A) {
        int[] arr = new int[A.length-1];
        for(int i=1; i<A.length; i++){  //转换成0,1数组
            if(A[i]==A[i-1]) arr[i-1] = 0;
            else if(A[i]>A[i-1]) arr[i-1] = 1;
            else arr[i-1] = -1;
        }
        int res = 1;
        boolean flag = false;   //判断下是否全是0， 返回的时候就不+1
        int count = 1;
        for(int i=1; i<arr.length; i++){
            if(arr[i]!=0) flag=true;
            if(arr[i]==-arr[i-1] && arr[i]!=0) {
                count++;
            }else{
                res = Math.max(res, count);
                count = 1;
            }
        }
        res = Math.max(res, count);
        return flag? res+1: res;
    }
}
