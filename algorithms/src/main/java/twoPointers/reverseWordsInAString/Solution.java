package twoPointers.reverseWordsInAString;

import org.junit.Test;

import java.util.Arrays;

public class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        for (int i = 0; i < words.length; i++){
            words[i] = reverse(words[i]);
        }
        StringBuffer buffer = new StringBuffer();
        for (String word : words) {
            buffer.append(word);
            buffer.append(" ");
        }
        return buffer.toString().substring(0, s.length());
    }
    private String reverse(String s){
        char[] chars = s.toCharArray();
        int l = 0;
        int r = s.length() - 1;
        while (l < r){
            swap(chars, l++, r--);
        }
        return String.valueOf(chars);
    }
    private void swap(char[] c, int m, int n){
        char tmp = c[m];
        c[m] = c[n];
        c[n] = tmp;
    }

    @Test
    public void Test1(){
        String s = "Let's take LeetCode contest";
        System.out.println(reverseWords(s));
    }
}
