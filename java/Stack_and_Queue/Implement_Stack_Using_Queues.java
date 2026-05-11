package java.Stack_and_Queue;

import java.util.*;

public class Implement_Stack_Using_Queues {
  Queue<Integer> queue;

  public Implement_Stack_Using_Queues() {
    queue = new LinkedList<>();
  }

  public void push(int x) {
    queue.offer(x);
    for (int i = 0; i < queue.size() - 1; i++) {
      queue.offer(queue.poll());
    }
  }

  public int pop() {
    return queue.poll();
  }

  public int top() {
    return queue.peek();
  }

  public boolean empty() {
    return queue.isEmpty();
  }
}
