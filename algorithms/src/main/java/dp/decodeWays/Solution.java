package dp.decodeWays;

import org.junit.Assert;
import org.junit.Test;

/**
 * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
 * 'A' -> "1"
 * 'B' -> "2"
 * ...
 * 'Z' -> "26"
 * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
 * "AAJF" ，将消息分组为 (1 1 10 6)
 * "KJF" ，将消息分组为 (11 10 6)
 * 注意，消息不能分组为  (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
 * 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
 * 题目数据保证答案肯定是一个 32 位 的整数。
 *
 *
 * 示例 1：
 * 输入：s = "12"
 * 输出：2
 * 解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
 *
 * 示例 2：
 * 输入：s = "226"
 * 输出：3
 * 解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 *
 * 示例 3：
 * 输入：s = "06"
 * 输出：0
 * 解释："06" 无法映射到 "F" ，因为存在前导零（"6" 和 "06" 并不等价）。
 */
public class Solution {

    /**
     * dp[i]表示前i个有的解码种数
     * 第一种情况：dp[i] = dp[i - 1]; i位置单独解码
     * 第二种情况：dp[i] = dp[i - 2]; i位置和前面i-1一起解码
     * @param s
     * @return
     */
    public int numDecodings(String s) {

        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;  // 空字符串可以解析出1种
        for (int i = 1; i <= len; i++) {
            if (s.charAt(i - 1) != '0'){
                dp[i] += dp[i - 1];
            }
            if (i > 1){
                int i1 = Integer.parseInt(s.substring(i - 2, i));
                if (i1 >= 10 && i1 < 27) {
                    // 前面一起解码
                    dp[i] += dp[i - 2] ;
                }
            }
        }
        return dp[len];
    }

    @Test
    public void  Test1(){
        Assert.assertTrue(numDecodings("11106") == 2);
    }
    @Test
    public void  Test2(){
        Assert.assertTrue(numDecodings("12") == 2);
    }
    @Test
    public void  Test3(){
        Assert.assertTrue(numDecodings("226") == 3);
    }
    @Test
    public void  Test4(){
        Assert.assertTrue(numDecodings("06") == 0);
    }
    @Test
    public void  Test5(){
        Assert.assertTrue(numDecodings("6060") == 0);
    }

    @Test
    public void  Test6(){
        Assert.assertTrue(numDecodings("2101") == 1);
    }
    @Test
    public void  Test7(){
        Assert.assertTrue(numDecodings("10") == 1);
    }

    @Test
    public void  Test8(){
        Assert.assertTrue(numDecodings("1123") == 5);
    }
}
