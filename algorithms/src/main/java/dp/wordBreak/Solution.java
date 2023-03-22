package dp.wordBreak;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

/**
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
 *
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 *
 * 示例 1：
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
 *
 * 示例 2：
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
 *      注意，你可以重复使用字典中的单词。
 *
 * 示例 3：
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 */
public class Solution {
    /**
     * 动态规划
     * dp[i] 表示 s 的前 i 个字符串是否可以被拼接
     * 转移方程：dp[i] = dp[j] + Check(s[j,i-1]);
     * dp[0] = true; 表示空串且合法
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String > set = new HashSet<>(wordDict);

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1 ; i <= s.length(); i++){
            for (int j = 0; j < i; j++){
                if (dp[j] && set.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }


    /**
     * 递归解法
     * 缺点：会超时
     * @param s
     * @param wordDict
     * @return
     */
    public boolean dfs(String s, List<String> wordDict){
        if (s.equals("")) return true;
        for (String word:wordDict){
            if (s.startsWith(word)){
                if (dfs(s.substring(word.length()), wordDict)){
                    return true;
                }
            }
        }
        return false;
    }

    @Test
    public void Test1(){
        String s = "leetcode";
        Assert.assertTrue(wordBreak(s, Arrays.asList("leet", "code")));
    }
    @Test
    public void Test2(){
        String s = "applepenapple";
        Assert.assertTrue(wordBreak(s, Arrays.asList("apple", "pen")));
    }
    @Test
    public void Test3(){
        String s = "catsandog";
        Assert.assertTrue(!wordBreak(s, Arrays.asList("cats", "dog", "sand", "and", "cat")));
    }

    @Test
    public void Test4(){
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        Assert.assertTrue(!wordBreak(s, Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa")));
    }

}
