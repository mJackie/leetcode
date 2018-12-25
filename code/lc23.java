package code;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * 22. Generate Parentheses
 * 题意：正确括号组合的
 * 难度：Medium
 * 分类：String, Backtracking
 * 思路：回溯法的典型题目，按选优条件向前搜索，达到目标后就退回一步或返回
 * 注意：递归法别忘了两块的拼接，例如n=4时，可以由2，2拼起来作为答案
 */
public class lc23 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists==null||lists.length==0) return null;
        PriorityQueue<ListNode> pr = new PriorityQueue<ListNode>(lists.length,new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1,ListNode o2){
                if (o1.val<o2.val)
                    return -1;
                else if (o1.val==o2.val)
                    return 0;
                else
                    return 1;
            }
        });
        for (ListNode l:lists) {
            if (l!=null)
                pr.add(l);
        }
        ListNode head = new ListNode(0);
        ListNode ln = head;
        while(pr.size()!=0){
            ln.next = pr.remove();
            ln = ln.next;
            if(ln.next!=null)
                pr.add(ln.next);
        }
        return head.next;
    }
}
