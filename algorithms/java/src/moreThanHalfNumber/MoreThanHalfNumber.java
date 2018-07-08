package moreThanHalfNumber;

import org.junit.Assert;
import org.junit.Test;

/**
 * 数组中出现次数超过一半的数字
 * 题目：数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例
 * 如输入一个长度为9的数组{1, 2, 3, 2, 2, 2, 5, 4, 2}。由于数字2在数组中
 * 出现了5次，超过数组长度的一半，因此输出2。
 * Created by hxchen on 2018/7/8.
 */
public class MoreThanHalfNumber {

    /**
     *  检查这个数字出现次数是否超过一半
     * @param numbers
     * @return
     */
    private boolean checkMoreThanHalf(int[] numbers, int number){
        int times = 0;
        for (int i = 0; i < numbers.length; i++){
            if (numbers[i] == number)
                times++;
        }
        if (times*2 > numbers.length)
            return true;
        return false;
    }

    public int moreThanHalfNumber(int[] numbers){
        if (null == numbers)
            return 0;
        int result = numbers[0];
        int times = 1;
        for (int i = 1; i < numbers.length; i++){
            if (times == 0){
                result = numbers[i];
                times = 1;
            }else if (result == numbers[i]){
                times++;
            }else {
                times--;
            }
        }
        if (checkMoreThanHalf(numbers, result)){
            return result;
        }else {
            return 0;
        }
    }
    // 存在出现次数超过数组长度一半的数字
    @Test
    public void Test1() {
        int numbers[] = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        Assert.assertTrue(moreThanHalfNumber(numbers) == 2);
    }

    // 不存在出现次数超过数组长度一半的数字
    @Test
    public void Test2() {
        int numbers[] = {1, 2, 3, 2, 4, 2, 5, 2, 3};
        int result = moreThanHalfNumber(numbers);
        Assert.assertTrue(result == 0);
    }

    // 出现次数超过数组长度一半的数字都出现在数组的前半部分
    @Test
    public void Test3() {
        int numbers[] = {2, 2, 2, 2, 2, 1, 3, 4, 5};
        Assert.assertTrue(moreThanHalfNumber(numbers) == 2);
    }

    // 出现次数超过数组长度一半的数字都出现在数组的后半部分
    @Test
    public void Test4() {
        int numbers[] = {1, 3, 4, 5, 2, 2, 2, 2, 2};
        Assert.assertTrue(moreThanHalfNumber(numbers) == 2);
    }

    // 输入单一数字
    @Test
    public void Test5() {
        int numbers[] = {1};
        Assert.assertTrue(moreThanHalfNumber(numbers) == 1);
    }

    // 输入空指针
    @Test
    public void Test6() {
        Assert.assertTrue(moreThanHalfNumber(null) == 0);
    }
}
