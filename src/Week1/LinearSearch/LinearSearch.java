    package Week1.LinearSearch;

import java.util.Random;

public class LinearSearch {
    private int[] array;

    public LinearSearch(int n) {
        this.array = new int[n];
    }

    public void addValue() {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(array.length); // 
        }
    }

    public void showArray() {
        System.out.print("The array: ");
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public int searchValue(int x) {
       //edit
       for (int i = 0; i < this.array.length; i++){
        if(array[i]==x)
            return i;
           
       }
       return -1;
    }
}
