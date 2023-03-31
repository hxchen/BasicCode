package bfsOrDfs.allPathsFromSourceToTarget;

import org.junit.Test;

import java.util.*;

/**
 * 给你一个有 n 个节点的 有向无环图（DAG），请你找出所有从节点 0 到节点 n-1 的路径并输出（不要求按特定顺序）
 *  graph[i] 是一个从节点 i 可以访问的所有节点的列表（即从节点 i 到节点 graph[i][j]存在一条有向边）。
 *
 * 示例1
 * 输入：graph = [[1,2],[3],[3],[]]
 * 输出：[[0,1,3],[0,2,3]]
 * 解释：有两条路径 0 -> 1 -> 3 和 0 -> 2 -> 3
 *
 * 示例2
 * 输入：graph = [[4,3,1],[3,2,4],[3],[4],[]]
 * 输出：[[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
 *
 */
public class Solution {
    /**
     * 深度优先搜索
     * @param graph
     * @return
     */
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<>();
        // 双端队列
        Deque<Integer> stack = new ArrayDeque<>();
        stack.offerLast(0);
        dfs(graph, 0, graph.length - 1, paths, stack);
        return paths;
    }

    /**
     * 深度遍历
     * @param graph
     * @param point 当前处理到的下标
     * @param end   目标下标
     * @param paths
     * @param stack
     */
    public void dfs(int[][] graph, int point, int end, List<List<Integer>> paths, Deque<Integer> stack){
        if (point == end){
            // 双端队列可以直接初始化ArrayList
            paths.add(new ArrayList<>(stack));
            return;
        }
        for (int i : graph[point]) {
            stack.offerLast(i);
            dfs(graph, i, end, paths, stack);
            stack.pollLast();
        }

    }

    @Test
    public void Test1(){
        int[][] graph = {
                {1,2},
                {3},
                {3},
                {}
        };
        System.out.println(allPathsSourceTarget(graph));
    }

    @Test
    public void Test2(){
        int[][] graph = {
                {4, 3, 1},
                {3, 2, 4},
                {3},
                {4},
                {}
        };
        System.out.println(allPathsSourceTarget(graph));
    }
}
