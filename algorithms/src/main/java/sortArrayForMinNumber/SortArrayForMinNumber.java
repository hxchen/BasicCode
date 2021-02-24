package sortArrayForMinNumber;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 把数组排成最小的数
 * 题目：输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼
 * 接出的所有数字中最小的一个。例如输入数组{3, 32, 321}，则打印出这3个数
 * 字能排成的最小数字321323。
 * Created by hxchen on 2018/7/20.
 */
public class SortArrayForMinNumber {

    public String PrintMinNumber(int[] numbers) {

        if (numbers == null || numbers.length == 0)
            return null;

        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            list.add(String.valueOf(numbers[i]));
        }

        // 比较器
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = (String) o1;
                String s2 = (String) o2;
                return (s1 + s2).compareTo(s2 + s1);
            }
        });

        StringBuilder s = new StringBuilder();
        for (String str : list) {
            s = s.append(str);
        }

        return s.toString();
    }

    @Test
    public void Test1() {
        int numbers[] = {3, 5, 1, 4, 2};
        Assert.assertTrue(PrintMinNumber(numbers).equals("12345"));
    }

    @Test
    public void Test2() {
        int numbers[] = {3, 32, 321};
        Assert.assertTrue(PrintMinNumber(numbers).equals("321323"));
    }

    @Test
    public void Test3() {
        int numbers[] = {3, 323, 32123};
        Assert.assertTrue(PrintMinNumber(numbers).equals("321233233"));
    }

    @Test
    public void Test4() {
        int numbers[] = {1, 11, 111};
        Assert.assertTrue(PrintMinNumber(numbers).equals("111111"));
    }

    @Test
    public void Test5() {
        int numbers[] = {321};
        Assert.assertTrue(PrintMinNumber(numbers).equals("321"));
    }

    @Test
    public void Test6() {
        Assert.assertTrue(PrintMinNumber(null) == null);
    }

}
