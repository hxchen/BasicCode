package leftRotateString;

import org.junit.Assert;
import org.junit.Test;

/**
 * 左旋转字符串
 * 题目：字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。比如输入字符串"abcdefg"和数
 * 字2，该函数将返回左旋转2位得到的结果"cdefgab"。
 * Created by hxchen on 2018/8/25.
 */
public class LeftRotateString {


    public static String leftRotateString(String string, int n) {
        if (string == null || string.length() < 2 || string.length() <= n) {
            return string;
        }
        char[] charArray = string.toCharArray();
        //翻转前n个
        reverse(charArray, 0, n - 1);
        //翻转后面的
        reverse(charArray, n, charArray.length - 1);
        //整体翻转
        reverse(charArray, 0, charArray.length - 1);
        return String.valueOf(charArray);


    }

    private static void reverse(char[] array, int start, int end) {
        char temp = ' ';
        while (start < end) {
            temp = array[start];
            array[start++] = array[end];
            array[end--] = temp;
        }
    }

    public static String leftRotateString2(String string, int n) {
        if (string == null || string.length() < 2 || string.length() <= n) {
            return string;
        }
        char[] charArray = string.toCharArray();
        StringBuffer stringBuffer = new StringBuffer(string.substring(n, string.length()));
        for (int i = 0; i < n; i++) {
            stringBuffer.append(charArray[i]);
        }
        return stringBuffer.toString();
    }

    // 功能测试
    @Test
    public void Test1() {
        String input = "abcdefg";
        String expected = "cdefgab";

        Assert.assertEquals(expected, leftRotateString(input, 2));
    }

    // 边界值测试
    @Test
    public void Test2() {
        String input = "abcdefg";
        String expected = "bcdefga";
        Assert.assertEquals(expected, leftRotateString(input, 1));
    }

    // 边界值测试
    @Test
    public void Test3() {
        String input = "abcdefg";
        String expected = "gabcdef";
        Assert.assertEquals(expected, leftRotateString(input, 6));
    }

    // 鲁棒性测试
    @Test
    public void Test4() {
        Assert.assertEquals(null, leftRotateString(null, 2));
    }

    // 鲁棒性测试
    @Test
    public void Test5() {
        String input = "abcdefg";
        String expected = "abcdefg";
        Assert.assertEquals(expected, leftRotateString(input, 0));
    }

    // 鲁棒性测试
    @Test
    public void Test6() {
        String input = "abcdefg";
        String expected = "abcdefg";
        Assert.assertEquals(expected, leftRotateString(input, 7));
    }
}
