package code;
/*
 * 206. Reverse Linked List
 * 题意：链表反转
 * 难度：Easy
 * 分类：Linked List
 * 思路：2中方法：设置一个快走一步的快指针，注意赋值操作顺序。还有一种递归的方法。
 * Tips：递归的方法有点绕，多看下
 *      lc25, lc206
 */
public class lc206 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;    //头结点变尾节点，指向null
        while(head!=null){
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public ListNode reverseList2(ListNode head) {   //递归
        return reverseListInt(head, null);
    }
    private ListNode reverseListInt(ListNode head, ListNode pre) {
        if (head == null)
            return pre;
        ListNode next = head.next;
        head.next = pre;
        return reverseListInt(next, head);  //尾递归，操作已经完成，最后返回最后结果罢了
    }
}
