package other.courseSchedule;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 *
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 *
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 *
 */
public class Solution {
    /**
     * 使用拓扑排序的思想来判断是否能完成所有课程学习。我们首先构建课程图的邻接表，并记录每门课程的入度。
     * 然后，我们使用一个队列来存储入度为 0 的课程，并逐步移除这些课程，并更新依赖该课程的其他课程的入度。
     * 如果最终能够移除所有课程，则说明可以完成所有课程学习，返回 true；否则，返回 false。
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 构建课程图的邻接表
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        // 记录每门课程的入度
        int[] inDegree = new int[numCourses];

        // 构建邻接表和入度数组
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prerequisiteCourse = prerequisite[1];
            adjacencyList.get(prerequisiteCourse).add(course);
            inDegree[course]++;
        }

        // 使用队列存储入度为 0 的课程
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        // 逐步移除入度为 0 的课程，并更新相关课程的入度
        while (!queue.isEmpty()) {
            int course = queue.poll();
            numCourses--; // 完成一门课程

            // 更新依赖该课程的其他课程的入度
            for (int dependentCourse : adjacencyList.get(course)) {
                inDegree[dependentCourse]--;
                if (inDegree[dependentCourse] == 0) {
                    queue.offer(dependentCourse);
                }
            }
        }

        // 如果能完成所有课程学习，则 numCourses 最终为 0
        return numCourses == 0;
    }

    @Test
    public void Test1(){
        int numCourses = 4;
        int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
        boolean canFinish = canFinish(numCourses, prerequisites);
        Assert.assertTrue(canFinish);
    }
}
