package dp.deleteOperationForTwoStrings;

import org.junit.Assert;
import org.junit.Test;

/**
 * 给定两个单词 word1 和 word2 ，返回使得 word1 和  word2 相同所需的最小步数。
 *
 * 每步 可以删除任意一个字符串中的一个字符。
 *
 * 示例 1：
 * 输入: word1 = "sea", word2 = "eat"
 * 输出: 2
 * 解释: 第一步将 "sea" 变为 "ea" ，第二步将 "eat "变为 "ea"
 *
 * 示例  2:
 * 输入：word1 = "leetcode", word2 = "etco"
 * 输出：4
 *
 */
public class Solution {
    /**
     * 有了上一题：最长公共子序列，我们很容易想到采用二维数组和dp的意义。
     * 难点在于分析增加一个i 和 j 字符的时候，从哪步转移过来。是[i - 1, j -1] 还是[i - 1, j] 或 [i, j - 1]呢
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        // 定义dp[i][j]表示 word1的前i个和word2的前j个字符到达需求所需要删除的次数
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= word1.length(); i++){
            dp[i][0] = i;
        }
        for (int j = 1; j <= word2.length(); j++){
            dp[0][j] = j;
        }
        // dp[i][j] = dp[i - 1][j - 1]  条件：word1[i - 1] == word2[j - 1]
        // dp[i][j] = Min(dp[i][j - 1] + 1, dp[i - 1][j] + 1)

        for (int i = 1; i <= word1.length(); i++){
            for (int j = 1; j <= word2.length(); j++){
                if (word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                }else {
                    dp[i][j] = Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1);
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }

    @Test
    public void Test1(){
        Assert.assertTrue(minDistance("sea", "eat") == 2);
    }

    @Test
    public void Test2(){
        Assert.assertTrue(minDistance("github", "th") == 4);
    }
}
