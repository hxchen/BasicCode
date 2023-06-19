package recursion.combinations;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        backtrack(result, current, 1, n, k);
        return result;
    }

    /**
     * 首先，我们检查当前组合的大小是否达到了目标长度 k。如果是，说明我们已经构建了一个符合要求的组合，将其添加到结果列表 result 中，然后返回。
     * 如果当前组合的大小还没有达到目标长度 k，则继续构建组合。
     * 使用一个循环从 start 到 n 的范围内遍历可能的数字。
     * 在每个迭代中，将当前数字 i 添加到组合 current 中。
     * 然后，递归调用 backtrack 函数，但这次要将 start 设置为 i + 1，以避免使用重复的数字。
     * 在递归调用完成后，需要将刚刚添加的数字从组合 current 中移除，以便进行下一次迭代时能够尝试其他数字。
     * 当循环结束时，回溯函数执行完毕，所有可能的组合都已经生成。
     * @param result
     * @param current
     * @param start
     * @param n
     * @param k
     */
    private static void backtrack(List<List<Integer>> result, List<Integer> current, int start, int n, int k) {
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i <= n; i++) {
            current.add(i);
            backtrack(result, current, i + 1, n, k);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        List<List<Integer>> combinations = combine(n, k);
        for (List<Integer> combination : combinations) {
            System.out.println(combination);
        }
    }
}
