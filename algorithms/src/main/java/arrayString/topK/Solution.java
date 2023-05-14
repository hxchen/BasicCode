package arrayString.topK;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {

    public int[] findTopK(int[] nums, int k){
        // 队列默认自然顺序排列，小顶堆，不必重写compare
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        for (int num : nums) {
            if (pq.size() < k) {
                pq.offer(num);
            } else if (pq.peek() < num) {
                // 如果堆顶元素 < 新数，则删除堆顶，加入新数入堆
                pq.poll();
                pq.offer(num);
            }
        }

        int[] result = new int[k];
        for (int i = 0; i < k && !pq.isEmpty(); i++) {
            result[i] = pq.poll();
        }
        return result;
    }

    @Test
    public void Test1(){
        int[] nums = new int[]{1, 6, 3, 2, 5, 4, 8, 9, 7};
        System.out.println(Arrays.toString(findTopK(nums, 5)));
    }
}
