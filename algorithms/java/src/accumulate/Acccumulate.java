package accumulate;

import org.junit.Assert;
import org.junit.Test;

/**
 * 题目：求1+2+…+n，要求不能使用乘除法、for、while、if、else、switch、case
 * 等关键字及条件判断语句
 * Created by hxchen on 2019/1/2.
 */
public class Acccumulate {

    public static int sum(int num, int sum) {
        boolean isEnd = true;
        sum += num;
        isEnd = (num > 0) && ((sum = sum(num - 1, sum)) > 0);
        return sum;
    }

    @Test
    public void test1(){
        int num = 1;
        int sum = sum(num, 0);
        int expected = 1;
        Assert.assertTrue(sum == expected);
    }

    @Test
    public void test2(){
        int num = 5;
        int sum = sum(num, 0);
        int expected = 15;
        Assert.assertTrue(sum == expected);
    }

    @Test
    public void test3(){
        int num = 10;
        int sum = sum(num, 0);
        int expected = 55;
        Assert.assertTrue(sum == expected);
    }

    @Test
    public void test4(){
        int num = 0;
        int sum = sum(num, 0);
        int expected = 0;
        Assert.assertTrue(sum == expected);
    }


}
