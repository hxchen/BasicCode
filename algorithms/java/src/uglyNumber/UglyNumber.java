package uglyNumber;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * 丑数
 * 题目：我们把只包含因子2、3和5的数称作丑数（Ugly Number）。求按从小到
 * 大的顺序的第1500个丑数。例如6、8都是丑数，但14不是，因为它包含因子7。
 * 习惯上我们把1当做第一个丑数。
 * Created by hxchen on 2018/7/31.
 */
public class UglyNumber {

    public static boolean isUglyNumber(int number){
        while (number % 2 == 0)
            number /= 2;
        while (number % 3 == 0)
            number /= 3;
        while (number % 5 == 0)
            number /= 5;

        return number == 1;
    }

    /**
     * 输入index,返回第index个丑数
     * @param index
     * @return
     */
    public int getUglyNumber(int index){
        long start = System.currentTimeMillis();
        if (index <= 0 )
            return 0;
        ArrayList<Integer> array = new ArrayList<>();
        int number = 0;
        int uglyFound = 0;
        while (uglyFound < index){
            number ++;
            if (isUglyNumber(number)){
                uglyFound++;
                array.add(number);
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("getUglyNumber1 costs "+ (end-start));
        return number;
    }

    /**
     * 返回 a b c最小的数
     * @param a
     * @param b
     * @param c
     * @return
     */
    public int minNumber(int a, int b, int c){
        int min = a < b ? a : b;
        return min < c ? min : c;
    }

    /**
     * 输入index
     * @param index
     * @return 返回第index 个丑数
     */
    public int getUglyNumber2(int index){
        long start = System.currentTimeMillis();
        if (index <= 0)
            return 0;

        int[] uglyArray = new int[index];
        uglyArray[0] = 1;

        int nextUglyIndex = 1;

        int multiply2 = 0;
        int multiply3 = 0;
        int multiply5 = 0;

        while (nextUglyIndex < index){
            int min = minNumber(uglyArray[multiply2] * 2, uglyArray[multiply3] * 3, uglyArray[multiply5] * 5);
            uglyArray[nextUglyIndex] = min;

            while (uglyArray[multiply2] * 2 <= min){
               multiply2++;
            }
            while (uglyArray[multiply3] * 3 <= min){
                multiply3++;
            }
            while (uglyArray[multiply5] * 5 <= min){
                multiply5++;
            }
            nextUglyIndex++;
        }
        long end = System.currentTimeMillis();
        System.out.println("getUglyNumber2 costs "+ (end-start));
        return uglyArray[index-1];
    }
    @Test
    public void Test1(){
        int uglyNumber = getUglyNumber(1500);
        int uglyNumber2 = getUglyNumber2(1500);
        System.out.println(uglyNumber+","+uglyNumber2);
        Assert.assertTrue(uglyNumber == uglyNumber2);
    }
}
