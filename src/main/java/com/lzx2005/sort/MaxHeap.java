package com.lzx2005.sort;

import com.lzx2005.common.CommonUtils;


public class MaxHeap {

    private Integer[] data;
    private int count;
    private int capacity;

    MaxHeap(int capacity) {
        this.data = new Integer[capacity];
        this.capacity = capacity;
        this.count = 0;
    }

    public void insert(int num) {
        if (count >= capacity) throw new IndexOutOfBoundsException("heap is full");
        this.data[++count] = num;
        this.shiftUp(count);
    }

    private void shiftUp(int index) {
        while (index > 1 && this.data[index] > this.data[index / 2]) {
            CommonUtils.swap(this.data, index, index / 2);
            index /= 2;
        }
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }
}
