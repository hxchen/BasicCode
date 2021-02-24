package timesOfK;

import org.junit.Assert;
import org.junit.Test;

/**
 * 数字在排序数组中出现的次数
 * 题目：统计一个数字在排序数组中出现的次数。
 * 例如输入排序数组{1, 2, 3, 3, 3, 3, 4, 5}和数字3，由于3在这个数组中出现了4次，因此输出4。
 * Created by hxchen on 2018/8/6.
 */
public class TimesOfK {

    /**
     * 找到数组中第一个k的下标。如果数组中不存在k，返回-1
     *
     * @param data
     * @param k
     * @param start
     * @param end
     * @return
     */
    private static int getFirstK(int[] data, int k, int start, int end) {
        if (start > end)
            return -1;
        int middleIndex = (start + end) / 2;
        int middleData = data[middleIndex];

        if (middleData == k) {
            if ((middleIndex > 0 && data[middleIndex - 1] != k) || middleIndex == 0) {
                return middleIndex;
            } else {
                end = middleIndex - 1;
            }

        } else if (middleData > k) {
            end = middleIndex - 1;
        } else {
            start = middleIndex + 1;
        }
        return getFirstK(data, k, start, end);
    }

    /**
     * 找到数组中最后一个k的下标。如果数组中不存在k，返回-1
     *
     * @param data
     * @param k
     * @param start
     * @param end
     * @return
     */
    private static int getLastK(int[] data, int k, int start, int end) {
        if (start > end)
            return -1;

        int middleIndex = (start + end) / 2;
        int middleData = data[middleIndex];

        if (middleData == k) {
            if ((middleIndex < data.length - 1 && data[middleIndex + 1] != k) || middleIndex == data.length - 1) {
                return middleIndex;
            } else {
                start = middleIndex + 1;
            }

        } else if (middleData < k) {
            start = middleIndex + 1;
        } else {
            end = middleIndex - 1;
        }
        return getLastK(data, k, start, end);
    }

    public static int getTimesOfK(int[] data, int k) {
        int times = 0;
        if (data == null)
            return times;
        int first = getFirstK(data, k, 0, data.length - 1);
        int last = getLastK(data, k, 0, data.length - 1);
        if (first > -1 && last > -1) {
            times = last - first + 1;
        }
        return times;
    }

    @Test
    public void Test1() {
        int data[] = {1, 2, 3, 3, 3, 3, 4, 5};
        int k = 3, times = 4;
        Assert.assertTrue(times == getTimesOfK(data, k));
    }

    @Test
    public void Test2() {
        int data[] = {3, 3, 3, 3, 4, 5};
        int k = 3, times = 4;
        Assert.assertTrue(times == getTimesOfK(data, k));
    }

    @Test
    public void Test3() {
        int data[] = {1, 2, 3, 3, 3, 3};
        int k = 3, times = 4;
        Assert.assertTrue(times == getTimesOfK(data, k));
    }

    @Test
    public void Test4() {
        int data[] = {1, 3, 3, 3, 3, 4, 5};
        int k = 2, times = 0;
        Assert.assertTrue(times == getTimesOfK(data, k));
    }

    @Test
    public void Test5() {
        int data[] = {1, 3, 3, 3, 3, 4, 5};
        int k = 0, times = 0;
        Assert.assertTrue(times == getTimesOfK(data, k));
    }

    @Test
    public void Test6() {
        int data[] = {1, 3, 3, 3, 3, 4, 5};
        int k = 6, times = 0;
        Assert.assertTrue(times == getTimesOfK(data, k));
    }

    @Test
    public void Test7() {
        int data[] = {3, 3, 3, 3};
        int k = 3, times = 4;
        Assert.assertTrue(times == getTimesOfK(data, k));
    }

    @Test
    public void Test8() {
        int data[] = {3, 3, 3, 3};
        int k = 4, times = 0;
        Assert.assertTrue(times == getTimesOfK(data, k));
    }

    @Test
    public void Test9() {
        int data[] = {3};
        int k = 3, times = 1;
        Assert.assertTrue(times == getTimesOfK(data, k));
    }

    @Test
    public void Test10() {
        int data[] = {3};
        int k = 4, times = 0;
        Assert.assertTrue(times == getTimesOfK(data, k));
    }

    @Test
    public void Test11() {
        int k = 0, times = 0;
        Assert.assertTrue(times == getTimesOfK(null, k));
    }

}
