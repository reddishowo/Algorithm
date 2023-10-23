package org.algoritma;

import java.util.Arrays;
import java.util.Random;

public class SelectionSort {
    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Tukar elemen terkecil dengan elemen pada indeks i
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;

            System.out.println("Iterasi ke-" + (i + 1) + ": " + Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
        int[] arr = generateRandomArray(10);

        System.out.println("Array sebelum Selection Sort: " + Arrays.toString(arr));
        long startTime = System.nanoTime();
        selectionSort(arr);
        long endTime = System.nanoTime();

        System.out.println("Array setelah Selection Sort: " + Arrays.toString(arr));

        long executionTime = endTime - startTime;
        double executionTimeMilliseconds = (double) executionTime / 1_000_000.0;
        System.out.println("Waktu eksekusi Selection Sort (nanoseconds): " + executionTime + " ns");
        System.out.println("Waktu eksekusi Selection Sort (milliseconds): " + executionTimeMilliseconds + " ms");
    }

    public static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(100);
        }
        return arr;
    }
}