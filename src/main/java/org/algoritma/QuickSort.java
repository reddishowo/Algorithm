package org.algoritma;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(arr, low, high);
            System.out.println("Iterasi ke-" + partitionIndex + ": " + Arrays.toString(arr)); // Menampilkan iterasi ke berapa
            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        int[] arr = generateRandomArray(500);

        System.out.println("Array sebelum Quick Sort: " + Arrays.toString(arr));
        long startTime = System.nanoTime();
        quickSort(arr, 0, arr.length - 1);
        long endTime = System.nanoTime();

        System.out.println("Array setelah Quick Sort: " + Arrays.toString(arr));

        long executionTime = endTime - startTime;
        double executionTimeMilliseconds = (double) executionTime / 1_000_000.0;
        System.out.println("Waktu eksekusi Quick Sort (nanoseconds): " + executionTime + " ns");
        System.out.println("Waktu eksekusi Quick Sort (milliseconds): " + executionTimeMilliseconds + " ms");
    }

    public static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(20);
        }
        return arr;
    }
}