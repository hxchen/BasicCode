package byteDanceInNowCoder;

import java.util.Scanner;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/c0803540c94848baac03096745b55b9b?answerType=1&f=discussion
 * 来源：牛客网
 * <p>
 * 题目
 * 我叫王大锤，是一名特工。我刚刚接到任务：在字节跳动大街进行埋伏，抓捕***孔连顺。和我一起行动的还有另外两名特工，我提议
 * <p>
 * 我们在字节跳动大街的N个建筑中选定3个埋伏地点。
 * 为了相互照应，我们决定相距最远的两名特工间的距离不超过D。
 * 我特喵是个天才! 经过精密的计算，我们从X种可行的埋伏方案中选择了一种。这个方案万无一失，颤抖吧，孔连顺！
 * ……
 * <p>
 * 万万没想到，计划还是失败了，孔连顺化妆成小龙女，混在cosplay的队伍中逃出了字节跳动大街。只怪他的伪装太成功了，就是杨过本人来了也发现不了的！
 * 请听题：给定N（可选作为埋伏点的建筑物数）、D（相距最远的两名特工间的距离的最大值）以及可选建筑的坐标，计算在这次行动中，大锤的小队有多少种埋伏选择。
 * <p>
 * 注意：
 * <p>
 * 两个特工不能埋伏在同一地点
 * <p>
 * 三个特工是等价的：即同样的位置组合(A, B, C) 只算一种埋伏方法，不能因“特工之间互换位置”而重复使用
 * <p>
 * 题目来源：万万没想到之抓捕孔连顺
 * <p>
 * 输入描述
 * 第一行包含空格分隔的两个数字 N和D(1 ≤ N ≤ 1000000; 1 ≤ D ≤ 1000000)
 * <p>
 * 第二行包含N个建筑物的的位置，每个位置用一个整数（取值区间为[0, 1000000]）表示，从小到大排列（将字节跳动大街看做一条数轴）
 * <p>
 * 输出描述
 * 一个数字，表示不同埋伏方案的数量。结果可能溢出，请对 99997867 取模
 * <p>
 * 示例1
 * 输入
 * 4 3
 * 1 2 3 4
 * ```
 * 输出
 * 1
 * 4
 * 说明
 * 1
 * 可选方案(1,2,3),(1,2,4),(1,3,4),(2,3,4)
 * 示例2
 * 输入
 * 1
 * 2
 * 5 19
 * 1 10 20 30 50
 * 输出
 * 1
 * 1
 * 说明
 * 复制代码
 * 1
 * 可选方案(1，10，20)
 *
 * @author haixiangchen
 */
public class CatchKong {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int d = sc.nextInt();
            int[] position = new int[n];
            sc.nextLine();
            for (int i = 0; i < n; i++) {
                position[i] = sc.nextInt();
            }
            run(n, d, position);
        }
    }

    private static void run(int n, int d, int[] position) {
        long sum = 0L;
        long mod = 99997867;
        for (int i = 2, j = 0; i < n; i++) {
            //从第三个开始判断，判断是否违法，如果违法j++
            while (position[i] - position[j] > d) {
                j++;
            }
            //计算合法的次数,n(n-i)/2
            sum += (long) (i - j) * (long) (i - j - 1) / 2;
        }
        System.out.println(sum % mod);
    }
}
