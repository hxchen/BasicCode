package timesOfK;

import org.junit.Assert;
import org.junit.Test;

/**
 * 0到n-1中缺失的数字
 * 题目：一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字
 * 都在范围0到n-1之内。在范围0到n-1的n个数字中有且只有一个数字不在该数组
 * 中，请找出这个数字。
 * Created by hxchen on 2018/8/7.
 */
public class MissingNumber {

    public int findMissingNumber(int data[]) {
        if (data == null || data.length == 0)
            return -1;
        int start = 0;
        int end = data.length - 1;
        while (start <= end) {
            int middle = (start + end) / 2;
            if (data[middle] == middle) {
                start = middle + 1;
            } else if (middle == 0 || data[middle - 1] == (middle - 1)) {
                return middle;
            } else {
                end = middle - 1;
            }
        }
        if (start == data.length)
            return data.length;
        return -1;

    }

    @Test
    public void Test1() {
        int numbers[] = {1, 2, 3, 4, 5};
        int expected = 0;
        Assert.assertTrue(expected == findMissingNumber(numbers));
    }

    @Test
    public void Test2() {
        int numbers[] = {0, 1, 2, 3, 4};
        int expected = 5;
        Assert.assertTrue(expected == findMissingNumber(numbers));
    }

    @Test
    public void Test3() {
        int numbers[] = {0, 1, 2, 4, 5};
        int expected = 3;
        Assert.assertTrue(expected == findMissingNumber(numbers));
    }

    @Test
    public void Test4() {
        int numbers[] = {1};
        int expected = 0;
        Assert.assertTrue(expected == findMissingNumber(numbers));
    }

    @Test
    public void Test5() {
        int numbers[] = {0};
        int expected = 1;
        Assert.assertTrue(expected == findMissingNumber(numbers));
    }

    @Test
    public void Test6() {
        int expected = -1;
        Assert.assertTrue(expected == findMissingNumber(null));
    }
}
