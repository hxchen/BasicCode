package math;

import org.junit.Assert;
import org.testng.annotations.Test;

/**数值的整数次方
 * 题目：实现函数double Power(double base, int exponent)，求base的exponent
 * 次方。不得使用库函数，同时不需要考虑大数问题。
 * Created by hxchen on 2018/6/3.
 */
public class JMath {

    public static double power(double base, int exponent){

        double result = 1d;

        if(base == 0 ){
            // 0的正数幂都等于0;负数幂没有定义,但是我们可以在此定义成0
            return 0;
        }else{
            if(exponent == 0){
                return result;
            }else if (exponent < 0){
                for (int i = 0; i < -exponent; i++){
                    result = base * result;
                }
                result =  1/result;
            }else if(exponent > 0){
                for (int i = 0; i < exponent; i++){
                    result = base * result;
                }
            }
            return result;
        }

    }

    @Test
    public void test1(){
        Assert.assertEquals(power(0,1),0d,0.000001);
    }
    @Test
    public void test2(){
        Assert.assertEquals(power(0,-1),0d,0.000001);
    }
    @Test
    public void test3(){
        Assert.assertEquals(power(0,0),0d,0.000001);
    }
    @Test
    public void test4(){
        Assert.assertEquals(power(2,3),8d,0.000001);
    }
    @Test
    public void test5(){
        Assert.assertEquals(power(2,-3),0.125,0.000001);
    }
    @Test
    public void test6(){
        Assert.assertEquals(power(-2,3),-8,0.000001);
    }
    @Test
    public void test7(){
        Assert.assertEquals(power(-2,-3),-0.125,0.000001);
    }
}
