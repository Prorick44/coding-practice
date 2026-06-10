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
  ListNode *reverseList(ListNode *head)
  {
    ListNode *prev = nullptr, *curr = head;

    while (curr)
    {
      ListNode *nextNode = curr->next;
      curr->next = prev;
      prev = curr;
      curr = nextNode;
    }
    return prev;
  }
};