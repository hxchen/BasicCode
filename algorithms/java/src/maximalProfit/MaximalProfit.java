package maximalProfit;

import org.junit.Assert;
import org.junit.Test;

/**
 * 股票的最大利润
 * 题目：假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖交易该股
 * 票可能获得的利润是多少？例如一只股票在某些时间节点的价格为{9, 11, 8, 5,
 * 7, 12, 16, 14}。如果我们能在价格为5的时候买入并在价格为16时卖出，则能
 * 收获最大的利润11。
 * Created by hxchen on 2018/9/9.
 */
public class MaximalProfit {

    public static int maxProfit(int[] numbers){
        if (numbers == null || numbers.length < 2)
            return 0;
        int min = numbers[0];
        int maxDiff = numbers[1] - min;
        for (int i = 2; i < numbers.length; i++){
            if (numbers[i-1] < min)
                min = numbers[i-1];

            int currentDiff = numbers[i] - min;
            if (currentDiff > maxDiff)
                maxDiff = currentDiff;
        }
        return maxDiff;
    }

    @Test
    public void Test1(){
        int numbers[] = { 4, 1, 3, 2, 5 };
        Assert.assertTrue(maxProfit(numbers) == 4);
    }
    @Test
    public void Test2(){
        int numbers[] = { 1, 2, 4, 7, 11, 16 };
        Assert.assertTrue(maxProfit(numbers) == 15);
    }
    @Test
    public void Test3(){
        int numbers[] = { 16, 11, 7, 4, 2, 1 };
        Assert.assertTrue(maxProfit(numbers) == -1);
    }
    @Test
    public void Test4(){
        int numbers[] = { 16, 16, 16, 16, 16 };
        Assert.assertTrue(maxProfit(numbers) == 0);
    }
    @Test
    public void Test5(){
        int numbers[] = { 9, 11, 5, 7, 16, 1, 4, 2 };
        Assert.assertTrue(maxProfit(numbers) == 11);
    }
    @Test
    public void Test6(){
        int numbers[] = { 2, 4 };
        Assert.assertTrue(maxProfit(numbers) == 2);
    }
    @Test
    public void Test7(){
        int numbers[] = { 4, 2 };
        Assert.assertTrue(maxProfit(numbers) == -2);
    }
    @Test
    public void Test8(){
        Assert.assertTrue(maxProfit(null) == 0);
    }


}
