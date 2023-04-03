package recursion.combinationSum;

import org.junit.Test;

import java.util.*;


public class Solution {
    /**
     * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
     * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
     * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
     *
     * 示例 1：
     * 输入：candidates = [2,3,6,7], target = 7
     * 输出：[[2,2,3],[7]]
     * 解释：
     * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
     * 7 也是一个候选， 7 = 7 。
     * 仅有这两种组合。
     *
     * 示例 2：
     * 输入: candidates = [2,3,5], target = 8
     * 输出: [[2,2,2,2],[2,3,3],[3,5]]
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<Integer>();
        dfs(candidates, target, 0, 0, path, res);
        return res;
    }

    /**
     * 解答这类题目，先画出来深度优先树形图，再写回溯代码
     * @param candidates
     * @param target
     * @param sum
     * @param index
     * @param path
     * @param res
     */
    private void dfs(int[] candidates, int target, int sum, int index, Deque<Integer> path, List<List<Integer>> res) {
        if (sum == target){
            res.add(new ArrayList<>(path));
            return;
        }
        if (sum > target){
            return;
        }
        for (int start = index; start < candidates.length; start++){
            path.offerLast(candidates[start]);
            sum += candidates[start];
            dfs(candidates, target, sum, start, path, res);
            path.pollLast();
            sum -= candidates[start];
        }
    }

    @Test
    public void Test1(){
        int[] candidates = new int[]{2, 3, 5};
        System.out.println(combinationSum(candidates, 8));
    }

    @Test
    public void Test2(){
        int[] candidates = new int[]{2, 3, 6, 7};
        System.out.println(combinationSum(candidates, 7));
    }

    @Test
    public void Test3(){
        int[] candidates = new int[]{2};
        System.out.println(combinationSum(candidates, 1));
    }

    /**
     * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     * candidates 中的每个数字在每个组合中只能使用 一次 。
     * 注意：解集不能包含重复的组合。
     *
     * 示例 1:
     * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
     * 输出:
     * [
     * [1,1,6],
     * [1,2,5],
     * [1,7],
     * [2,6]
     * ]
     *
     * 示例 2:
     * 输入: candidates = [2,5,2,1,2], target = 5,
     * 输出:
     * [
     * [1,2,2],
     * [5]
     * ]
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<Integer>();
        dfs2(candidates, target, 0, 0, path, res);
        return res;
    }

    private void dfs2(int[] candidates, int target, int sum, int index, Deque<Integer> path, List<List<Integer>> res) {
        if (sum == target){
            res.add(new ArrayList<>(path));
            return;
        }
        if (index >= candidates.length){
            return;
        }
        if (sum > target){
            return;
        }
        for (int start  = index; start < candidates.length; start++){
            if (start > index && candidates[start] == candidates[start - 1]){
                // 重复数字，去重
                continue;
            }
            path.offerLast(candidates[start]);
            sum += candidates[start];
            dfs2(candidates, target, sum, start + 1, path, res);
            path.pollLast();
            sum -= candidates[start];
        }
    }

    @Test
    public void Test4(){
        int[] candidates = new int[]{1, 1, 2, 5, 6, 7, 10};
        System.out.println(combinationSum2(candidates, 8));
    }

    @Test
    public void Test5(){
        int[] candidates = new int[]{2, 5, 2, 1, 2};
        System.out.println(combinationSum2(candidates, 5));
    }
}
