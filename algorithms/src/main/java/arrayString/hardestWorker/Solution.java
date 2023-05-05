package arrayString.hardestWorker;

import org.junit.Assert;
import org.junit.Test;

/**
 * 共有 n 位员工，每位员工都有一个从 0 到 n - 1 的唯一 id 。
 *
 * 给你一个二维整数数组 logs ，其中 logs[i] = [idi, leaveTimei] ：
 *
 * idi 是处理第 i 个任务的员工的 id ，且
 * leaveTimei 是员工完成第 i 个任务的时刻。所有 leaveTimei 的值都是 唯一 的。
 * 注意，第 i 个任务在第 (i - 1) 个任务结束后立即开始，且第 0 个任务从时刻 0 开始。
 *
 * 返回处理用时最长的那个任务的员工的 id 。如果存在两个或多个员工同时满足，则返回几人中 最小 的 id 。
 *
 * @see：<a href="https://leetcode.cn/problems/the-employee-that-worked-on-the-longest-task">LeetCode</a>
 */
public class Solution {
    public int hardestWorker(int n, int[][] logs) {
        int maxTime = logs[0][1];
        int minId = logs[0][0];
        for (int i = 1; i < logs.length; i++){
            int time = logs[i][1] - logs[i - 1][1];
            if (time > maxTime){
                minId = logs[i][0];
                maxTime = time;
            }else if(time == maxTime){
                minId = Math.min(minId, logs[i][0]);
            }
        }
        return minId;
    }

    @Test
    public void Test1(){
        int n = 10;
        int[][] logs = new int[][]{{0, 3}, {2, 5}, {0, 9}, {1, 15}};
        Assert.assertTrue(hardestWorker(n, logs) == 1);
    }

    @Test
    public void Test2(){
        int n = 26;
        int[][] logs = new int[][]{{1, 1}, {3, 7}, {2, 12}, {7, 17}};
        Assert.assertTrue(hardestWorker(n, logs) == 3);
    }

    @Test
    public void Test3(){
        int n = 2;
        int[][] logs = new int[][]{{0, 10}, {1, 20}};
        Assert.assertTrue(hardestWorker(n, logs) == 0);
    }

    @Test
    public void Test4(){
        int n = 70;
        int[][] logs = new int[][]{{36, 3}, {1, 5}, {12, 8}, {25, 9}, {53, 11}, {29, 12}, {52, 14}};
        Assert.assertTrue(hardestWorker(n, logs) == 12);
    }
}
