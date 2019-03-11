package code;
/*
 * 24. Swap Nodes in Pairs
 * 题意：交换相邻的两个节点
 * 难度：Medium
 * 分类：Linked List
 * 思路：递归的方法，递归交换后续节点以后，再交换现在的两个节点
 *      非递归的方法，需要保存三个节点，加一个头节点指向head
 * Tips：
 */
public class lc24 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if( head==null||head.next==null ) return head;
        return helper(head);    //用递归的方法，因为交换了两个以后，第二个节点的下一个节点必须等后边两个节点交换了以后才知道谁在前
    }
    public ListNode helper(ListNode head){
        if(head==null) return null;
        if(head.next == null) return head;  //节点数可能是奇数
        ListNode res = head.next;
        ListNode ln1 = head, ln2 = head.next, ln3 = ln2.next;
        ln2.next = ln1;
        ln1.next = helper(ln3);
        return res;
    }
}
