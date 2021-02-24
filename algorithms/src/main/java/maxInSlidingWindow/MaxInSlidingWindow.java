package maxInSlidingWindow;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 滑动窗口的最大值
 * 题目：给定一个数组和滑动窗口的大小，请找出所有滑动窗口里的最大值。例如，
 * 如果输入数组{2, 3, 4, 2, 6, 2, 5, 1}及滑动窗口的大小3，那么一共存在6个
 * 滑动窗口，它们的最大值分别为{4, 4, 6, 6, 6, 5}，
 * Created by hxchen on 2018/8/27.
 */
public class MaxInSlidingWindow {

    /**
     * 双端队列法
     *
     * @param numbers
     * @param windowsSize
     * @return
     */
    public ArrayList<Integer> maxInWindows(int[] numbers, int windowsSize) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (numbers == null || numbers.length == 0 || windowsSize <= 0 || windowsSize > numbers.length)
            return arrayList;
        // 队列,队列头存最大、队列尾存次大
        Deque<Integer> deque = new LinkedBlockingDeque<>();
        for (int i = 0; i < windowsSize; i++) {
            while (!deque.isEmpty() && numbers[i] >= numbers[deque.peekLast()]) {
                deque.pollLast(); //队列尾部删除
            }
            deque.addLast(i); // 存入队列尾部
        }
        for (int i = windowsSize; i < numbers.length; i++) {

            arrayList.add(numbers[deque.peekFirst()]);

            while (!deque.isEmpty() && numbers[i] >= numbers[deque.peekLast()])
                deque.pollLast(); // 尾部删除

            if (!deque.isEmpty() && deque.peekFirst() <= (i - windowsSize))
                deque.pop(); // 头部删除

            deque.addLast(i);

        }
        arrayList.add(numbers[deque.peekFirst()]);

        return arrayList;
    }

    private int[] list2Array(ArrayList<Integer> arrayList) {

        int[] array = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            array[i] = arrayList.get(i);
        }
        return array;
    }

    @Test
    public void Test1() {
        int num[] = {2, 3, 4, 2, 6, 2, 5, 1};
        int expected[] = {4, 4, 6, 6, 6, 5};
        Assert.assertArrayEquals(expected, list2Array(maxInWindows(num, 3)));
    }

    @Test
    public void Test2() {
        int num[] = {1, 3, -1, -3, 5, 3, 6, 7};
        int expected[] = {3, 3, 5, 5, 6, 7};
        Assert.assertArrayEquals(expected, list2Array(maxInWindows(num, 3)));
    }

    @Test
    public void Test3() {
        int num[] = {1, 3, 5, 7, 9, 11, 13, 15};
        int expected[] = {7, 9, 11, 13, 15};
        Assert.assertArrayEquals(expected, list2Array(maxInWindows(num, 4)));
    }

    @Test
    public void Test4() {
        int num[] = {16, 14, 12, 10, 8, 6, 4};
        int expected[] = {16, 14, 12};
        Assert.assertArrayEquals(expected, list2Array(maxInWindows(num, 5)));
    }

    @Test
    public void Test5() {
        int num[] = {10, 14, 12, 11};
        int expected[] = {10, 14, 12, 11};
        Assert.assertArrayEquals(expected, list2Array(maxInWindows(num, 1)));
    }

    @Test
    public void Test6() {
        int num[] = {10, 14, 12, 11};
        int expected[] = {14};
        Assert.assertArrayEquals(expected, list2Array(maxInWindows(num, 4)));
    }

    @Test
    public void Test7() {
        int num[] = {10, 14, 12, 11};
        int expected[] = {};
        Assert.assertArrayEquals(expected, list2Array(maxInWindows(num, 0)));
    }

    @Test
    public void Test8() {
        int num[] = {10, 14, 12, 11};
        int expected[] = {};
        Assert.assertArrayEquals(expected, list2Array(maxInWindows(num, 5)));
    }

    @Test
    public void Test9() {
        int num[] = null;
        int expected[] = {};
        Assert.assertArrayEquals(expected, list2Array(maxInWindows(num, 5)));
    }

}
