package code;
/*
 * 25. Reverse Nodes in k-Group
 * 题意：每k个反转一下，不足k的不反转，直接接上
 * 难度：Hard
 * 分类：Linked List
 * 思路：递归调用反转，反转完下一段的返回节点，节点这一段上
 * Tips：lc25, lc206
 */
public class lc25 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        while (curr != null && count != k) { // 找下一段要反转的起始节点
            curr = curr.next;
            count++;
        }
        if (count == k) { // 不足k的不执行
            curr = reverseKGroup(curr, k); // 递归调用，反转下一段，并返回翻转后的头结点
            // 反转当前段
            while (count-- > 0) { // 链表反转的思路
                ListNode tmp = head.next;
                head.next = curr;
                curr = head;
                head = tmp;
            }
            head = curr;
        }
        return head;
    }
}
