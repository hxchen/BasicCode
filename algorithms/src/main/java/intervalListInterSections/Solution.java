package intervalListInterSections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定两个由一些 闭区间 组成的列表，firstList 和 secondList ，其中 firstList[i] = [starti, endi] 而 secondList[j] = [startj, endj] 。每个区间列表都是成对 不相交 的，并且 已经排序 。
 *
 * 返回这 两个区间列表的交集 。
 *
 * 形式上，闭区间 [a, b]（其中 a <= b）表示实数 x 的集合，而 a <= x <= b 。
 *
 * 两个闭区间的 交集 是一组实数，要么为空集，要么为闭区间。例如，[1, 3] 和 [2, 4] 的交集为 [2, 3] 。
 *
 *
 */
public class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> result = new ArrayList<>();
        int i = 0, j = 0;
        while (i < firstList.length && j < secondList.length){
            int[] first = firstList[i];
            int[] second = secondList[j];
            int start = Math.max(first[0], second[0]);
            int end = Math.min(first[1], second[1]);
            if (start <= end){
                // 有交集先取交集后再舍弃一个较小的区间
                result.add(new int[]{start, end});
                if (first[1] < second[1]){
                    i++;
                }else{
                    j++;
                }
            }else{
                // 没有交集情况，舍弃一个出圈的
                if (first[0] > second[1]){
                    j++;
                } else if(second[0] > first[1]){
                    i++;
                }
            }
        }
        //  记住该函数使用可以返回二维数组
        return result.toArray(new int[result.size()][]);
    }

    @Test
    public void Test1(){
        int[][] firstList = {{0,2},{5,10},{13,23},{24,25}};
        int[][] secondList = {{1,5},{8,12},{15,24},{25,26}};
        int[][] result = intervalIntersection(firstList, secondList);
        for (int i = 0; i < result.length; i++){
            System.out.println(Arrays.toString(result[i]));
        }
    }

    @Test
    public void Test2(){
        int[][] firstList = {{1,3},{5,9},{13,23},{24,25}};
        int[][] secondList = {};
        int[][] result = intervalIntersection(firstList, secondList);
        for (int i = 0; i < result.length; i++){
            System.out.println(Arrays.toString(result[i]));
        }
    }

    @Test
    public void Test3(){
        int[][] firstList = {};
        int[][] secondList = {{1,3},{5,9},{13,23},{24,25}};
        int[][] result = intervalIntersection(firstList, secondList);
        for (int i = 0; i < result.length; i++){
            System.out.println(Arrays.toString(result[i]));
        }
    }

    @Test
    public void Test4(){
        int[][] firstList = {{1,7}};
        int[][] secondList = {{3,10}};
        int[][] result = intervalIntersection(firstList, secondList);
        for (int i = 0; i < result.length; i++){
            System.out.println(Arrays.toString(result[i]));
        }
    }

}
