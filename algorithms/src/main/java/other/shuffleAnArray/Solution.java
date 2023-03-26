package other.shuffleAnArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Solution {
    // 当前数组
    int[] nums;
    // 原始数组
    int[] original;

    public Solution(int[] nums) {
        this.nums = nums;
        original = Arrays.copyOfRange(nums, 0, nums.length);
    }

    public int[] reset() {
        nums = Arrays.copyOfRange(original, 0, original.length);
        return nums;
    }

    /**
     * 暴力洗牌
     * 时间 51 ms 击败 48.80%
     * 内存 47.5 MB 击败 18.54%
     * @return
     */
    public int[] shuffle() {
        int[] shuffled = new int[nums.length];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++){
            list.add(nums[i]);
        }
        Random random = new Random();
        for (int i = 0; i < nums.length; i++){
            int j = random.nextInt(list.size());
            shuffled[i] = list.remove(j);
        }
        nums = Arrays.copyOfRange(shuffled, 0, shuffled.length);
        return nums;
    }

    /**
     * Fisher-Yates 洗牌算法
     * 循环 n 次，在第 i 次循环中（0 <= i < n）：
     * 在 [i,n) 中随机抽取一个下标 j；
     * 将第 i 个元素与第 j 个元素交换。
     * 时间 59 ms 击败 10.80%
     * 内存 47.4 MB 击败 26.23%
     * @return
     */
    public int[] shuffle2(){
        Random random = new Random();
        for (int i = 0; i < nums.length; ++i) {
            int j = i + random.nextInt(nums.length - i);
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return nums;
    }
}
