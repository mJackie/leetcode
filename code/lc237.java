package code;
/*
 * 237. Delete Node in a Linked List
 * 题意：删除链表中的一个节点，给的是这个节点，不知道前边的节点
 * 难度：Easy
 * 分类：Linked List
 * 思路：剑指Offer上有，拷贝下一个节点的内容到该节点，删除下一个节点
 * Tips：
 */
public class lc237 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
