package twoPointers.reverseString;

import org.junit.Test;

/**
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 *
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 */
public class Solution {
    public void reverseString(char[] s) {
        int l = 0;
        int r = s.length - 1;
        while (l < r){
            swap(s, l++, r--);
        }
    }
    private void swap(char[] s, int m, int n){
        char tmp = s[m];
        s[m] = s[n];
        s[n] = tmp;
    }

    @Test
    public void Test1(){
        char[] s = new char[]{'h', 'e', 'l', 'l','o'};
        reverseString(s);
        System.out.println(s);
    }
    @Test
    public void Test2(){
        char[] s = new char[]{'c', 'a', 'k', 'e'};
        reverseString(s);
        System.out.println(s);
    }
}
