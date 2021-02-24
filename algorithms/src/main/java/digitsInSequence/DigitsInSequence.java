package digitsInSequence;

import org.junit.Assert;
import org.junit.Test;

/**
 * 数字序列中某一位的数字
 * 题目：数字以0123456789101112131415…的格式序列化到一个字符序列中。在这
 * 个序列中，第5位（从0开始计数）是5，第13位是1，第19位是4，等等。请写一
 * 个函数求任意位对应的数字。
 * <p>
 * 1    0-99            10          10
 * 2    10-99           90          180
 * 3    100-999         900         2700
 * 4    1000-9999       9000        36000
 * <p>
 * Created by hxchen on 2018/7/19.
 */
public class DigitsInSequence {

    /**
     * 输入位数n,输出位数n的起始数字
     * 例如输入 3,输出 100
     *
     * @param n
     */
    private static int getStart(int n) {
        if (n == 1)
            return 0;

        return (int) Math.pow(10, n - 1);
    }

    /**
     * 输入位数n,输出该位数的个数
     * 例如输入 3, 输出 900
     *
     * @param n
     * @return
     */
    private static int getCount(int n) {
        return getStart(n + 1) - getStart(n);
    }

    /**
     * 输入位数n,输出该位数下总共多少位
     * 例如输入 4,输出4位数共有 36000位
     *
     * @param n
     * @return
     */
    private static int countDigits(int n) {
        return n * getCount(n);
    }

    /**
     * 输入位数n, 输出小于等于该位数下,总共多少位
     * 例如输入3,输出 1 2 3位数总共的位有  2890
     *
     * @param n
     * @return
     */
    private static int countTotalDigits(int n) {
        int total = 0;
        for (int i = 1; i <= n; i++) {
            total += countDigits(i);
        }
        return total;
    }

    /**
     * 求number的第position 位
     * 例如number = 34367,position = 3;返回3
     *
     * @param number
     * @return
     */
    private static int getDigitByPosition(int number, int position) {
        return String.valueOf(number).charAt(position - 1) - '0';
    }

    /**
     * 输入n,输出序列化的第n位
     *
     * @param n
     */
    public static int digitsInSequence(int n) {
        int numberOfDigits = 1;     //n应该是个几位数
        while (n > countTotalDigits(numberOfDigits)) {
            numberOfDigits++;
        }
        int left = n - countTotalDigits(numberOfDigits - 1) + 1;    //n位数中的第 left位
        int times = left / numberOfDigits;     //n是 从getStart(n)开始的第 times 中的一位
        int position = left % numberOfDigits;        //n是 该数中的第 position 位
        int number = getStart(numberOfDigits) + times - 1;
        if (position == 0) {
            return number % 10;   //返回number的最后一位
        } else {
            int nextNumber = number + 1;
            return getDigitByPosition(nextNumber, position);

        }
    }

    @Test
    public void Test1() {
//        System.out.println(getStart(2));
//        System.out.println(getCount(2));
//        System.out.println(countDigits(2));
//        System.out.println(countTotalDigits(2));
        System.out.println(digitsInSequence(1001));
//        System.out.println(getDigitByPosition(1234567,6));
    }

}
