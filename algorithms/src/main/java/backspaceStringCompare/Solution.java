package backspaceStringCompare;

import org.junit.Assert;
import org.junit.Test;

/**
 * 给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。
 * 注意：如果对空文本输入退格字符，文本继续为空。
 *
 * 示例 1：
 * 输入：s = "ab#c", t = "ad#c"
 * 输出：true
 * 解释：s 和 t 都会变成 "ac"。
 *
 * 示例 2：
 * 输入：s = "ab##", t = "c#d#"
 * 输出：true
 * 解释：s 和 t 都会变成 ""。
 *
 * 示例 3：
 * 输入：s = "a#c", t = "b"
 * 输出：false
 * 解释：s 会变成 "c"，但 t 仍然是 "b"。
 */
public class Solution {
    /**
     * 准备两个指针 i, j 分别指向 S，T 的末位字符，再准备两个变量 skipS，skipT 来分别存放 S，T 字符串中的 # 数量。
     * >>>>-----从后往前-----<<<<遍历 S，所遇情况有三，如下所示：
     * 2.1 若当前字符是 #，则 skipS 自增 1；
     * 2.2 若当前字符不是 #，且 skipS 不为 0，则 skipS 自减 1；
     * 2.3 若当前字符不是 #，且 skipS 为 0，则代表当前字符不会被消除，我们可以用来和 T 中的当前字符作比较。
     * 若对比过程出现 S, T 当前字符不匹配，则遍历结束，返回 false，若 S，T 都遍历结束，且都能一一匹配，则返回 true。
     * @param s
     * @param t
     * @return
     */
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;
        int skipS = 0, skipT = 0;
        while (i >= 0 || j >= 0){
            while (i >= 0){
                if(s.charAt(i) == '#'){
                    skipS++;
                    i--;
                } else if(skipS != 0){
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }
            while (j >= 0){
                if(t.charAt(j) == '#'){
                    skipT++;
                    j--;
                } else if(skipT != 0){
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }
            if(i >= 0 && j >= 0){
                if(s.charAt(i) != t.charAt(j)){
                    return false;
                }
            }else{
                if (i >= 0 || j >= 0){
                    // 其中一个已经走完，小于0
                    return false;
                }
            }
            i--;
            j--;
        }
        return true;
    }

    @Test
    public void Test1(){
        String s = "ab##";
        String t = "c#d#";
        Assert.assertTrue(backspaceCompare(s, t));
    }
}
