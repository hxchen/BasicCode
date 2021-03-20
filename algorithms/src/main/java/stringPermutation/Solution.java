package stringPermutation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author haixiangchen
 */
public class Solution {
    List<String> res = new ArrayList<>();
    Set<String> set = new HashSet<>();

    public String[] permutation(String s) {
        char[] charArray = s.toCharArray();
        permutation(charArray, 0);
        String[] arr = new String[set.size()];
        for (String value : set) {
            res.add(value);
        }
        return res.toArray(new String[res.size()]);
    }

    public void permutation(char[] charArray, int pos) {
        if (pos == charArray.length - 1 && !set.contains(String.valueOf(charArray))) {
            set.add(String.valueOf(charArray));
        } else {
            for (int i = pos; i < charArray.length; i++) {
                swap(charArray, i, pos);
                permutation(charArray, pos + 1);
                swap(charArray, i, pos);
            }
        }
    }

    public void swap(char[] charArray, int i, int j) {
        char tmp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = tmp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.permutation("dkjphedy");
        System.out.println(solution.res.size());
        System.out.println(solution.res);
    }
}
