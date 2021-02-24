package fibonacci;

import org.junit.Test;

/**
 * 斐波那契数列
 * Created by hxchen on 2018/5/27.
 */
public class Fibonacci {

    /**
     * 递归解法,重复计算多,效率低,可能会存在栈溢出。
     *
     * @param n
     * @return
     */
    public static Long fibonacciRecursion(int n) {
        if (n <= 0) {
            return 0L;
        }
        if (n == 1) {
            return 1L;
        }
        return fibonacciRecursion(n - 1) + fibonacciRecursion(n - 2);
    }

    /**
     * 循环解法,从下往上计算,效率高。
     *
     * @param n
     * @return
     */
    public static Long fibonacciLoop(int n) {
        if (n <= 0) {
            return 0L;
        }
        if (n == 1) {
            return 1L;
        }

        Long value1 = 0L;
        Long value2 = 1L;
        Long result = 0L;
        for (int i = 2; i <= n; i++) {
            result = value1 + value2;
            value1 = value2;
            value2 = result;
        }
        return result;
    }

    @Test
    public void testFibonacci() {
        for (int i = 0; i < 10; i++) {
            Long value1 = fibonacciRecursion(i);
            Long value2 = fibonacciLoop(i);
            if (value1 == value2) {
                System.out.println("i = " + i + ",Passed");
            } else {
                System.out.println("i = " + i + ",Failed");
            }
        }
    }

}
