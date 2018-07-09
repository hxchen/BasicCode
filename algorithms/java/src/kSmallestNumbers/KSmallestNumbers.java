package kSmallestNumbers;

import org.junit.Test;

import java.util.Arrays;

/**
 * 最小的k个数
 * 输入n个整数，找出其中最小的k个数。例如输入4、5、1、6、2、7、3、8
 * 这8个数字，则最小的4个数字是1、2、3、4。
 * Created by hxchen on 2018/7/9.
 */
public class KSmallestNumbers {


    /**
     * 基于partition,会调整数组内数字的顺序。
     * @param input
     * @param k
     * @return
     */
    public int[] getSmallestNumbers(int[] input,int k){
        if(null == input || input.length == 0 || k<= 0 || k > input.length)
            return new int[0];
        int[] output = new int[k];
        int start = 0;
        int end = input.length-1;
        int index = partition(input,start,end);
        while(index != k-1){
            if(index > k-1){
                end = index -1;
                index = partition(input,start ,end);
            }
            else{
                start = index+1;
                index = partition(input,start ,end);
            }
        }
        for(int i = 0;i<k;i++){
            output[i] = input[i];
        }
        return output;
    }

    private int partition(int[] arr, int left, int right) {
        int result = arr[left];
        if (left > right)
            return -1;

        while (left < right) {
            while (left < right && arr[right] >= result) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] < result) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = result;
        return left;
    }
    /**
     * 适合海量数据的输入
     * 维护一个大小为k的容器。
     * 每次从输入整数读取一个数，如果容器中的数字少于k个，则直接加入，否则，找出容器中的最大值，与当前数字比较，若大于最大值，则不管，若小于，则替换最大值。
     * 时间复杂度O(n*log*k)
     * @param arr
     * @param k
     */
    public static int[] kSmallestNumbers(int[] arr,int k){
        if(arr == null || k<0 || k>arr.length)
            return new int[0];
        //根据输入数组前k个数简历最大堆
        //从k+1个数开始与根节点比较
        //大于根节点，舍去
        //小于，取代根节点，重建最大堆
        int[] kArray = Arrays.copyOfRange(arr, 0, k);
        heapSort(kArray);
        for(int i = k;i<arr.length;i++){
            if(arr[i]<kArray[k-1]){
                kArray[k-1] = arr[i];
                heapSort(kArray);
            }
        }
        return kArray;
    }
    private static void buildMaxHeap(int[] arr,int lastIndex){
        for(int i = (lastIndex-1)/2;i>=0;i--){
            int k = i;
            while(2*k+1 <= lastIndex){
                int biggerIndex = 2*k+1;
                if(biggerIndex <lastIndex){
                    if(arr[biggerIndex]< arr[biggerIndex+1])
                        biggerIndex++;
                }
                if(arr[k] < arr[biggerIndex]){
                    swap(arr,k,biggerIndex);
                    k = biggerIndex;
                }
                else
                    break;
            }
        }
    }
    private static void swap(int[] arr,int i ,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private static void heapSort(int[] arr){
        for(int i = 0;i<arr.length-1;i++){
            buildMaxHeap(arr,arr.length-i-1);
            swap(arr,0,arr.length-i-1);
        }
    }

    @Test
    public void Test1_1(){
        int[] arr= {4,5,1,6,2,7,3,8};
        int[] result = getSmallestNumbers(arr,5);
        for (int i: result){
            System.out.print(i+"\t");
        }

    }
    @Test
    public void Test1_2(){
        int[] arr= {4,5,1,6,2,7,3,8};
        int[] result = getSmallestNumbers(arr,12);
        for (int i: result){
            System.out.print(i+"\t");
        }
    }
    @Test
    public void Test2_1(){
        int[] arr= {4,5,1,6,2,7,3,8};
        int[] result = kSmallestNumbers(arr,5);
        for (int i: result){
            System.out.print(i+"\t");
        }
    }
    @Test
    public void Test2_2(){
        int[] arr= {4,5,1,6,2,7,3,8};
        int[] result = kSmallestNumbers(arr,12);
        for (int i: result){
            System.out.print(i+"\t");
        }
    }

}
