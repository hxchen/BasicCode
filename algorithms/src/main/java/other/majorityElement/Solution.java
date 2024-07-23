package other.majorityElement;

/**
 * 多数元素
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例 1：
 * 输入：nums = [3,2,3]
 * 输出：3
 *
 * 示例 2：
 * 输入：nums = [2,2,1,1,1,2,2]
 * 输出：2
 */
public class Solution {

    /**
     * 摩尔投票算法的核心思想是通过一个计数器来跟踪可能的多数元素。
     * 当计数器为0时，更新当前候选元素，并重新计数。最终留下的候选元素即为多数元素。
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if(candidate == nums[i]){
                count++;
            }else {
                count--;
                if (count == 0) {
                    candidate = nums[i];
                    count = 1;
                }
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {3, 2, 3};
        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(solution.majorityElement(nums1)); // 输出: 3
        System.out.println(solution.majorityElement(nums2)); // 输出: 2
    }
}
