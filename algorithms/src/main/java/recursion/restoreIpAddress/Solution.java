package recursion.restoreIpAddress;

import java.util.ArrayList;
import java.util.List;

/**
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 *
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 *
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入'.' 来形成。你 不能重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 *
 * 链接：https://leetcode.cn/problems/restore-ip-addresses
 *
 */
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        List<String> current = new ArrayList<>();
        backtrack(result, current, s, 0);
        return result;
    }

    /**
     *
     * @param result 存储最终结果的列表，每个元素都是一个有效的 IP 地址。
     * @param current 当前正在构建的 IP 地址的分段列表。
     * @param s 输入的字符串。
     * @param start 当前处理的位置。
     */
    private void backtrack(List<String> result, List<String> current, String s, int start) {
        // 如果 current 中已经有 4 个分段且已经遍历完了字符串 s，说明我们已经构建了一个有效的 IP 地址，将其添加到结果列表 result 中，然后返回。
        if (current.size() == 4 && start == s.length()) {
            result.add(String.join(".", current));
            return;
        }
        // 如果 current 中已经有 4 个分段但还没有遍历完字符串 s，或者已经遍历完了字符串 s 但 current 中不足 4 个分段，说明不能构成有效的 IP 地址，直接返回。
        if (current.size() == 4 || start == s.length()) {
            return;
        }

        for (int i = 1; i <= 3 && start + i <= s.length(); i++) {
            String segment = s.substring(start, start + i);
            if (isValidSegment(segment)) {
                current.add(segment);
                backtrack(result, current, s, start + i);
                current.remove(current.size() - 1);
            }
        }
    }

    private boolean isValidSegment(String segment) {
        if (segment.length() > 1 && segment.charAt(0) == '0') {
            return false; // Leading zeros are not allowed
        }
        int num = Integer.parseInt(segment);
        return num >= 0 && num <= 255;
    }
}
