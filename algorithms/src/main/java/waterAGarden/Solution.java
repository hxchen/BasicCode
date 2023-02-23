package waterAGarden;

import org.junit.Test;

/**
 * 在 x 轴上有一个一维的花园。花园长度为 n，从点 0 开始，到点 n 结束。
 * 花园里总共有 n + 1 个水龙头，分别位于 [0, 1, ..., n] 。
 * 给你一个整数 n 和一个长度为 n + 1 的整数数组 ranges ，其中 ranges[i] （下标从 0 开始）表示：如果打开点 i 处的水龙头，可以灌溉的区域为 [i -  ranges[i], i + ranges[i]] 。
 * 请你返回可以灌溉整个花园的 最少水龙头数目 。如果花园始终存在无法灌溉到的地方，请你返回 -1 。
 * @see <a href="https://leetcode.cn/problems/minimum-number-of-taps-to-open-to-water-a-garden/description/">luo.com</a>
 * @author haixiangchen
 */
public class Solution {
    public int minTaps(int n, int[] ranges){
        int[] rightMost = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            rightMost[i] = i;
        }
        for (int i = 0; i <= n; i++) {
            int start = Math.max(0, i - ranges[i]);
            int end = Math.min(n, i + ranges[i]);
            // 以他作为左端点的，最右灌溉点
            rightMost[start] = Math.max(rightMost[start], end);
        }
        // last ----当前能覆盖到的最远的右端点; pre ---- 记录上一个被使用的子区间的结束位置
        int last = 0, ret = 0, pre = 0;
        for (int i = 0; i < n; i++) {
            last = Math.max(last, rightMost[i]);
            if (i == last) {
                return -1;
            }
            if (i == pre) {
                ret++;
                pre = last;
            }
        }
        return ret;
    }

    @Test
    public void Test1(){
        int n = 5;
        int[] ranges = new int[] {3, 4, 1, 1, 0, 0};
        System.out.println(minTaps(n, ranges));
    }

}
