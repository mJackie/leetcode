package code;

import java.util.PriorityQueue;

public class lc295 {
    class MedianFinder {
        PriorityQueue<Integer> pq1;    //默认是最小，右半边
        PriorityQueue<Integer> pq2;    //左半边

        /** initialize your data structure here. */
        public MedianFinder() {
            this.pq1 = new PriorityQueue();
            this.pq2 = new PriorityQueue();
        }

        public void addNum(int num) {
            pq1.add(num);   //两个队列都过一遍
            pq2.add(-pq1.poll());
            if (pq1.size() < pq2.size())    //如果中位数是一个数，就存在左半边
                pq1.add(-pq2.poll());
        }

        public double findMedian() {
            if(pq1.size()==pq2.size()+1) return pq1.peek();
            return -((double)(-pq1.peek()+pq2.peek()))/2;
        }
    }
}
