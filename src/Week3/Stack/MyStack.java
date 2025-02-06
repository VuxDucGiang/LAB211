package Week3.Stack;

import java.util.Stack;

public class MyStack {
       public static void main(String[] args) { //LIFO
        Stack<Integer> stackValues = new Stack<>();
        
        stackValues.push(10);
        stackValues.push(20);
        stackValues.push(30);
        
        System.out.println("Top element of the stack: " + stackValues.peek());
        
        int pooped = stackValues.pop();
        
        System.out.println("Removed element: " + pooped ); //Value out
        
        System.out.println("Is the stack empty? " + stackValues.isEmpty());
        
        System.out.println("Size of the stack: " + stackValues.size());
        
        System.out.println("Position of 20: "+ stackValues.search(20)); // Top
        
           System.out.println("Get Value of 1: " + stackValues.get(0));   //Bottom
    }
 
}
