package arrayString.sortThePeople;

import org.junit.Test;

import java.util.Arrays;

/**
 * 给你一个字符串数组 names ，和一个由 互不相同 的正整数组成的数组 heights 。两个数组的长度均为 n 。
 *
 * 对于每个下标 i，names[i] 和 heights[i] 表示第 i 个人的名字和身高。
 *
 * 请按身高 降序 顺序返回对应的名字数组 names 。
 *
 *
 * 示例 1：
 * 输入：names = ["Mary","John","Emma"], heights = [180,165,170]
 * 输出：["Mary","Emma","John"]
 * 解释：Mary 最高，接着是 Emma 和 John 。
 *
 * 示例 2：
 * 输入：names = ["Alice","Bob","Bob"], heights = [155,185,150]
 * 输出：["Bob","Alice","Bob"]
 * 解释：第一个 Bob 最高，然后是 Alice 和第二个 Bob 。
 *
 * @see <a href="https://leetcode.cn/problems/sort-the-people">LeetCode</a>
 */
public class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        quickSort(names, heights, 0, heights.length - 1);
        return names;
    }
    private void quickSort(String[] names, int[] heights, int start, int end){
        if (start >= end || names == null || heights == null || names.length == 1 || heights.length == 1){
            return;
        }
        int i = start, j = end, pivot = heights[start];
        while (i < j){
            while (i < j && heights[j] <= pivot){
                j--;
            }
            while (i < j && heights[i] >= pivot){
                i++;
            }
            // 左边选择一个比基准小的，右边选择一个比基准大的，交换
            if (i < j){
                swap(names, heights, i, j);
            }
        }
        swap(names, heights, start, i);
        quickSort(names, heights, start, i - 1);
        quickSort(names, heights, i + 1, end);
    }

    private void swap(String[] names, int[] heights, int i,int j){
        String tmpN  = names[i];
        names[i] = names[j];
        names[j] = tmpN;

        int tmpH = heights[i];
        heights[i] = heights[j];
        heights[j] = tmpH;
    }

    @Test
    public void Test1(){
        String[] names = new String[]{"Mary", "John", "Emma", "Peak"};
        int[] heights = new int[] {180,165,170,190};
        String[] namesS = sortPeople(names, heights);
        System.out.println(Arrays.toString(namesS));
        System.out.println(Arrays.toString(names));
        System.out.println(Arrays.toString(heights));
    }
}
