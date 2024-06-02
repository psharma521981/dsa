package meta.stack_and_queues;

import java.util.Stack;

public class QueueUsingStack {
    Stack<Integer> firstStack = new Stack<>();
    Stack<Integer> secondStack = new Stack<>();
    public  void enqueue(int a) {
        //if both are empty then no elements
        //Use first stack to enqueue every new item
        if(firstStack.empty() && !secondStack.empty()) {
            //move element from second to first
            while(!secondStack.empty()) {
                firstStack.push(secondStack.pop());
            }
        }

        firstStack.push(a);


    }
    public  int dequeue() {
        //when dequeue is called
        //if firststack is empty then second stack must have element
        if(firstStack.empty() && !secondStack.empty()) {
            //move element from second to first
           return secondStack.pop();
        }
        if(!firstStack.empty() && secondStack.empty()) {
            //move element from second to first
            while(!firstStack.empty()) {
                secondStack.push(firstStack.pop());
            }
        }
        return secondStack.pop();
        //if both are empty then no elements. thwo exception
        //pop all the items from first stack and push in second stack
        //and return peek element from second stack
    }
    public  int print() {
        if(firstStack.empty() && !secondStack.empty()) {
            //move element from second to first
            return secondStack.peek();
        }
        if(!firstStack.empty() && secondStack.empty()) {
            //move element from second to first
            while(!firstStack.empty()) {
                secondStack.push(firstStack.pop());
            }
        }
        return secondStack.peek();
        //pop all the items from first stack and push in second stack
        //if firststack is epty then second stack must have element
        //if both are empty then no elements
        //and return peek element from second stack
    }
    public static void main(String[] args) {
    }
}
