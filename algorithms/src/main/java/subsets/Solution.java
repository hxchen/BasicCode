package subsets;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Solution {
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
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        return null;
    }
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
}
