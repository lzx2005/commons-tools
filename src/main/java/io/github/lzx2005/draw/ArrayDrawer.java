package io.github.lzx2005.draw;

/**
 * Created by hzlizx on 2019/4/9
 */
public class ArrayDrawer {

    public static void draw(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i != array.length - 1) {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }

    public static void draw(int[][] array) {
        System.out.println("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print("\t[");
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]);
                if (j != array[i].length - 1) {
                    System.out.print(",");
                }
            }
            System.out.print("]");
            if (i != array.length - 1) {
                System.out.print(",");
            }
            System.out.println();
        }
        System.out.println("]");
    }
}
