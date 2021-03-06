package translateNumbersToStrings;

import org.junit.Assert;
import org.junit.Test;

/**
 * 把数字翻译成字符串
 * 题目：给定一个数字，我们按照如下规则把它翻译为字符串：0翻译成"a"，1翻
 * 译成"b"，……，11翻译成"l"，……，25翻译成"z"。一个数字可能有多个翻译。例
 * 如12258有5种不同的翻译，它们分别是"bccfi"、"bwfi"、"bczi"、"mcfi"和
 * "mzi"。请编程实现一个函数用来计算一个数字有多少种不同的翻译方法。
 * Created by hxchen on 2018/7/23.
 */
public class TranslateNumbersToStrings {


    public static int getTranslationCount(int number) {
        if (number < 0) {
            return 0;
        }
        if (number == 1) {
            return 1;
        }
        return getTranslationCount(Integer.toString(number));
    }
    //    自下而上，动态规划，从最小的问题开始 ：
    //    f(r)表示以r为开始（r最小取0）到最右端所组成的数字能够翻译成字符串的种数。对于长度为n的数字，f(n)=1,f(n-1)=1,求f(0)。
    //    递推公式为 f(r-2) = f(r-1)+g(r-2,r-1)*f(r)；
    //    其中，如果r-2，r-1能够翻译成字符，则g(r-2,r-1)=1，否则为0。
    //    因此，对于12258：
    //    f(5) = 1
    //    f(4) = 1
    //    f(3) = f(4)+0 = 1
    //    f(2) = f(3)+f(4) = 2
    //    f(1) = f(2)+f(3) = 3
    //    f(0) = f(1)+f(2) = 5

    public static int getTranslationCount(String number) {
        int f1 = 1, f2 = 1, g = 0;
        int temp;
        for (int i = number.length() - 2; i >= 0; i--) {
            int value = Integer.parseInt(number.charAt(i) + "" + number.charAt(i + 1));
            if (value >= 10 && value < 26) {
                g = 1;
            } else {
                g = 0;
            }

            temp = f2;
            f2 = f2 + g * f1;
            f1 = temp;
        }
        return f2;
    }

    @Test
    public void Test1() {
        Assert.assertTrue(getTranslationCount(0) == 1);
    }

    @Test
    public void Test2() {
        Assert.assertTrue(getTranslationCount(10) == 2);
    }

    @Test
    public void Test3() {
        Assert.assertTrue(getTranslationCount(125) == 3);
    }

    @Test
    public void Test4() {
        Assert.assertTrue(getTranslationCount(126) == 2);
    }

    @Test
    public void Test5() {
        Assert.assertTrue(getTranslationCount(426) == 1);
    }

    @Test
    public void Test6() {
        Assert.assertTrue(getTranslationCount(100) == 2);
    }

    @Test
    public void Test7() {
        Assert.assertTrue(getTranslationCount(101) == 2);
    }

    @Test
    public void Test8() {
        Assert.assertTrue(getTranslationCount(12258) == 5);
    }

    @Test
    public void Test9() {
        Assert.assertTrue(getTranslationCount(-100) == 0);
    }
}
