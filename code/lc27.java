package code;
/*
 * 27. Remove Element
 * 题意：移除掉数组中指定的值，返回移除后数组的长度
 * 难度：Easy
 * 分类：Array, Two Pointers
 * 思路：两个指针，分别O(n)，指向要交换的位置和和他交换的数
 *      答案中直接遍历一遍数组，放到位置上就行了，i++
 * Tips：lc26
 */
public class lc27 {
    public int removeElement(int[] nums, int val) {
        int p1 = 0, p2 = 0;
        while(p2<nums.length){
            while(p1<nums.length&&nums[p1]!=val) p1++;  //p1指向要交换val的位置
            p2=p1;
            while(p2<nums.length&&nums[p2]==val) p2++;
            if(p1<nums.length && p2<nums.length){
                int temp = nums[p1];
                nums[p1] = nums[p2];
                nums[p2] = temp;
            }
        }
        return p1;
    }

    public int removeElement2(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}
