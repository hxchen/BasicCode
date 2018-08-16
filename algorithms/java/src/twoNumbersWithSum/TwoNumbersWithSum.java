package twoNumbersWithSum;

import org.junit.Test;

/**
 * 和为s的两个数字
 * 题目：输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们
 * 的和正好是s。如果有多对数字的和等于s，输出任意一对即可。
 * Created by hxchen on 2018/8/16.
 */
public class TwoNumbersWithSum {

    public static void findTwoNumbersWithSum(int[] numbers, int sum){
        if (numbers == null || numbers.length < 1)
            return;
        System.out.print("array is :");
        for (int i: numbers){
            System.out.print("\t"+i);
        }
        System.out.print(", sum is :"+sum);
        int first = 0, second = numbers.length - 1;
        while (first < second){

            if (numbers[first] + numbers[second] == sum){
                System.out.println("  result====find! first = "+numbers[first]+", second = "+numbers[second]);
                return;
            }
            if (numbers[first] + numbers[second] > sum){
                second--;
            }
            if (numbers[first] + numbers[second] < sum){
                first++;
            }
        }
        System.out.println("    result====not found!");
    }
    // 存在和为s的两个数字，这两个数字位于数组的中间
    @Test
    public void Test1(){
        int data[] = {1, 2, 4, 7, 11, 15};
        findTwoNumbersWithSum(data, 15);
    }
    // 存在和为s的两个数字，这两个数字位于数组的两段
    @Test
    public void Test2(){
        int data[] = {1, 2, 4, 7, 11, 16};
        findTwoNumbersWithSum(data, 17);
    }
    // 鲁棒性测试
    @Test
    public void Test3(){
        int data[] = {1, 2, 4, 7, 11, 16};
        findTwoNumbersWithSum(data, 10);
    }
    // 鲁棒性测试
    @Test
    public void Test4(){
        findTwoNumbersWithSum(null, 0);
    }

    @Test
    public void Test5(){
        int data[] = {1, 2, 4, 7, 11, 16};
        findTwoNumbersWithSum(data, 3);
    }@Test
    public void Test6(){
        int data[] = {1, 2, 4, 7, 11, 16};
        findTwoNumbersWithSum(data, 5);
    }
    @Test
    public void Test7(){
        int data[] = {1, 2, 4, 7, 11, 16};
        findTwoNumbersWithSum(data, 8);
    }
    @Test
    public void Test8(){
        int data[] = {1, 2, 4, 7, 11, 16};
        findTwoNumbersWithSum(data, 12);
    }


}
