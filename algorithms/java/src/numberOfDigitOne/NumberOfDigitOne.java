package numberOfDigitOne;

import org.junit.Assert;
import org.junit.Test;

/**
 * 1到整数N中1出现的次数(包含N)
 * Created by hxchen on 2018/7/18.
 */
public class NumberOfDigitOne {

    public static int NumberOfDigitOne(int n){
        if (n < 1)
            return 0;

        int count = 0;
        int base = 1;
        int round = n;

        while (round > 0){
            int weight = round % 10;
            round = round/10;

            count += round*base;
            if(weight == 1)
                count += (n % base) + 1;
            else if(weight>1)
                count += base;

            base *= 10;
        }
        return count;
    }

    @Test
    public void Test1(){
        int number = 0;
        int count = NumberOfDigitOne(number);
        Assert.assertTrue(count == 0);
    }
    @Test
    public void Test2(){
        int number = 1;
        int count = NumberOfDigitOne(number);
        Assert.assertTrue(count == 1);
    }
    @Test
    public void Test3(){
        int number = 10;
        int count = NumberOfDigitOne(number);
        Assert.assertTrue(count == 2);
    }
    @Test
    public void Test11(){
        int number = 11;
        int count = NumberOfDigitOne(number);
        Assert.assertTrue(count == 4);
    }
    @Test
    public void Test4(){
        int number = 55;
        int count = NumberOfDigitOne(number);
        Assert.assertTrue(count == 16);
    }
    @Test
    public void Test5(){
        int number = 99;
        int count = NumberOfDigitOne(number);
        Assert.assertTrue(count == 20);
    }
    @Test
    public void Test6(){
        int number = 10000;
        int count = NumberOfDigitOne(number);
        Assert.assertTrue(count == 4001);
    }
    @Test
    public void Test7(){
        int number = 21345;
        int count = NumberOfDigitOne(number);
        Assert.assertTrue(count == 18821);
    }
    @Test
    public void Test534(){
        int number = 534;
        int count = NumberOfDigitOne(number);
        Assert.assertTrue(count == 214);
    }
}
