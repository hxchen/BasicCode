package cuttingRope;

import org.testng.annotations.Test;

/**
 * 剪绳子
 * 题目：给你一根长度为n绳子，请把绳子剪成m段（m、n都是整数，n>1并且m≥1）。
 * 每段的绳子的长度记为k[0]、k[1]、……、k[m]。k[0]*k[1]*…*k[m]可能的最大乘
 * 积是多少？例如当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此
 * 时得到最大的乘积18。
 * Created by hxchen on 2018/5/30.
 */
public class CuttingRope {
    /**
     * 利用动态规划求解
     */
    public static int maxProductAfterCutting_DP(int length){
        if(length < 2)
            return 0;
        if(length == 2)
            return 1;
        if(length == 3)
            return 2;
        //注意:数组大小是+1。长度为9的最大乘积在 products[9]
        int[] products = new int[length+1];
        //products列表，放的是绳子长度最优的情况
        //当length > 3时，不要对3进行剪开，因为无论怎么剪，都小于3本身
        //而大于3的绳子，剪开可能比本身大，或至少等于本身，3是一个底线
        //为什么要定义products[1] = 1和products[2] = 2 products[3] = 3
        //因为：不可能绳子长度都是三的倍数，一定会需要1和2来保证相加起来等于绳子的长度。
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;

        int max = 0;
        for(int i = 4; i <= length; ++i) {
            max = 0;
            for(int j = 1; j <= i / 2; ++j) {
                int product = products[j] * products[i - j];
                if(max < product)
                    max = product;

                products[i] = max;
            }
        }

        max = products[length];
        return max;
    }

    /**
     * 贪婪算法
     * @return
     */
    public static int maxProductAfterCutting_Greedy(int length){
        if(length < 2)
            return 0;
        if(length == 2)
            return 1;
        if(length == 3)
            return 2;

        // 尽可能多地减去长度为3的绳子段
        int timesOf3 = length / 3;

        // 当绳子最后剩下的长度为4的时候，不能再剪去长度为3的绳子段。
        // 此时更好的方法是把绳子剪成长度为2的两段，因为2*2 > 3*1。
        if(length - timesOf3 * 3 == 1)
            timesOf3 -= 1;

        int timesOf2 = (length - timesOf3 * 3) / 2;

        return (int) (Math.pow(3, timesOf3)) * (int) (Math.pow(2, timesOf2));
    }
    // ====================测试代码====================
    public static void test(String testName, int length, int expected){
        int result1 = maxProductAfterCutting_DP(length);
        if(result1 == expected)
            System.out.println("DP for " + testName + " passed." );
        else
            System.out.println("DP for " + testName + " FAILED." );

        int result2 = maxProductAfterCutting_Greedy(length);
        if(result2 == expected)
            System.out.println("Greedy for " + testName + " passed." );
        else
            System.out.println("Greedy for " + testName + " FAILED." );
    }
    public static void test1() {
        int length = 1;
        int expected = 0;
        test("test1", length, expected);
    }

    public static void test2() {
        int length = 2;
        int expected = 1;
        test("test2", length, expected);
    }

    public static void test3() {
        int length = 3;
        int expected = 2;
        test("test3", length, expected);
    }

    public static void test4() {
        int length = 4;
        int expected = 4;
        test("test4", length, expected);
    }

    public static void test5() {
        int length = 5;
        int expected = 6;
        test("test5", length, expected);
    }

    public static void test6() {
        int length = 6;
        int expected = 9;
        test("test6", length, expected);
    }

    public static void test7() {
        int length = 7;
        int expected = 12;
        test("test7", length, expected);
    }

    public static void test8() {
        int length = 8;
        int expected = 18;
        test("test8", length, expected);
    }

    public static void test9() {
        int length = 9;
        int expected = 27;
        test("test9", length, expected);
    }

    public static void test10() {
        int length = 10;
        int expected = 36;
        test("test10", length, expected);
    }

    public static void test11() {
        int length = 50;
        int expected = 86093442;
        test("test11", length, expected);
    }
    @Test
    public void startTest(){
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
        test8();
        test9();
        test10();
        test11();

    }
}
