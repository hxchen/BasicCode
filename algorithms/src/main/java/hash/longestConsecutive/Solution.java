package hash.longestConsecutive;

/**
 * 最长连续序列
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 示例 2：
 *
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 */
public class Solution {
    public int longestConsecutive(int[] nums) {
        int result = 0;
        java.util.Set<Integer> set = new java.util.HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentResult = 1;
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentResult++;
                }
                result = Math.max(result, currentResult);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{100, 4, 200, 1, 3, 2};
        Solution solution = new Solution();
        System.out.println(solution.longestConsecutive(nums));
    }
}