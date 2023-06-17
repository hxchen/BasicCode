package other.factorialConversion;

import java.math.BigInteger;

/**
 * 整数N的阶乘转换为12进制表示的结果P，Java编程实现
 * 1.P的非0的末位是几
 * 2.p是几位数
 * 3.P的末尾有几个0
 */
public class Solution {
    public static void main(String[] args) {
        int N = 100000; // 输入整数N

        BigInteger factorial = calculateFactorial(N); // 计算N的阶乘
        System.out.println("N:" + N +"的阶乘是：" + factorial);

        String P = convertToBase12(factorial); // 将阶乘结果转换为12进制表示的字符串
        System.out.println("转换为12进制是：" + P);
        // P的非0的末位
        char lastNonZeroDigit = getLastNonZeroDigit(P);
        System.out.println("P的非0的末位是：" + lastNonZeroDigit);

        // P的位数
        int numDigits = P.length();
        System.out.println("P是" + numDigits + "位数");

        // P的末尾0的个数
        int numTrailingZeros = countTrailingZeros(P);
        System.out.println("P的末尾有" + numTrailingZeros + "个0");
    }

    // 计算N的阶乘
    public static BigInteger calculateFactorial(int n){
        BigInteger factorial = BigInteger.ONE;
        for (int i = 2; i < n; i++){
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        return factorial;
    }

    // 将BigInteger转换为12进制表示的字符串
    public static String convertToBase12(BigInteger number){
        StringBuilder sb = new StringBuilder();
        BigInteger base = BigInteger.valueOf(12);
        while (number.compareTo(BigInteger.ZERO) > 0){
            BigInteger[] quotientAndRemainder = number.divideAndRemainder(base);
            BigInteger quotient = quotientAndRemainder[0];  // 商
            BigInteger remainder = quotientAndRemainder[1]; // 余数
            sb.insert(0, remainder.toString()); // 在字符串的开头插入余数
            number = quotient;
        }
        return sb.toString();
    }

    // 获取P的非0的末位
    public static char getLastNonZeroDigit(String P) {
        for (int i = P.length() - 1; i >= 0; i--) {
            char digit = P.charAt(i);
            if (digit != '0') {
                return digit;
            }
        }
        return '0'; // 如果P全为0，则返回0
    }

    // 计算P的末尾0的个数
    public static int countTrailingZeros(String P) {
        int count = 0;
        for (int i = P.length() - 1; i >= 0; i--) {
            if (P.charAt(i) == '0') {
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}
