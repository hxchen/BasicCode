package longestSubstringWithoutDup;

import org.junit.Assert;
import org.junit.Test;

/**
 * 最长不含重复字符的子字符串
 * 请从字符串中找出一个最长的不包含重复字符串的子字符串，计算该最长子字符串的长度。假设字符串中只包含‘a’~‘z’的字符。
 * 例如，在字符串“arabcacfr”中，最长的不含重复字符的子字符串是“acfr”，长度为4。
 * Created by hxchen on 2018/7/29.
 */
public class LongestSubstringWithoutDup {

    /**
     * 动态规划
     * f(i)表示以第i个字符串为结尾的不包含重复字符的子字符串的最长长度
     * @param string
     * @return
     */
    public static int longestSubstringWithoutDuplication(String string){
        if(string == null)
        return 0;

        // 定义position数组,用来存储每个字符上次出现在字符串中位置的下标
        int[] position = new int[26];
        int max = 0;
        int curLength = 0;  //f(i)

        for(int i = 0; i < 26; i++){
            position[i] = -1;
        }
        for(int i = 0; i < string.length(); i++){

            int preIndex = position[string.charAt(i) - 'a'];    //位置i的字母,上一次出现的位置

            if(preIndex < 0 || i - preIndex > curLength){//没有出现过,或者上次出现在f(i-1)对应的最长子字符串之前
                curLength++;
            }else {// i位置字母,出现过。出现在f(i-1)之中
                if (curLength > max)
                    max = curLength;
                curLength = i - preIndex;

            }
            position[string.charAt(i) - 'a'] = i;
        }
        if(curLength > max)
            max = curLength;
        return max;
    }

    @Test
    public void Test1(){
        String string = "abcacfrar";
        int expected = 4;
        Assert.assertTrue(longestSubstringWithoutDuplication(string) == expected);
    }
    @Test
    public void Test2(){
        String string = "acfrarabc";
        int expected = 4;
        Assert.assertTrue(longestSubstringWithoutDuplication(string) == expected);
    }
    @Test
    public void Test3(){
        String string = "arabcacfr";
        int expected = 4;
        Assert.assertTrue(longestSubstringWithoutDuplication(string) == expected);
    }
    @Test
    public void Test4(){
        String string = "aaaa";
        int expected = 1;
        Assert.assertTrue(longestSubstringWithoutDuplication(string) == expected);
    }
    @Test
    public void Test5(){
        String string = "abcdefg";
        int expected = 7;
        Assert.assertTrue(longestSubstringWithoutDuplication(string) == expected);
    }
    @Test
    public void Test6(){
        String string = "aaabbbccc";
        int expected = 2;
        Assert.assertTrue(longestSubstringWithoutDuplication(string) == expected);
    }
    @Test
    public void Test7(){
        String string = "abcdcba";
        int expected = 4;
        Assert.assertTrue(longestSubstringWithoutDuplication(string) == expected);
    }
    @Test
    public void Test8(){
        String string = "abcdaef";
        int expected = 6;
        Assert.assertTrue(longestSubstringWithoutDuplication(string) == expected);
    }
    @Test
    public void Test9(){
        String string = "a";
        int expected = 1;
        Assert.assertTrue(longestSubstringWithoutDuplication(string) == expected);
    }
    @Test
    public void Test10(){
        String string = "";
        int expected = 0;
        Assert.assertTrue(longestSubstringWithoutDuplication(string) == expected);
    }

}
