package addTwoNumbers;

import org.junit.Assert;
import org.junit.Test;

/**
 * 题目：写一个函数，求两个整数之和，要求在函数体内不得使用＋、－、×、÷
 * 四则运算符号。
 * Created by hxchen on 2019/1/3.
 */
public class AddTwoNumbers {

    public static int add(int number1, int number2) {
        int temp = 0;
        while (number2 != 0) {
            temp = number1 ^ number2;
            number2 = (number1 & number2) << 1;
            number1 = temp;
        }
        return number1;
    }

    @Test
    public void test1(){
        Assert.assertTrue(add(1, 2) == 3);
    }
    @Test
    public void test2(){
        Assert.assertTrue(add(111, 899) == 1010);
    }
    @Test
    public void test3(){
        Assert.assertTrue(add(-1, 2) == 1);
    }
    @Test
    public void test4(){
        Assert.assertTrue(add(1, -2) == -1);
    }
    @Test
    public void test5(){
        Assert.assertTrue(add(3, 0) == 3);
    }
    @Test
    public void test6(){
        Assert.assertTrue(add(0, -4) == -4);
    }
    @Test
    public void test7(){
        Assert.assertTrue(add(-2, -8) == -10);
    }

}
