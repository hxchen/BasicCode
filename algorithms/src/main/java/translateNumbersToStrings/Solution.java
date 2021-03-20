package translateNumbersToStrings;

/**
 * @author haixiangchen
 */
public class Solution {
    /**
     * 动态规划
     * f0 = 1， f1 = 1
     * f(i) = f(i-1) + g(i, i-1)*f(i-2)
     * 其中g(i, i-1)为第i-1和i位
     *
     * @param num
     * @return
     */
    public int translateNum(int num) {
        String str = String.valueOf(num);
        int f0 = 1, f1 = 1;
        for (int i = 2; i <= str.length(); i++) {
            int sub = Integer.parseInt(str.substring(i - 2, i));
            int g = 0;
            if (sub >= 10 && sub <= 25) {
                g = 1;
            } else {
                g = 0;
            }
            int temp = f1;
            f1 = f1 + g * f0;
            f0 = temp;
        }
        return f1;
    }
}
