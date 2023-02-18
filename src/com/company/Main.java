package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] x = { 11, 12, 14, 9, 7, 4, 17 };
        System.out.println(quickSelect(x, 2));
    }

    public static int quickSelect(int[] array, int k) {
        int[] arr = array.clone(); // we took a copy because orginal array can be effected by process
        int index = k - 1; // INDEX=3-1=2, I
        int left = 0;
        int right = arr.length;
        int s = lomuto(arr, left, right);
        while (s != index) {
            if (s > index)
                right = s;
            else
                left = s + 1;
            s = lomuto(arr, left, right);
        }
        return arr[index];
    }

    public static int lomuto(int[] arr, int left, int right) {
        int pivot = left;
        int s = left; // the current
        for (int i = left + 1; i < right; i++)
            if (arr[i] < arr[pivot])
                swap(arr, ++s, i);

        swap(arr, s, pivot);
        return s;
    }

    public static void swap(int[] arr, int x, int y) {
        int z = arr[x]; // storing in z temporary
        arr[x] = arr[y];
        arr[y] = z;

    }
}
