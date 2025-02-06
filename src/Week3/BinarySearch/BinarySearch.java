package Week3.BinarySearch;

import java.util.Arrays;
import java.util.Random;

public class BinarySearch {

    private int[] array;

    public BinarySearch(int size) {
        this.array = new int[size];
    }

    public void addValue() {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(20);
        }
        Arrays.sort(array);  
    }

    public int Search(int arr[], int l, int r, int x) {
        if (r >= l) {
            int mid = l + (r - l) / 2;

            if (arr[mid] == x) {
                return mid; // Found element
            }

            if (arr[mid] > x) {
                return Search(arr, l, mid - 1, x); // Search left half
            }

            return Search(arr, mid + 1, r, x); // Search right half
        }
        return -1; // Not found
    }

    public void runSearch() {
        int n = array.length;
        int x = Input.getValue();  // Target value to search
        int result = Search(array, 0, n - 1, x);

        if (result == -1) {
            System.out.println("Not found: " + x);
        } else {
            System.out.println("Found " + x + " at index " + result);
        }
    }

    public void showArray() {
        System.out.println("The sorted array: ");
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
