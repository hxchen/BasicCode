package recursion.letterCasePermutation;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        // 1. s转换成char array处理
        char[] charArray = s.toCharArray();
        dfs(charArray, 0, res);
        return res;
    }
    private void dfs(char[] charArray, int index, List<String> res) {
        if (index == charArray.length) {
            res.add(new String(charArray));
            return;
        }

        dfs(charArray, index + 1, res);
        if (Character.isLetter(charArray[index])) {
            // 2. 和 1<<5 异或可以转换大小写 。或大小写转换也可以记住异或一个空格 charArray[index]^=' ';
            charArray[index] ^= ' ';
            dfs(charArray, index + 1, res);
        }
    }

    @Test
    public void Test1(){
        String s = "a1b2";
        List<String> ans = letterCasePermutation(s);
        ans.forEach(System.out::println);
    }
}
