package dp.longestCommonSubsequence;

import org.junit.Assert;
import org.junit.Test;

/**
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 *
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 *
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 *
 *
 *
 * 示例 1：
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace" ，它的长度为 3 。
 *
 * 示例 2：
 * 输入：text1 = "abc", text2 = "abc"
 * 输出：3
 * 解释：最长公共子序列是 "abc" ，它的长度为 3 。
 *
 * 示例 3：
 * 输入：text1 = "abc", text2 = "def"
 * 输出：0
 * 解释：两个字符串没有公共子序列，返回 0 。
 * @See <a href="https://leetcode.cn/problems/longest-common-subsequence/description/?envType=study-plan&id=suan-fa-ji-chu&plan=algorithms&plan_progress=xhm2inum">LeetCode</a>
 */
public class Solution {
    /**
     * 二维数组的DP问题
     * 定义dp[i][j]  表示text1[0:i]和text2[0:j]的最长公共子序列的长度，text1[0:i] 表示 text1的长度为i的前缀
     * 对于边界问题有 dp[0][j] = 0 和 dp[i][0] = 0
     * 状态转移方程：
     * dp[i][j] = dp[i - 1][j - 1] + 1; text[i - 1] = text[j - 1]
     * dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);  text1[i - 1] != text[j - 1]
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][ text2.length() + 1];

        for (int i = 1; i <= text1.length(); i++) { // 注意边界
            for (int j = 1; j <= text2.length(); j++) { // 注意边界
                if (text1.charAt(i - 1) == text2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }

    @Test
    public void Test1(){
        String text1 = "abcde";
        String text2 = "ace";
        Assert.assertTrue(longestCommonSubsequence(text1, text2) == 3);
    }

    @Test
    public void Test2(){
        String text1 = "abc";
        String text2 = "abc";
        Assert.assertTrue(longestCommonSubsequence(text1, text2) == 3);
    }

    @Test
    public void Test3(){
        String text1 = "abc";
        String text2 = "def";
        Assert.assertTrue(longestCommonSubsequence(text1, text2) == 0);
    }

    @Test
    public void Test4(){
        String text1 = "oxcpqrsvwf";
        String text2 = "shmtulqrypy";
        Assert.assertTrue(longestCommonSubsequence(text1, text2) == 2);
    }

    @Test
    public void Test5(){
        String text1 = "ezupkr";
        String text2 = "ubmrapg";
        Assert.assertTrue(longestCommonSubsequence(text1, text2) == 2);
    }

}
