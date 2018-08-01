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

    public char FirstNotRepeatingCHar(String string){
        if (null == string)
            return '\0';
        int[] array = new int[26];
        for (int i = 0; i < array.length; i++){
            array[i] = 0;
        }
        for (int i = 0; i < string.length(); i++){
            char letter = string.charAt(i);
            int index = letter - 'a';
            array[index] = array[index] + 1;
        }
        for (int i = 0; i < array.length; i++){
            if (array[i] == 1){
                return (char) (i + 'a');
            }
        }
        return '\0';
    }

    @Test
    public void Test1(){
        String string = "abaccdeff";
        Assert.assertSame('b', FirstNotRepeatingCHar(string));
    }
    @Test
    public void Test2(){
        String string = "";
        Assert.assertSame('\0', FirstNotRepeatingCHar(string));
    }
    @Test
    public void Test3(){
        String string = "aabbcc";
        Assert.assertSame('\0', FirstNotRepeatingCHar(string));
    }
    @Test
    public void Test4(){
        String string = "abcdefg";
        Assert.assertSame('a', FirstNotRepeatingCHar(string));
    }
}
