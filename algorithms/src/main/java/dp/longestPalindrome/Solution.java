package dp.longestPalindrome;

import org.junit.Test;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 *
 * 示例 1：
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 *
 * 示例 2：
 * 输入：s = "cbbd"
 * 输出："bb"
 */
public class Solution {
    /**
     * 动态规划解法
     * 回文子串特性：去掉首尾后仍然是回文子串
     * dp[i][j]表示从下标i开始到下标j是否是回文子串，对于dp[i][i] = true
     * 转态转移方程: dp[i][j] = dp[i][i] == dp[j][j] && dp[i+1][j-1]
     * 临界条件是：(j-1) - (i+1) + 1 < 2, j - i < 3
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) return s;
        int maxLen = 1, begin = 0;
        boolean[][] dp = new boolean[len][len];
        // 用不到，优化掉
//        for (int i = 0; i < len; i++){
//            dp[i][i] = true;
//        }
        for (int j = 1; j < len; j++){
            for(int i = 0; i < j; i++){

                if (s.charAt(i) != s.charAt(j)){
                    dp[i][j] = false;
                }else {
                    if (j - i < 3){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] =  dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && j - i + 1 > maxLen){
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    @Test
    public void Test1(){
        String s= "babad";
        System.out.println(longestPalindrome(s));
    }

    @Test
    public void Test2(){
        String s= "cbbd";
        System.out.println(longestPalindrome(s));
    }

    @Test
    public void Test3(){
        String s = "ac";
        System.out.println(longestPalindrome(s));
    }
}
