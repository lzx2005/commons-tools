package com.lzx2005.math;

import java.util.Stack;

/**
 * N进制与10进制互转工具
 * Created by hzlizx on 2018/4/8 0008
 */
public class ConvertRadix {
    private final static char[] array = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private final static String numStr = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    //10进制转为其他进制，除留取余，逆序排列
    public static String _10_to_N(long number, int N) {
        long rest = number;
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder(0);
        while (rest != 0) {
            stack.add(array[new Long((rest % N)).intValue()]);
            rest = rest / N;
        }
        for (; !stack.isEmpty(); ) {
            result.append(stack.pop());
        }
        return result.length() == 0 ? "0" : result.toString();
    }

    // 其他进制转为10进制，按权展开
    public static long N_to_10(String number, int N) {
        char[] ch = number.toCharArray();
        int len = ch.length;
        long result = 0;
        if (N == 10) {
            return Long.parseLong(number);
        }
        long base = 1;
        for (int i = len - 1; i >= 0; i--) {
            int index = numStr.indexOf(ch[i]);
            result += index * base;
            base *= N;
        }
        return result;
    }
}
