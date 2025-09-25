package neetcode150.stacks;

import java.util.Stack;

public class MinimumStack {
    Stack<Integer> mainStack;
    Stack<Integer> minStack;

    public void MinStack() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        mainStack.push(val);

        if(minStack.empty() || minStack.peek() >= val) {
            minStack.push(val);
        }
    }

    public void pop() {
        int val = mainStack.pop();
        if(!minStack.empty() && minStack.peek() == val)
            minStack.pop();

    }

    public int top() {
        return mainStack.peek();
    }

    public int getMin() {
        if(!minStack.empty())
            return minStack.peek();
        else
            return 0;
    }
}
