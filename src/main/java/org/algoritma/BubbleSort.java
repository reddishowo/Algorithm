package org.algoritma;//Algoritma Bubble Sort
import java.util.Arrays;
import java.util.Random;

public class BubbleSort {
    public static void main(String[] args) {
        int[] randomArray = generateRandomArray(500);

        System.out.println("Algoritma Bubble Sort: ");
        long bubbleSortStartTime = System.nanoTime();
        bubbleSort(randomArray);
        long bubbleSortEndTime = System.nanoTime();
        long bubbleSortExecutionTime = bubbleSortEndTime - bubbleSortStartTime;
        double executionTimeMilliseconds = (double) bubbleSortExecutionTime / 1_000_000.0;
        System.out.println("Waktu eksekusi Bubble Sort: " + bubbleSortExecutionTime + " nanoseconds");
        System.out.println("Waktu eksekusi Selection Sort (milliseconds): " + executionTimeMilliseconds + " ms");
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
                System.out.println(Arrays.toString(arr));
            }
            if (!swapped) {
                break;
            }
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