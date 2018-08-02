package inversePairs;

import org.junit.Assert;
import org.junit.Test;

/**
 * 数组中的逆序对
 * 题目：在数组中的两个数字如果前面一个数字大于后面的数字，则这两个数字组
 * 成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * Created by hxchen on 2018/8/2.
 */
public class InversePairs {

    public static int InversePairs(int[] array){
        if (array == null || array.length == 0)
            return 0;
        int[] copy = new int[array.length];
        for (int i = 0; i < array.length; ++i){
            copy[i] = array[i];
        }
        int count = InversePairs(array, copy, 0, array.length - 1);
        return count;
    }

    /**
     *
     * @param data 未归并数组
     * @param copy  归并后数组
     * @param start 起始位置
     * @param end 结束位置
     * @return 逆序数
     */
    private static int InversePairs(int[] data, int[] copy, int start, int end){
        if (start == end){
            copy[start] = data[start];
            return 0;
        }
        int mid = (start+end)/2;
        // 注意调用参数
        int left = InversePairs(copy, data, start,mid);
        int right = InversePairs(copy, data, mid+1, end);

        int i = mid; // i前半段最后一个数字的下标
        int j = end;//j后半段最后一个数字的下标
        int indexCopy = end;
        int count = 0;

        while (i >= start && j >= mid+1){
            if (data[i] > data[j]){
                copy[indexCopy--] = data[i--];
                count += j-mid;
            }else {
                copy[indexCopy--] = data[j--];
            }
        }
        while(i >= start){
            copy[indexCopy--] = data[i--];
        }
        while(j >= mid+1){
            copy[indexCopy--] = data[j--];
        }
        return left+right+count;
    }
    @Test
    public void Test1(){
        int data[] = { 1, 2, 3, 4, 7, 6, 5 };
        int expected = 3;
        Assert.assertTrue(expected == InversePairs(data));
    }
    @Test
    public void Test2(){
        int data[] = { 6, 5, 4, 3, 2, 1 };
        int expected = 15;
        Assert.assertTrue(expected == InversePairs(data));
    }
    @Test
    public void Test3(){
        int data[] = { 1, 2, 3, 4, 5, 6 };
        int expected = 0;
        Assert.assertTrue(expected == InversePairs(data));
    }
    @Test
    public void Test4(){
        int data[] = { 1 };
        int expected = 0;
        Assert.assertTrue(expected == InversePairs(data));
    }
    @Test
    public void Test5(){
        int data[] = { 1, 2 };
        int expected = 0;
        Assert.assertTrue(expected == InversePairs(data));
    }
    @Test
    public void Test6(){
        int data[] = { 2, 1 };
        int expected = 1;
        Assert.assertTrue(expected == InversePairs(data));
    }
    @Test
    public void Test7(){
        int data[] = { 1, 2, 1, 2, 1 };
        int expected = 3;
        Assert.assertTrue(expected == InversePairs(data));
    }
    @Test
    public void Test8(){
        int expected = 0;
        Assert.assertTrue(expected == InversePairs(null));
    }
}
