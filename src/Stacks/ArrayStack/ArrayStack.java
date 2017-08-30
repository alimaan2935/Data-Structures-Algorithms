package Stacks.ArrayStack;

import java.util.NoSuchElementException;
import java.util.Stack;

public class ArrayStack extends Stack {

    //Holds the stack elements
    private String[] stack;

    private int top = -1;

    public ArrayStack (int capacity) {
        stack = new String[capacity];
    }

    public String pop() {
        if (stack.length == 0) {
            throw new NoSuchElementException("Stack is empty");
        }
        String temp = stack[top];

        //facilitate garbage collection
        stack[top] = null;
        top--;
        return temp;
    }


}
