package HOMEWORKS.HW1.Task_1;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] array = randomArray(15, -5, 23);
        System.out.println(Arrays.toString(array));

        heapSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void heapSort(int[] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            makeMaxHeap(arr, i, n);
        }

        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            makeMaxHeap(arr, 0, i);
        }
    }

    private static void makeMaxHeap(int[] arr, int i, int n) {
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int max = i;

        if (left < n && arr[left] > arr[max])
            max = left;

        if (right < n && arr[right] > arr[max])
            max = right;

        if (max != i) {
            int temp = arr[i];
            arr[i] = arr[max];
            arr[max] = temp;
            makeMaxHeap(arr, max, n);
        }

    }

    public static int[] randomArray(int len, int min, int max) {
        Random rd = new Random();
        int[] arr = new int[len];

        for (int i = 0; i < len; i++) {
            arr[i] = rd.nextInt(min, max + 1);
        }
        return arr;
    }
}
