package findAllAnagramsInAString;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）
 *
 * 示例 1:
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 *
 * 示例 2:
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 */
public class Solution {

    /**
     * 根据题目要求，我们需要在字符串 s 寻找字符串 p 的异位词。
     * 因为字符串 p 的异位词的长度一定与字符串 p 的长度相同，
     * 所以我们可以在字符串 s 中构造一个长度为与字符串 p 的长度相同的滑动窗口，
     * 并在滑动中维护窗口中每种字母的数量；当窗口中每种字母的数量与字符串 p 中每种字母的数量相同时，则说明当前窗口为字符串 p 的异位词。
     * 在算法的实现中，我们可以使用数组来存储字符串 ppp 和滑动窗口中每种字母的数量。
     * 另外：string.charAt(index) - 'a' 可以表示string中index 位置的字母映射到0-26的位置。
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        if (sLen < pLen){
            return new ArrayList<>();
        }
        List<Integer> ans = new ArrayList<>();
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for(int i = 0; i < p.length(); i++){
            sCount[s.charAt(i) - 'a']++;
            pCount[p.charAt(i) - 'a']++;
        }
        if (Arrays.equals(sCount, pCount)){
            // s的前pLen个恰好是异位词
            ans.add(0);
        }
        // 滑动窗口开始滑
        for(int i = 0; i < sLen - pLen; i++){
            sCount[s.charAt(i) - 'a']--;
            sCount[s.charAt(i + pLen) - 'a']++;
            if (Arrays.equals(sCount, pCount)){
                ans.add(i + 1);
            }
        }
        return  ans;
    }

    @Test
    public void Test1(){
        String s = "cbaebabacd", p = "abc";
        System.out.println(findAnagrams(s,p).toString());
    }

}
