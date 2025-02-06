package Week3.QuickSort;

import java.util.Random;

public class QuickSort {

    private int[] array;

    public QuickSort(int size) {
        this.array = new int[size];
    }

    public void addValue() {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(20);
        }
    }

    public void sort(int arr[], int low, int high) {
        if (low < high) {

            int pi = partition(arr, low, high);
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    public int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {

            if (arr[j] < pivot) {
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

    public void showArray(int n) {
        if (n == 1) {
            System.out.println("The array before sorting: ");

            for (int value : array) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
        if (n == 2) {
            System.out.println("The array after sorting: ");
            sort(array, 0,array.length -1);
            for (int value : array) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
