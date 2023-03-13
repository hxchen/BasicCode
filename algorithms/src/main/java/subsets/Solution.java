package subsets;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class Solution {


    /**
     * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
     *
     * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [1,2,3]
     * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
     * 示例 2：
     *
     * 输入：nums = [0]
     * 输出：[[],[0]]
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        addSub(ans, nums, 0);
        return ans;
    }

    /**
     * 递归解法
     * @param ans
     * @param nums
     * @param current
     */
    public void addSub(List<List<Integer>> ans, int[]nums, int current){
        if (current == nums.length){
            return;
        }
        int ansSize = ans.size();
        for (int i = 0; i < ansSize;i++){
            List<Integer> subsets = new ArrayList<>(ans.get(i));
            subsets.add(nums[current]);
            ans.add(subsets);
        }
        addSub(ans, nums, current + 1);
    }
    @Test
    public void Test1(){
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));
    }
    ///////////////////////////////////////// 回溯法
    /**
     * 回溯法
     * 遍历所有子集长度k(0 <= k <= n),通过回溯生成所有给定长度的子集。
     * 算法：
     * 对于所有子集长度 0 <= k <= n;
     * 对于开始位置 0 <= start <= n 寻找长度为k的子集：
     *  1.如果当前子集长度为k = 0， 则当前子集构建完成，将其加入到输入出结果。
     *  2.把nums[start]加入当前子集
     *  3.以当前子集为基础在nums[start + 1, n - 1]中寻找长度为 k - 1 的子集
     *  4.把nums[start]从当前子集移除
     *  例如[1， 2， 3]
     *      k = 0:[[]]
     *      k = 1:[[1], [2],[3]]
     *      k = 2:[[1, 2],[1, 3],[2, 3]]
     *      k = 3:[[1, 2, 3]]
     */

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets12(int[] nums) {
        for (int k = 0; k <= nums.length; k++){
            backTracking12(0, k, new ArrayList<>(), nums);
        }
        return result;
    }
    public void backTracking12(int start , int k, ArrayList<Integer> cur, int[] nums){
        if (k == 0){
            result.add(new ArrayList<>(cur));
            return;
        }
        for (int i = start; i < nums.length; i++){
            cur.add(nums[i]);
            backTracking12(i + 1, k - 1, cur, nums);
            //回溯 删掉最后一个
            cur.remove(cur.size() - 1);
        }
    }

    @Test
    public void Test12(){
        int[] nums = {1, 2, 3};
        System.out.println(subsets12(nums));
    }
    /////////////////////////////// 子集2 重复数组的情况

    /**
     * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
     * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
     *
     * 示例 1：
     *
     * 输入：nums = [1,2,2]
     * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
     * 示例 2：
     *
     * 输入：nums = [0]
     * 输出：[[],[0]]
     * @param nums
     * @return
     */
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // 先进行排序
        Arrays.sort(nums);
        backTracking21(0, nums);
        return res;
    }

    public void backTracking21(int start, int[] nums) {
        res.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; ++i) {
            // 去重
            if (i > start && nums[i] == nums[i - 1]) continue;
            path.add(nums[i]);
            backTracking21(i + 1, nums);
            path.remove(path.size() - 1);
        }
    }

    @Test
    public void Test21(){
        int[] nums = new int[]{1, 2, 2, 2, 2};
        System.out.println(subsetsWithDup(nums));
    }


}
