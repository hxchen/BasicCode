package numbersAppearOnce;

import org.junit.Assert;
import org.junit.Test;

/**
 * 数组中唯一只出现一次的数字
 * 题目：在一个数组中除了一个数字只出现一次之外，其他数字都出现了三次。请
 * 找出那个吃出现一次的数字。
 * Created by hxchen on 2018/8/14.
 */
public class NumberAppearOnce {

    public static int findNumberAppearOnce(int[] numbers) throws Exception{
        if (numbers == null || numbers.length == 0)
            throw new Exception("Invalid input");
        // 辅助数组存储二进制表示的每一位的和,int 二进制位数：32
        int [] bitSum = new int[32];
        for (int i = 0; i < 32; i++)
            bitSum[i] = 0;

        for(int i = 0;i < numbers.length; ++i) {
            int bitMask=1;
            for(int j = 31; j >=0; --j){
                int bit = numbers[i] & bitMask;
                if(bit !=0)
                    bitSum[j] += 1;
                bitMask = bitMask << 1;
            }

        }
        int result = 0;
        for(int i = 0;i < 32; ++i){
            result = result << 1;
            result += bitSum[i]%3;
        }
        return result;
    }

    @Test
    public void Test1(){
        int numbers[] = { 1, 1, 2, 2, 2, 1, 3 };
        int expected = 3;
        try {
            Assert.assertEquals(expected, findNumberAppearOnce(numbers));
        }
        catch (Exception e){
            System.out.println("异常信息为："+e.getMessage());
        }

    }
    @Test
    public void Test2(){
        int numbers[] = { 4, 3, 3, 2, 2, 2, 3 };
        int expected = 4;
        try {
            Assert.assertEquals(expected, findNumberAppearOnce(numbers));
        }
        catch (Exception e){
            System.out.println("异常信息为："+e.getMessage());
        }

    }
    @Test
    public void Test3(){
        int numbers[] = { 4, 4, 1, 1, 1, 7, 4 };
        int expected = 7;
        try {
            Assert.assertEquals(expected, findNumberAppearOnce(numbers));
        }
        catch (Exception e){
            System.out.println("异常信息为："+e.getMessage());
        }

    }
    @Test
    public void Test4(){
        int numbers[] = { -10, 214, 214, 214 };
        int expected = -10;
        try {
            Assert.assertEquals(expected, findNumberAppearOnce(numbers));
        }
        catch (Exception e){
            System.out.println("异常信息为："+e.getMessage());
        }

    }
    @Test
    public void Test5(){
        int numbers[] = { -209, 3467, -209, -209 };
        int expected = 3467;
        try {
            Assert.assertEquals(expected, findNumberAppearOnce(numbers));
        }
        catch (Exception e){
            System.out.println("异常信息为："+e.getMessage());
        }

    }
    @Test
    public void Test6(){
        int numbers[] = { 1024, -1025, 1024, -1025, 1024, -1025, 1023 };
        int expected = 1023;
        try {
            Assert.assertEquals(expected, findNumberAppearOnce(numbers));
        }
        catch (Exception e){
            System.out.println("异常信息为："+e.getMessage());
        }

    }
    @Test
    public void Test7(){
        int numbers[] = { -1024, -1024, -1024, -1023 };
        int expected = -1023;
        try {
            Assert.assertEquals(expected, findNumberAppearOnce(numbers));
        }
        catch (Exception e){
            System.out.println("异常信息为："+e.getMessage());
        }

    }
    @Test
    public void Test8(){
        int numbers[] = { -23, 0, 214, -23, 214, -23, 214 };
        int expected = 0;
        try {
            Assert.assertEquals(expected, findNumberAppearOnce(numbers));
        }
        catch (Exception e){
            System.out.println("异常信息为："+e.getMessage());
        }

    }
    @Test
    public void Test9(){
        int numbers[] = { 0, 3467, 0, 0, 0, 0, 0, 0 };
        int expected = 3467;
        try {
            Assert.assertEquals(expected, findNumberAppearOnce(numbers));
        }
        catch (Exception e){
            System.out.println("异常信息为："+e.getMessage());
        }
    }

}
