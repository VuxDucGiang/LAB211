package Week1.LinearSearch;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of array: ");
        int n = sc.nextInt();
        
        LinearSearch linearSearch = new LinearSearch(n);
        
        linearSearch.addValue();
        linearSearch.showArray();
        
        System.out.println("Enter search value: ");
        int searchvalue = sc.nextInt();
        int index = linearSearch.searchValue(searchvalue);
        
        if(index != -1 ){
            System.out.println("Found " + searchvalue + " at the index: " +index);
        }else {
            System.out.println(searchvalue + " not found in the array.");
        }
    }
    
}
