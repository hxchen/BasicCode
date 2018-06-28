package stackPushPopOrder;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 *
 * 栈的压入、弹出序列
 * 题目：输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是
 * 否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1、2、3、4、
 * 5是某栈的压栈序列，序列4、5、3、2、1是该压栈序列对应的一个弹出序列，但
 * 4、3、5、1、2就不可能是该压栈序列的弹出序列。
 * Created by hxchen on 2018/6/28.
 */
public class StackPushPopOrder {

    public boolean isPopOrder(int[] pushOrder, int[] popOrder){
        if (pushOrder == null || popOrder == null){
            return false;
        }
        if (pushOrder.length != popOrder.length){
            return false;
        }

        boolean isOrder = false;
        int pos = 0;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < pushOrder.length; i++){
            stack.push(pushOrder[i]);
            for(int j = pos; j < popOrder.length; j++){
                if (stack.size() != 0 && popOrder[j] == stack.peek()){
                    stack.pop();
                    ++pos;
                }else {
                    break;
                }
            }
        }
        if ((pos == pushOrder.length) && stack.size() == 0)
            isOrder = true;
        return isOrder;
    }

    /**
     * 正确性验证
     */
    @Test
    public void test1(){
        int[] pushOrder = {1,2,3,4,5};
        int[] popOrder = {4,5,3,2,1};
        boolean isOrder = isPopOrder(pushOrder, popOrder);
        Assert.assertTrue(isOrder);
    }
    /**
     * 正确性验证
     */
    @Test
    public void test2(){
        int[] pushOrder = {1,2,3,4,5};
        int[] popOrder = {3,5,4,2,1};
        boolean isOrder = isPopOrder(pushOrder, popOrder);
        Assert.assertTrue(isOrder);
    }

    /**
     * 错误性验证
     */
    @Test
    public void test3(){
        int[] pushOrder = {1,2,3,4,5};
        int[] popOrder = {4,3,5,1,2};
        boolean isOrder = isPopOrder(pushOrder, popOrder);
        Assert.assertFalse(isOrder);
    }

    /**
     * 错误性验证
     */
    @Test
    public void test4(){
        int[] pushOrder = {1,2,3,4,5};
        int[] popOrder = {4,5,3,2};
        boolean isOrder = isPopOrder(pushOrder, popOrder);
        Assert.assertFalse(isOrder);
    }

    /**
     * 只有一个数,错误
     */
    @Test
    public void test5(){
        int[] pushOrder = {1};
        int[] popOrder = {2};
        boolean isOrder = isPopOrder(pushOrder, popOrder);
        Assert.assertFalse(isOrder);
    }
    /**
     * 只有一个数,正确
     */
    @Test
    public void test6(){
        int[] pushOrder = {1};
        int[] popOrder = {1};
        boolean isOrder = isPopOrder(pushOrder, popOrder);
        Assert.assertTrue(isOrder);
    }

    /**
     * 空值
     */
    @Test
    public void test7(){
        boolean isOrder = isPopOrder(null, null);
        Assert.assertFalse(isOrder);
    }

}
