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
  ListNode *removeNthFromEnd(ListNode *head, int n)
  {
    ListNode dummy(0);
    dummy.next = head;

    ListNode *fast = &dummy, *slow = &dummy;

    for (int i = 0; i <= n; i++)
      fast = fast->next;

    while (fast)
    {
      fast = fast->next;
      slow = slow->next;
    }

    slow->next = slow->next->next;

    return dummy.next;
  }
};