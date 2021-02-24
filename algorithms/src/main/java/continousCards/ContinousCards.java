package continousCards;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * 扑克牌的顺子
 * 题目：从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王可以看成任意数字。
 * Created by hxchen on 2018/9/3.
 */
public class ContinousCards {

    /**
     * Step-1、数组排序
     * Step-2、统计数组0的个数
     * Step-3、统计排序后数组相邻数字之间空缺总数
     * Step-4、空缺总数小于等于0的个数,那么数组是连续的,反之不连续。
     * Step-5、存在对子,不连续。
     *
     * @param numbers
     * @return
     */
    public boolean isContinous(int[] numbers) {
        if (numbers == null || numbers.length != 5) {
            return false;
        }
        Arrays.sort(numbers);
        int numberOfZero = 0;
        int dis = 0;
        for (int i = 0; i < numbers.length && numbers[i] == 0; i++) {
            numberOfZero++;
        }
        // 第一个非0元素的位置
        int small = numberOfZero;
        int big = small + 1;
        while (big < numbers.length) {
            if (numbers[small] == numbers[big]) {
                return false;
            }
            dis += (numbers[big] - numbers[small] - 1);
            small = big;
            big++;
        }
        return dis <= numberOfZero;
    }

    @Test
    public void Test1() {
        int[] numbers = {1, 3, 2, 5, 4};
        boolean result = isContinous(numbers);
        boolean expected = true;
        Assert.assertTrue(result == expected);
    }

    @Test
    public void Test2() {
        int numbers[] = {1, 3, 2, 6, 4};
        boolean result = isContinous(numbers);
        boolean expected = false;
        Assert.assertTrue(result == expected);
    }

    @Test
    public void Test3() {
        int numbers[] = {0, 3, 2, 6, 4};
        boolean result = isContinous(numbers);
        boolean expected = true;
        Assert.assertTrue(result == expected);
    }

    @Test
    public void Test4() {
        int numbers[] = {0, 3, 1, 6, 4};
        boolean result = isContinous(numbers);
        boolean expected = false;
        Assert.assertTrue(result == expected);
    }

    @Test
    public void Test5() {
        int numbers[] = {1, 3, 0, 5, 0};
        boolean result = isContinous(numbers);
        boolean expected = true;
        Assert.assertTrue(result == expected);
    }

    @Test
    public void Test6() {
        int numbers[] = {1, 3, 0, 7, 0};
        boolean result = isContinous(numbers);
        boolean expected = false;
        Assert.assertTrue(result == expected);
    }

    @Test
    public void Test7() {
        int numbers[] = {1, 0, 0, 5, 0};
        boolean result = isContinous(numbers);
        boolean expected = true;
        Assert.assertTrue(result == expected);
    }

    @Test
    public void Test8() {
        int numbers[] = {1, 0, 0, 7, 0};
        boolean result = isContinous(numbers);
        boolean expected = false;
        Assert.assertTrue(result == expected);
    }

    @Test
    public void Test9() {
        int numbers[] = {3, 0, 0, 0, 0};
        boolean result = isContinous(numbers);
        boolean expected = true;
        Assert.assertTrue(result == expected);
    }

    @Test
    public void Test10() {
        int numbers[] = {0, 0, 0, 0, 0};
        boolean result = isContinous(numbers);
        boolean expected = true;
        Assert.assertTrue(result == expected);
    }

    @Test
    public void Test11() {
        int numbers[] = {1, 0, 0, 1, 0};
        boolean result = isContinous(numbers);
        boolean expected = false;
        Assert.assertTrue(result == expected);
    }

    @Test
    public void Test12() {
        boolean result = isContinous(null);
        boolean expected = false;
        Assert.assertTrue(result == expected);
    }

}
