#include <bits/stdc++.h>
using namespace std;

struct ListNode
{
  int val;
  ListNode *next;
  ListNode(int x) : val(x), next(nullptr) {}
};

class Solution
{
public:
  ListNode *reverseKGroup(ListNode *head, int k)
  {
    ListNode *curr = head;
    int count = 0;

    while (curr && count < k)
    {
      curr = curr->next;
      count++;
    }

    if (count < k)
      return head;

    curr = head;
    ListNode *prev = nullptr, *nextNode = nullptr;
    count = 0;

    while (curr && count < k)
    {
      nextNode = curr->next;
      curr->next = prev;
      prev = curr;
      curr = nextNode;
      count++;
    }
    head->next = reverseKGroup(curr, k);
    return prev;
  }
};