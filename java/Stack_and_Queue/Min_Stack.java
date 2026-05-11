package java.Stack_and_Queue;

import java.util.*;

public class Min_Stack {
  Stack<Integer> stack;
  Stack<Integer> minStack;

  public Min_Stack() {
    stack = new Stack<>();
    minStack = new Stack<>();
  }

  public void push(int val) {
    stack.push(val);
    if (minStack.isEmpty() || val <= minStack.peek()) {
      minStack.push(val);
    }
  }

  public void pop() {
    if (stack.pop().equals(minStack.peek())) {
      minStack.pop();
    }
  }

  public int top() {
    return stack.peek();
  }

  public int getMin() {
    return minStack.peek();
  }
}
