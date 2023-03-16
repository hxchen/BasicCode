package letterCombinationsOfAPhoneNumber;

import org.junit.Test;

import java.util.*;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 2-[a, b, c]
 * 3-[d, e, f]
 * 4-[g, h, i]
 * 5-[j, k, l]
 * 6-[m, n, o]
 * 7-[p, q, r, s]
 * 8-[t, u, v]
 * 9-[w, x, y, z]
 *
 * 示例 1：
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 *
 * 示例 2：
 * 输入：digits = ""
 * 输出：[]
 *
 * 示例 3：
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 */
public class Solution {
    public List<String> letterCombinations(String digits) {
        String[][] dic = new String[][]{{"a", "b","c"}, {"d", "e", "f"}, {"g", "h","i"}, {"j", "k", "l"}, {"m", "n", "o"},
                {"p", "q", "r", "s"}, {"t", "u", "v"}, {"w", "x", "y", "z"}};
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < digits.length(); i++){
            // 新的一位带来的候选字母
            int index = Character.getNumericValue(digits.charAt(i));
            String[] value = dic[index - 2];
            int queueSize = queue.size();
            if (queueSize == 0){
                // 挨个追加到已经有的里面去
                queue.addAll(Arrays.asList(value));
            } else {
                for (int k = 0; k < queueSize; k++){
                    String oldValue = queue.poll();
                    for (int j = 0; j < value.length; j ++){
                        queue.offer(oldValue + value[j]);
                    }
                }
            }
        }
        return new ArrayList<>(queue);
    }

    @Test
    public void Test1(){
        String digits = "23";
        System.out.println(letterCombinations(digits));
//        Queue<String> queue = new LinkedList<>();
//        queue.add("a");
//        queue.add("b");
//        System.out.println(new ArrayList<>(queue));
    }
}
