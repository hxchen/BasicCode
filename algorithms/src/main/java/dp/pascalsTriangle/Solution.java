package dp.pascalsTriangle;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 *
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 */
public class Solution {
    /**
     * f(i)(j) = f(i-1)(j-1) + f(i-1)(j)
     * f(i)(0) = 1
     * f(i)(i-1) = 1
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < numRows; i++){
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++){
                if (j == 0 || j == i){
                    row.add(1);
                }else{
                    row.add(ret.get(i-1).get(j-1) + ret.get(i-1).get(j));
                }
            }
            ret.add(row);
        }
        return ret;
    }

    @Test
    public void Test1(){
        System.out.println(Arrays.toString(generate(5).toArray()));
    }
}
