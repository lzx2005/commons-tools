package io.github.lzx2005.sort;

import io.github.lzx2005.common.CommonUtils;

import java.util.Arrays;
import java.util.Random;


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
        data[++count] = num;
        shiftUp(count);
    }

    private void shiftUp(int index) {
        while (index > 1 && data[index] > data[index / 2]) {
            CommonUtils.swap(data, index, index / 2);
            index /= 2;
        }
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void print() {
        for (int i : data) {
            System.out.println(i + " ");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (data != null) {
            Arrays.stream(data).forEach(i -> sb.append(i).append(","));
            sb.deleteCharAt(sb.length()-1);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(11);
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            maxHeap.insert(random.nextInt(1000));
        }
        System.out.println(maxHeap);
    }
}
