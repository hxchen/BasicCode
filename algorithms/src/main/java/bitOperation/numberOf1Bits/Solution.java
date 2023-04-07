package bitOperation.numberOf1Bits;


/**
 * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。
 */
public class Solution {
    /**
     * n && (n - 1) 可以消掉一个最低位1
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        if (n == 0) return 0;
        int i = 1;
        while ((n = n & (n - 1)) != 0){
            i++;
        }
        return i;
    }

}
