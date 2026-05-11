package java.Stack_and_Queue;

public class Circular_Queue {
  int[] queue;

  int front;
  int rear;
  int size;
  int capacity;

  public Circular_Queue(int k) {
    capacity = k;
    queue = new int[k];
    front = 0;
    rear = -1;
    size = 0;
  }

  public boolean enQueue(int value) {
    if (isFull())
      return false;
    rear = (rear + 1) % capacity;
    queue[rear] = value;
    size++;
    return true;
  }

  public boolean deQueue() {
    if (isEmpty())
      return false;
    front = (front + 1) % capacity;
    size--;
    return true;
  }

  public int Front() {
    return isEmpty() ? -1 : queue[rear];
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public boolean isFull() {
    return size == capacity;
  }
}
