package slidingWindow.longestSubStringWithoutRepeatingChars;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 */
public class Solution {
    /**
     * 滑动窗口
     * 找以right结尾的最长子串
     * 遇到重复出现的字符收缩left到移除该重复字符
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int left =  0;
        int len = s.length();
        Set<Character> set = new HashSet<>();
        int cur = 0;
        for (int right = 0; right < len; right++){
            if (!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                cur++;
                max = Math.max(max, cur);
            }else{
                // 收缩left直到移除该值
                while (s.charAt(left) != s.charAt(right)){
                    set.remove(s.charAt(left));
                    left++;
                    cur--;
                }
                left++;
            }
        }
        return max;
    }

    @Test
    public void Test1(){
        Assert.assertTrue(lengthOfLongestSubstring("abcabcbb") == 3);
    }
    @Test
    public void Test2(){
        Assert.assertTrue(lengthOfLongestSubstring("bbbbb") == 1);
    }
    @Test
    public void Test3(){
        Assert.assertTrue(lengthOfLongestSubstring("pwwkew") == 3);
    }
}
