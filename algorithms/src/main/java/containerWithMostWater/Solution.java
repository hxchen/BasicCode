package containerWithMostWater;

import org.junit.Test;

/**
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 * 说明：你不能倾斜容器。
 *
 * 示例1
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *
 * 示例2
 * 输入：height = [1,1]
 * 输出：1
 *
 */
public class Solution {

    /**
     * 左右双板，每次端板向内移动
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        // 初始最边的面积
        int maxArea = (j - i) * Math.min(height[i], height[j]);
        while (i < j){
            if (height[i] <= height[j]){
                i++;
            }else{
                j--;
            }
            maxArea = Math.max(maxArea, (j - i) * Math.min(height[i], height[j]));
        }
        return  maxArea;
    }

    @Test
    public void Test1(){
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

    @Test
    public void Test2(){
        int[] height = {1,1};
        System.out.println(maxArea(height));
    }

    @Test
    public void Test3(){
        int[] height = {2,3,4,5,18,17,6};
        System.out.println(maxArea(height));
    }

    @Test
    public void Test4(){
        int[] height = {166,63,82,92,144,186,192,68,101,179,50,170,141,31,149,131,180,94,168,142,91,137,159,184,89,135,101,21,70,191,136,37,7,18,81,103,4,26,171,106,5,173,28,99,4,129,30,185,23,198,127,67,88,39,51,129,126,104,150,196,48,38,185,7,56,19,110,12,45,33,70,50,7,98,149,163,179,131,100,3,82,180,70,170,171,73,51,97,130,153,45,130,191,31,137,199,2,199,11,47};
        System.out.println(maxArea(height));
    }

}
