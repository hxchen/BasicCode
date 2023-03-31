package slidingWindow.permutationInAString;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
 *
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 *
 * 示例 1：
 * 输入：s1 = "ab" s2 = "eidbaooo"
 * 输出：true
 * 解释：s2 包含 s1 的排列之一 ("ba").
 *
 * 示例 2：
 * 输入：s1= "ab" s2 = "eidboaoo"
 * 输出：false
 */
public class Solution {
    /**
     * 固定窗口长度是S1的长度，在S2上滑动来判断是否等于S1
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] s1Array = new int[26];
        for(int i = 0; i < s1.length(); i++){
            s1Array[s1.charAt(i) - 'a']++;
        }
        int winLen = s1.length();
        int[] s2Array = new int[26];
        int start = 0;
        for (int j = 0; j < s2.length(); j++){
            s2Array[s2.charAt(j) - 'a']++;
            if (j - start + 1 == winLen){
                if (Arrays.equals(s1Array, s2Array)){
                    return true;
                }else{
                    s2Array[s2.charAt(start) - 'a']--;
                    start++;
                }
            }
        }
        return false;
    }

    @Test
    public void Test1(){
        Assert.assertTrue(checkInclusion("ab", "eidbaooo"));
    }

    @Test
    public void Test2(){
        Assert.assertTrue(!checkInclusion("ab", "eidboaoo"));
    }
}
