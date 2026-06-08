#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
  ListNode *reverseList(Listode *head)
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