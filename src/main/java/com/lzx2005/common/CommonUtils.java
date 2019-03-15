package com.lzx2005.common;

public class CommonUtils {

    public static void swap(Object[] array, int x, int y) {
        Object temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

}
