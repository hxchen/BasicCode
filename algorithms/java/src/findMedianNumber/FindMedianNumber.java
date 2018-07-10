package findMedianNumber;

import org.junit.Assert;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 *数据流中的中位数
 * 题目：如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么
 * 中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，
 * 那么中位数就是所有数值排序之后中间两个数的平均值。
 * Created by hxchen on 2018/7/10.
 */
public class FindMedianNumber {

    PriorityQueue<Integer> maxheap = new PriorityQueue<Integer>();
    PriorityQueue<Integer> minheap = new PriorityQueue<Integer>(Collections.reverseOrder());

    public void addNum(int num) {
        maxheap.offer(num);
        minheap.offer(maxheap.poll());
        if(maxheap.size() < minheap.size()){
            maxheap.offer(minheap.poll());
        }
    }

    public double findMedian() {
        return maxheap.size() == minheap.size() ? (double)(maxheap.peek() + minheap.peek()) / 2.0 : maxheap.peek();
    }

    public static void main(String[] args){
        FindMedianNumber findMedianNumber = new FindMedianNumber();

        findMedianNumber.addNum(5);
        Assert.assertTrue(Math.abs(findMedianNumber.findMedian() - 5) < 0.0000001);

        findMedianNumber.addNum(2);
        Assert.assertTrue(Math.abs(findMedianNumber.findMedian() - 3.5) < 0.0000001);

        findMedianNumber.addNum(3);
        Assert.assertTrue(Math.abs(findMedianNumber.findMedian() - 3) < 0.0000001);

        findMedianNumber.addNum(4);
        Assert.assertTrue(Math.abs(findMedianNumber.findMedian() - 3.5) < 0.0000001);

        findMedianNumber.addNum(1);
        Assert.assertTrue(Math.abs(findMedianNumber.findMedian() - 3) < 0.0000001);

        findMedianNumber.addNum(6);
        Assert.assertTrue(Math.abs(findMedianNumber.findMedian() - 3.5) < 0.0000001);

        findMedianNumber.addNum(7);
        Assert.assertTrue(Math.abs(findMedianNumber.findMedian() - 4) < 0.0000001);

        findMedianNumber.addNum(0);
        Assert.assertTrue(Math.abs(findMedianNumber.findMedian() - 3.5) < 0.0000001);

        findMedianNumber.addNum(8);
        Assert.assertTrue(Math.abs(findMedianNumber.findMedian() - 4) < 0.0000001);


    }
}
