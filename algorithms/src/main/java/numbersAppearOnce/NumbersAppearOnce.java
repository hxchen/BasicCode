package numbersAppearOnce;

import org.junit.Test;

/**
 * 数组中只出现一次的两个数字
 * 题目：一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序
 * 找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 * Created by hxchen on 2018/8/13.
 */
public class NumbersAppearOnce {

    /**
     * 利用异或进行分类查找
     *
     * @param numbers
     */
    public void findNumbersAppearOnce(int[] numbers) {
        if (numbers == null)
            return;
        int number = 0;
        for (int i : numbers) {
            number ^= i;
        }

        int index = findFirstBitIsOne(number);
        int number1 = 0, number2 = 0;
        System.out.print("输入的原始数据是:");
        for (int i : numbers) {
            System.out.print("\t" + i);
            if (isBitOne(i, index))
                number1 ^= i;
            else
                number2 ^= i;
        }
        System.out.print("\n" + "只出现一次的两个数字是:");
        System.out.print("\t" + number1);
        System.out.print("\t" + number2);
    }

    /**
     * 找到数组 number 的二进制表示中最右边是1的位
     *
     * @param number
     * @return
     */
    private int findFirstBitIsOne(int number) {
        int indexBit = 0;
        while ((number & 1) == 0) {
            number = number >> 1;
            indexBit++;
        }
        return indexBit;
    }

    /**
     * 判断数字 number 的右边第 indexBit 位是不是 1
     *
     * @param number
     * @param indexBit
     * @return
     */
    private boolean isBitOne(int number, int indexBit) {
        number = number >> indexBit;
        return (number & 1) == 1 ? true : false;
    }

    @Test
    public void Test1() {
        int data[] = {2, 4, 3, 6, 3, 2, 5, 5};
        findNumbersAppearOnce(data);
    }

    @Test
    public void Test2() {
        int data[] = {4, 6};
        findNumbersAppearOnce(data);
    }

    @Test
    public void Test3() {
        int data[] = {4, 6, 1, 1, 1, 1};
        findNumbersAppearOnce(data);
    }
}
