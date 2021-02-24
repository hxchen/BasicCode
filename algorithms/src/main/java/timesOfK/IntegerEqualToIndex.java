package timesOfK;

import org.junit.Assert;
import org.junit.Test;

/**
 * 数组中数值和下标相等的元素
 * 题目：假设一个单调递增的数组里的每个元素都是整数并且是唯一的。请编程实
 * 现一个函数找出数组中任意一个数值等于其下标的元素。例如，在数组{-3, -1,
 * 1, 3, 5}中，数字3和它的下标相等。
 * Created by hxchen on 2018/8/8.
 */
public class IntegerEqualToIndex {

    public static int findIntegerEqualToIndex(int[] data) {
        if (data == null || data.length == 0)
            return -1;
        int start = 0;
        int end = data.length - 1;
        while (start <= end) {
            int middleIndex = (start + end) / 2;
            if (data[middleIndex] == middleIndex)
                return middleIndex;
            if (data[middleIndex] > middleIndex)
                end = middleIndex - 1;
            else
                start = middleIndex + 1;

        }
        return -1;
    }

    @Test
    public void Test1() {
        int numbers[] = {0, 1, 3, 5, 6};
        int expected = 0;
        Assert.assertTrue(expected == findIntegerEqualToIndex(numbers));
    }

    @Test
    public void Test2() {
        int numbers[] = {0, 1, 3, 5, 6};
        int expected = 0;
        Assert.assertTrue(expected == findIntegerEqualToIndex(numbers));
    }

    @Test
    public void Test3() {
        int numbers[] = {-1, 0, 1, 2, 4};
        int expected = 4;
        Assert.assertTrue(expected == findIntegerEqualToIndex(numbers));
    }

    @Test
    public void Test4() {
        int numbers[] = {-1, 0, 1, 2, 5};
        int expected = -1;
        Assert.assertTrue(expected == findIntegerEqualToIndex(numbers));
    }

    @Test
    public void Test5() {
        int numbers[] = {0};
        int expected = 0;
        Assert.assertTrue(expected == findIntegerEqualToIndex(numbers));
    }

    @Test
    public void Test6() {
        int numbers[] = {10};
        int expected = -1;
        Assert.assertTrue(expected == findIntegerEqualToIndex(numbers));
    }

    @Test
    public void Test7() {
        int expected = -1;
        Assert.assertTrue(expected == findIntegerEqualToIndex(null));
    }
}
