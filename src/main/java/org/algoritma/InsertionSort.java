package org.algoritma;//Insertion Sort
import java.util.Arrays;
import java.util.Random;

public class InsertionSort {
    public static void main(String[] args) {
        int[] randomArray = generateRandomArray(500);

        System.out.println("Algoritma Insertion Sort: ");
        long insertionSortStartTime = System.nanoTime();
        insertionSort(randomArray);
        long insertionSortEndTime = System.nanoTime();
        long insertionSortExecutionTime = insertionSortEndTime - insertionSortStartTime;
        double executionTimeMilliseconds = (double) insertionSortExecutionTime / 1_000_000.0;
        System.out.println("Waktu eksekusi Insertion Sort: " + insertionSortExecutionTime + " nanoseconds");
        System.out.println("Waktu eksekusi Selection Sort (milliseconds): " + executionTimeMilliseconds + " ms");
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
            System.out.println(Arrays.toString(arr));
        }
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