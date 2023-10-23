package org.algoritma;

import java.util.Arrays;
import java.util.Random;

public class MergeSort {
    private static int iteration = 0;

    public static void main(String[] args) {
        int[] arr = generateRandomArray(500); // Ganti 100000 dengan panjang array yang Anda inginkan
        System.out.println("Array sebelum pengurutan: " + Arrays.toString(arr));

        long startTime = System.nanoTime();
        mergeSort(arr, 0, arr.length - 1);
        long endTime = System.nanoTime();

        System.out.println("Array setelah pengurutan: " + Arrays.toString(arr));

        long durationInNano = endTime - startTime;
        double durationInMilli = (double) durationInNano / 1_000_000.0;

        System.out.println("Waktu eksekusi (Nanosecond): " + durationInNano);
        System.out.println("Waktu eksekusi (Millisecond): " + durationInMilli);
    }

    public static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(100);
        }
        return arr;
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArr[i] = arr[left + i];
        }
        for (int i = 0; i < n2; i++) {
            rightArr[i] = arr[mid + 1 + i];
        }
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }

        iteration++;
        // Print proses pengurutan pada setiap iterasi
        System.out.println("Iterasi ke-" + iteration + ": " + Arrays.toString(arr));
    }
}