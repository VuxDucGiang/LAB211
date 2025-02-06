package Week3.BubbleSort;

public class Main {
    public static void main(String[] args) {
        
        BubbleSort bubbleSort = new BubbleSort(Input.getInt());
       
        bubbleSort.addValue();
        bubbleSort.showArray(1);

        bubbleSort.sort();
        bubbleSort.showArray(2);
        }
}
