package continuousSequenceWithSum;

import org.junit.Test;

/**
 * 为s的连续正数序列
 * 题目：输入一个正数s，打印出所有和为s的连续正数序列（至少含有两个数）。
 * 例如输入15，由于1+2+3+4+5=4+5+6=7+8=15，所以结果打印出3个连续序列1～5、
 * 4～6和7～8。
 * Created by hxchen on 2018/8/21.
 */
public class ContinuousSequenceWithSum {

    public static void findContinuousSquenceWithSum(int sum){
        if (sum < 3)
            return;
        int small = 1;
        int big = 2;
        int total = 3;
        while (small < big){
            if (total == sum){
                printContinuousSquence(small, big);
                big++;
                total += big;
            }


            if (total < sum){
                big++;
                total += big;
            }

            if (total > sum){
                total-= small;
                small++;
            }
        }
    }

    public static void printContinuousSquence(int small, int big){
        for (int i = small; i <= big; i++){
            System.out.print("\t" + i);
        }
        System.out.println();
    }

    @Test
    public void Test1(){
        findContinuousSquenceWithSum(1);
    }
    @Test
    public void Test2(){
        findContinuousSquenceWithSum(3);
    }
    @Test
    public void Test3(){
        findContinuousSquenceWithSum(4);
    }
    @Test
    public void Test4(){
        findContinuousSquenceWithSum(9);
    }
    @Test
    public void Test5(){
        findContinuousSquenceWithSum(15);
    }
    @Test
    public void Test6(){
        findContinuousSquenceWithSum(100);
    }
}
