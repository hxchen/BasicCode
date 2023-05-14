package arrayString.distantBarcodes;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 在一个仓库里，有一排条形码，其中第 i 个条形码为barcodes[i]。
 *
 * 请你重新排列这些条形码，使其中任意两个相邻的条形码不能相等。 你可以返回任何满足该要求的答案，此题保证存在答案。
 *
 * 
 *
 * 示例 1：
 * 输入：barcodes = [1,1,1,2,2,2]
 * 输出：[2,1,2,1,2,1]
 *
 * 示例 2：
 * 输入：barcodes = [1,1,1,1,2,2,3,3]
 * 输出：[1,3,1,3,2,1,2,1]
 *
 * @see：<a href="https://leetcode.cn/problems/distant-barcodes">距离相等的条形码</a>
 */
public class Solution {
    /**
     * 题目要求重新排列这些条形码，使其中任意两个相邻的条形码不能相等，可以返回任何满足该要求的答案，并且此题保证存在答案。我们首先想到的思路就是，找到剩余数量最多的元素，尽可能优先排列它。
     *
     * 我们首先统计 barcodes 每个元素的个数，然后遍历这个频数表，把每个元素的 (剩余数量， 元素值) 二元数组，依次插入最大堆。这样操作后，堆顶的元素就是剩余数量最多的元素。
     *
     * 然后我们每次从堆顶拿出一个剩余最多的元素，放入排列中，再更新剩余数量，重新放入最大堆中。
     *
     * 如果这个元素和排列结果中的最后一个元素相同，那么我们就需要再从最大堆中取出第二多的元素，放入排列中，之后再把这两个元素放回最大堆中。
     *
     * 依次重复上面的操作，直到我们把所有元素都重新排列。
     *
     * @param barcodes
     * @return
     */
    public int[] rearrangeBarcodes(int[] barcodes) {
        // 统计条形码：值-数量
        Map<Integer, Integer> count = new HashMap<>();
        for (int b : barcodes) {
            if (!count.containsKey(b)) {
                count.put(b, 0);
            }
            count.put(b, count.get(b) + 1);
        }
        // 实现一个最大堆
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            pq.offer(new int[]{entry.getValue(), entry.getKey()});
        }
        int n = barcodes.length;
        int[] res = new int[n];
        for (int i = 0; i < n; ++i) {
            int[] p = pq.poll();
            int cx = p[0], x = p[1];
            if (i == 0 || res[i - 1] != x) {
                // 首位或者不和上一位相同，直接堆中获取当前值并设置
                res[i] = x;
                if (cx > 1) {
                    // 更新堆中数据
                    pq.offer(new int[]{cx - 1, x});
                }
            } else {
                // 获取堆中第二多的元素
                int[] p2 = pq.poll();
                int cy = p2[0], y = p2[1];
                res[i] = y;
                if (cy > 1) {
                    pq.offer(new int[]{cy - 1, y});
                }
                pq.offer(new int[]{cx, x});
            }
        }
        return res;
    }

    @Test
    public void Test1(){
        int[] barcodes = new int[]{1, 1, 1, 2, 2, 3, 3};
        System.out.println(Arrays.toString(rearrangeBarcodes(barcodes)));
    }

}
