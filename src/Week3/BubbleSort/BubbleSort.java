package Week3.BubbleSort;

import java.util.Random;

public class BubbleSort {

    private int[] array;

    public BubbleSort(int size) {
        this.array = new int[size];
    }

    public void addValue() {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(20);
        }
    }

    public void showArray(int n) {    
      if(n == 1){
          System.out.println("The array before sorting: ");
      
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
      }
      if(n == 2){
           System.out.println("The array after sorting: ");
      
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
      }
    }

    public void sort() {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {  
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
