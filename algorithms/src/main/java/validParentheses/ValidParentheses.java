package validParentheses;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * Created by hxchen on 2019/1/9.
 */
public class ValidParentheses {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.size() == 0 && (s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}')) {
                return false;
            }
            if (s.charAt(i) == ')' && stack.peek() == '(') {
                stack.pop();
                continue;
            }
            if (s.charAt(i) == ']' && stack.peek() == '[') {
                stack.pop();
                continue;
            }
            if (s.charAt(i) == '}' && stack.peek() == '{') {
                stack.pop();
                continue;
            }
            stack.push(s.charAt(i));
        }
        if (stack.isEmpty())
            return true;
        return false;
    }

    @Test
    public void test1() {
        String string = "()]";
        boolean expected = false;
        Assert.assertTrue(expected == isValid(string));
    }

    @Test
    public void test2() {
        String string = "()[]{}";
        boolean expected = true;
        Assert.assertTrue(expected == isValid(string));
    }

    @Test
    public void test3() {
        String string = "(]";
        boolean expected = false;
        Assert.assertTrue(expected == isValid(string));
    }

    @Test
    public void test4() {
        String string = "([)]";
        boolean expected = false;
        Assert.assertTrue(expected == isValid(string));
    }

    @Test
    public void test5() {
        String string = "";
        boolean expected = true;
        Assert.assertTrue(expected == isValid(string));
    }

}
