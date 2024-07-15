package recursion.letterCombinationsOfAPhoneNumber;

import java.util.ArrayList;
import java.util.List;

public class SolutionOfBacktrack {
    // 数字到字母的映射
    private static final String[] KEYPAD = {
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
    };

    /**
     * 要解决这个问题，我们可以使用回溯算法来生成所有可能的字母组合。回溯算法适用于组合和排列问题，因为它可以通过递归逐步构建解决方案。
     *
     * 具体步骤如下：
     *
     * 定义映射关系：定义数字到字母的映射关系。
     * 回溯函数：递归构建字母组合。每次选择一个数字，对应的字母逐个添加到当前组合中，然后继续处理下一个数字。
     *
     * 解释：
     *
     * 定义映射关系：使用数组 KEYPAD 存储数字到字母的映射。
     * 主函数 letterCombinations：
     * 初始化结果列表 result。
     * 处理空输入的特殊情况。
     * 调用辅助函数 backtrack 开始回溯构建字母组合。
     * 辅助函数 backtrack：
     * 终止条件：当 index 等于输入字符串的长度时，当前组合构建完成，添加到结果列表中。
     * 选择路径：获取当前数字对应的字母，逐个添加到当前组合中。
     * 递归调用：递归处理下一个数字。
     * 回溯：回溯时，移除最后添加的字母，继续尝试其他字母。
     * 这个方法可以生成所有可能的字母组合，时间复杂度为 O(3^n * 4^m)，其中 n 是映射到 3 个字母的数字的数量，m 是映射到 4 个字母的数字的数量。空间复杂度为 O(n)，用于存储递归调用栈和临时变量。
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        backtrack(result, new StringBuilder(), digits, 0);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder current, String digits, int index) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        String letters = KEYPAD[digits.charAt(index) - '0'];
        for (char letter : letters.toCharArray()) {
            current.append(letter);
            backtrack(result, current, digits, index + 1);
            current.deleteCharAt(current.length() - 1);
        }
    }

    public static void main(String[] args) {
        SolutionOfBacktrack solution = new SolutionOfBacktrack();
        System.out.println(solution.letterCombinations("23")); // ["ad","ae","af","bd","be","bf","cd","ce","cf"]
        System.out.println(solution.letterCombinations("")); // []
        System.out.println(solution.letterCombinations("2")); // ["a","b","c"]
    }
}
