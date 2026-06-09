#include <bits/stdc++.h>
using namespace std;

class MyCircularQueue
{
  vector<int> q;
  int front, rear, size, capacity;

public:
  MyCircularQueue(int k)
  {
    q.resize(k);
    capacity = k;
    front = 0;
    rear = -1;
    size = 0;
  }

  bool enQueue(int value)
  {
    if (isFull())
      return false;

    rear = (rear + 1) % capacity;
    q[rear] = value;
    size++;
    return true;
  }

  bool deQueue()
  {
    if (isEmpty())
      return false;

    front = (front + 1) % capacity;
    size--;
    return true;
  }

  int Front()
  {
    return isEmpty() ? -1 : q[front];
  }

  int Rear()
  {
    return isEmpty() ? -1 : q[rear];
  }

  int isEmpty()
  {
    return size == 0;
  }

  bool isFull()
  {
    return size == capacity;
  }
};