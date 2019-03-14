package code;
/*
 * 83. Remove Duplicates from Sorted List
 * 题意：移除重复值的节点，链表已排序
 * 难度：Easy
 * 分类：
 * 思路：
 * Tips：
 */
public class lc83 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return head;
        ListNode curr = head;
        ListNode res = head;
        while(curr!=null){
            while( head!=null && head.val==curr.val) head = head.next;
            curr.next = head;
            curr = head;
        }
        return res;
    }
}
