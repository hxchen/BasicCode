package stringPermutation;

import org.junit.Test;

/**
 * 字符串的排列
 * 题目：输入一个字符串，打印出该字符串中字符的所有排列。例如输入字符串abc，
 * 则打印出由字符a、b、c所能排列出来的所有字符串abc、acb、bac、bca、cab和cba。
 * 注意:字符串中各个字符不一样。
 * Created by hxchen on 2018/7/8.
 */
public class StringPermutation {

    public void Permutation(String str) {
        if (str == null)
            return;

        char[] charArray = str.toCharArray();
        Permutation(charArray, 0);

    }

    private void Permutation(char[] charArray, int loc) {
        if (loc == charArray.length - 1) {
            System.out.print(String.valueOf(charArray) + "\t");
        } else {
            for (int i = loc; i < charArray.length; i++) {
                swap(charArray, i, loc);
                Permutation(charArray, loc + 1);
                swap(charArray, i, loc);
            }
        }
    }

    private void swap(char[] charArray, int i, int j) {
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
    }

    @Test
    public void Test1() {
        String string = "a";
        Permutation(string);
    }

    @Test
    public void Test2() {
        String string = "abc";
        Permutation(string);
    }

    @Test
    public void Test3() {
        String string = "abcd";
        Permutation(string);
    }

    @Test
    public void Test4() {
        String string = "";
        Permutation(string);
    }

    @Test
    public void Test5() {
        String string = null;
        Permutation(string);
    }
}
