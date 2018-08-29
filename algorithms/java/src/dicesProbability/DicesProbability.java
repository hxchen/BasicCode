package dicesProbability;

import org.junit.Test;

import java.text.DecimalFormat;

/**
 * n个骰子的点数
 * 题目：把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s
 * 的所有可能的值出现的概率。
 * Created by hxchen on 2018/8/29.
 */
public class DicesProbability {

    // 骰子最大点数
    static int g_maxValue = 6;

    /*
     * 方法一：基于递归实现
     * 缺点：时间复杂度过高
     */
    public static void printProbability_1(int number) {
        long start = System.currentTimeMillis();
        if (number < 1)
            return;
        int maxSum = number * g_maxValue;
        // probabilities 数组用来存储每个sum出现的次数，范围是从number到maxSum
        int[] probabilities = new int[maxSum - number + 1];
        // 数组初始化
        for (int i = 0; i < maxSum - number + 1; i++) {
            probabilities[i] = 0;
        }

        probability(number, probabilities);
        double total = Math.pow((double) g_maxValue, (double) number);
        // 打印出从number到maxSum每个数字出现的概率
        DecimalFormat df = new DecimalFormat("0.000");
        System.out.print("递归实现：");
        for (int i = 0; i < maxSum - number + 1; i++) {
            System.out.print(df.format(probabilities[i] / total) + " ");
        }
        System.out.println();
        long end = System.currentTimeMillis();
        long result = end - start;
        System.out.println("运行时间：" + result);

    }

    private static void probability(int number, int[] probabilities) {
        for (int i = 1; i <= g_maxValue; i++)
            probability(number, number - 1, i, probabilities);

    }

    // current 表示当前处理的是第几个骰子
    private static void probability(int number, int current, int sum, int[] probabilities) {
        // 当current == 1，说明所有的骰子处理结束，递归结束
        if (current == 0) {
            probabilities[sum - number]++;
            return;
        }
        for (int i = 1; i <= g_maxValue; i++) {
            probability(number, current - 1, sum + i, probabilities);
        }
    }

    /*
     * 方法2：循环实现 f(n)=f(n-1)+f(n-2)+f(n-3)+f(n-4)+f(n-5)+f(n-6) 时间复杂度低
     */
    public static void printProbability_2(int number) {
        long start = System.currentTimeMillis();
        if (number < 1)
            return;
        int maxSum = number * g_maxValue;
        int[][] probabilities = new int[2][maxSum + 1];
        // 通过falg来循环利用数组
        int flag = 0;
        // 初始化第一个骰子
        for (int i = 1; i <= g_maxValue; i++) {
            probabilities[flag][i] = 1;
        }
        // 第二个骰子到第n个骰子
        for (int k = 2; k <= number; k++) {
            flag = 1 - flag;
            // 当骰子数为k，那么sum的范围为k到k*g_maxValue
            for (int i = 1; i < k; i++) {
                probabilities[flag][i] = 0;
            }
            //k个骰子的最小和为k，k之前的数设为0；
            for (int i = k; i <= g_maxValue * k; i++) {
                int count = 1;
                //要把f(n)先设为0再进行计算
                probabilities[flag][i] = 0;
                while (i - count > 0 && count <= 6) {
                    probabilities[flag][i] += probabilities[1 - flag][i - count];
                    count++;
                }
            }
        }
        System.out.print("循环实现：");
        double total = Math.pow((double) g_maxValue, (double) number);
        // 打印出从number到maxSum每个数字出现的概率
        DecimalFormat df = new DecimalFormat("0.000");
        for (int i = number; i <= maxSum; i++) {
            System.out.print(df.format(probabilities[flag][i] / total) + " ");
        }
        System.out.println();
        long end = System.currentTimeMillis();
        long result = end - start;
        System.out.println("运行时间：" + result);
    }

    @Test
    public void Test1(){
//        printProbability_1(1);
        printProbability_1(2);
//        printProbability_1(3);
//        printProbability_1(4);
//        printProbability_1(11);
//        printProbability_2(11);

    }

}
