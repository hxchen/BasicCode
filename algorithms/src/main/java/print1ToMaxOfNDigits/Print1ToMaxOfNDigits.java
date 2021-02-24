package print1ToMaxOfNDigits;

import org.junit.Test;

/**
 * 打印1到最大的n位数
 * 题目：输入数字n，按顺序打印出从1最大的n位十进制数。比如输入3，则
 * 打印出1、2、3一直到最大的3位数即999。
 * Created by hxchen on 2018/6/5.
 */
public class Print1ToMaxOfNDigits {

    public static void print1ToMaxOfNDigits(int n) {
        if (n <= 0)
            return;
        StringBuffer s = new StringBuffer(n);
        // 生成全为0的n位字符串
        for (int i = 0; i < n; i++) {
            s.append('0');
        }
        // 第0位是最高位
        for (int i = 0; i < 10; i++) {
            s.setCharAt(0, (char) (i + '0'));   //首位用数字i来替换
            print1ToMaxOfNDigits(s, n, 0);
        }
    }

    private static void print1ToMaxOfNDigits(StringBuffer s, int n, int index) {
        if (index == n - 1) {
            printNumber(s);
            return;
        }

        for (int i = 0; i < 10; i++) {
            s.setCharAt(index + 1, (char) ('0' + i));
            print1ToMaxOfNDigits(s, n, index + 1);
        }
    }

    // 打印s，去除开头多余的0
    private static void printNumber(StringBuffer s) {
        boolean isBeginning0 = true;
        for (int i = 0; i < s.length(); i++) {
            // 当找到第一个非0字符以后，把isBeginning0设置为false，后面的字符全部打印
            if (isBeginning0 && s.charAt(i) != '0') {
                isBeginning0 = false;
            }
            if (!isBeginning0)
                System.out.print(s.charAt(i));
        }

        System.out.println();
    }

    @Test
    public void test() {
        print1ToMaxOfNDigits(3);
    }

    @Test
    public void test2() {
        int m = 0 + '0';  //48
        char n = 0 + '0'; //0
        char p = '0' + 2;

        System.out.println(m);
        System.out.println(n);
        System.out.println(p);
    }

}
