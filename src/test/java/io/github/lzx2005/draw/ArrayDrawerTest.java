package io.github.lzx2005.draw;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by hzlizx on 2019/4/9
 */
public class ArrayDrawerTest {

    @Test
    public void draw() {
        int[] a = {1,2,3,4,5,6};
        ArrayDrawer.draw(a);


        int[][] aa = {{55,67,-1},{1,2,3,4,5,6},{1,2,3,4,5,6},{2,3,5},{1}};
        ArrayDrawer.draw(aa);
    }
}