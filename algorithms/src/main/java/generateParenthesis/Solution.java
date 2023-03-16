package generateParenthesis;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *
 *
 * 示例 1：
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 *
 * 示例 2：
 * 输入：n = 1
 * 输出：["()"]
 */
public class Solution {
    /**
     * 画出树形图：n个左括号, n个右括号.树形图是对左右的选择。
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(res, "", n, n);
        return res;
    }

    private void dfs(List<String> res, String path, int left, int right) {
        if (left > right){
            //剩余左括号数量大于右括号数量,剪枝
            return;
        }
        if (left == 0 && right == 0){
            res.add(path);
            return;
        }
        // 使用一个左括号
        if (left > 0){
            dfs(res, path + "(", left - 1, right);
        }
        // 使用一个右括号
        if (right > 0){
            dfs(res, path + ")", left, right - 1);
        }
    }

    @Test
    public void Test1(){
        System.out.println(generateParenthesis(2));
    }

}
