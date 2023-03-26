package other.happyNumber;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;

public class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        int next = n;
        while (!set.contains(next)){
            set.add(next);
            next = GetNextNumber(next);
            if (next == 1){
                return true;
            }
        }
        return false;
    }

    public int GetNextNumber(int n){
        int ret = 0;
        while (n >= 10){
            //注意条件判断 取等
            ret += Math.pow(n%10, 2);
            n = n/10;
        }
        return (int) (ret + Math.pow(n, 2));
    }

    @Test
    public void Test1(){
        Assert.assertTrue(isHappy(19));
    }
    @Test
    public void Test2(){
        Assert.assertTrue(!isHappy(2));
    }
}
