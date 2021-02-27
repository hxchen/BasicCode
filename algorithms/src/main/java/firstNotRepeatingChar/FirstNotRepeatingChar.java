package firstNotRepeatingChar;

import org.junit.Assert;
import org.junit.Test;

/**
 * 字符串中第一个只出现一次的字符
 * 题目：在字符串中找出第一个只出现一次的字符。如输入"abaccdeff"，则输出
 * 'b'。
 * Created by hxchen on 2018/8/1.
 */
public class FirstNotRepeatingChar {

    public char FirstNotRepeatingCHar(String string) {
        int[] count = new int[256];
        char[] chars = string.toCharArray();
        for(char c : chars){
            count[c]++;
        }
        for(char c : chars){
            if(count[c] == 1){
                return c;
            }

        }
        return '\0';
    }

    @Test
    public void Test1() {
        String string = "abaccdeff";
        Assert.assertSame('b', FirstNotRepeatingCHar(string));
    }

    @Test
    public void Test2() {
        String string = "";
        Assert.assertSame('\0', FirstNotRepeatingCHar(string));
    }

    @Test
    public void Test3() {
        String string = "aabbcc";
        Assert.assertSame('\0', FirstNotRepeatingCHar(string));
    }

    @Test
    public void Test4() {
        String string = "abcdefg";
        Assert.assertSame('a', FirstNotRepeatingCHar(string));
    }
    @Test
    public void Test5() {
        String string = "dcba";
        Assert.assertSame('d', FirstNotRepeatingCHar(string));
    }
}
