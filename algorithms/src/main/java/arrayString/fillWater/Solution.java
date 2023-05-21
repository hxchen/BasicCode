package arrayString.fillWater;

import org.junit.Assert;
import org.junit.Test;

import java.util.PriorityQueue;

public class Solution {
    public int storeWater(int[] bucket, int[] vat) {
        int n = bucket.length;
        // 二元组(cnt[i], i)表示第i个水缸需要的蓄水操作次数cnt[i]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        // 升级次数
        int cnt = 0;
        for (int i = 0; i < n; ++i) {
            if (bucket[i] == 0 && vat[i] != 0) {
                ++cnt;
                ++bucket[i];
            }
            if (vat[i] > 0) {
                pq.offer(new int[]{(vat[i] + bucket[i] - 1) / bucket[i], i});
            }
        }
        if (pq.isEmpty()) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        while (cnt < res) {
            int[] arr = pq.poll();
            // v 蓄水次数
            int v = arr[0], i = arr[1];
            res = Math.min(res, cnt + v);
            if (v == 1) {
                break;
            }
            // 当前蓄水次数v 计算再升级一次后的容量
            int t = bucket[i] + 1;
            cnt ++;
            bucket[i] = t;
            pq.offer(new int[]{(vat[i] + bucket[i] - 1) / bucket[i], i});
        }
        return res;
    }


    @Test
    public void Test1(){
        int[] bucket = {1, 3};
        int[] vat = {6, 8};
        Assert.assertTrue(storeWater(bucket, vat) == 4);
    }
    @Test
    public void Test2(){
        int[] bucket = {9, 0, 1};
        int[] vat = {0, 2, 2};
        Assert.assertTrue(storeWater(bucket, vat) == 3);
    }

    @Test
    public void Test3(){
        int[] bucket = {0, 0, 1};
        int[] vat = {6, 8, 2};
        Assert.assertTrue(storeWater(bucket, vat) == 8);
    }

    @Test
    public void Test4(){
        int[] bucket = {2, 27, 24, 75};
        int[] vat = {53, 52, 28, 82};
        Assert.assertTrue(storeWater(bucket, vat) == 13);
    }

    @Test
    public void Test5(){
        int[] bucket = {3710,6067,2993,70,2340,2748,9385,3027,3456,5246,9739,1220,9539,9074,4729,7051,8462,6908,3649,9996,8890,2980,4350,7350,6344,6759,4420,269,9341,648,7737,8133,3717,2766,5807,4338,2077,5775,4905,7262,1258,613,3837,3475,437,3739,9814,4790,2075,7722,3290,5685,3499,6992,4421,934,6004,5763,3463,6138,8818,445,4778,4979,126,3969,2994,87,3739,8582,9559,8326,9132,257,8928,9147,1615,4665,9828,3925,6435,5326,836,519,298,600,5503,273,9580,5383,8966,4810,1386,7207,8060,678,8837,6946,1210,945};
        int[] vat = {6304,6509,4276,9645,6455,8167,9667,4385,8872,7889,9936,4413,9922,9894,8065,7627,9225,9907,7055,9996,9439,3351,9317,8363,9383,6850,4621,5389,9508,3391,9650,8363,8719,5594,8770,5403,7107,9941,9254,9355,4614,4640,4896,8759,4397,8441,9870,9906,2396,8092,6939,9432,8182,9090,8029,4930,7772,7066,7279,7778,9529,2947,6552,6930,5260,8470,8478,1371,9453,9767,9888,9964,9960,3990,9391,9377,3063,5374,9880,7684,7864,7078,2622,3754,617,9773,9415,8026,9883,5735,9233,6715,9105,7932,9178,1081,9340,7284,6621,1965};
        Assert.assertTrue(storeWater(bucket, vat) == 127);
    }

    @Test
    public void Test6(){
        int[] bucket = {70};
        int[] vat = {9645};
        System.out.println(storeWater(bucket, vat));
    }
}
