package reverseWordsInSentence;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * 翻转单词顺序
 * 题目：输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 * 为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，
 * 则输出"student. a am I"。
 * Created by hxchen on 2018/8/23.
 */
public class ReverseWordsInSentence {

    public static String reverseWordsInSentence(String sentence){
        if (sentence == null || sentence.length() == 0)
            return sentence;
        Stack<String> stack = new Stack<>();
        String[] array = sentence.split("\t");
        for (String words: array){
            stack.push(words);
        }
        StringBuffer stringBuffer = new StringBuffer();
        while (!stack.empty()){
            stringBuffer.append(stack.pop());
            if (stack.size() >0)
                stringBuffer.append("\t");
        }
        return stringBuffer.toString();
    }
    // 功能测试，句子中有多个单词
    @Test
    public void Test1() {
        String input = "I am a student.";
        String expected = "student. a am I";
        Assert.assertEquals(expected, reverseWordsInSentence(input));
    }

    // 功能测试，句子中只有一个单词
    @Test
    public void Test2() {
        String input = "Wonderful";
        String expected = "Wonderful";
        Assert.assertEquals(expected, reverseWordsInSentence(input));
    }

    // 鲁棒性测试
    @Test
    public void Test3() {
        Assert.assertEquals(null, reverseWordsInSentence(null));
    }

    // 边界值测试，测试空字符串
    @Test
    public void Test4() {
        Assert.assertEquals("", reverseWordsInSentence(""));
    }

    // 边界值测试，字符串中只有空格
    @Test
    public void Test5() {
        String input = "   ";
        String expected = "   ";
        Assert.assertEquals(expected, reverseWordsInSentence(input));
    }
}
