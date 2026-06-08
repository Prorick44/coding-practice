#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
  bool isPalindrome(ListNode *head)
  {
    if (!head || !head->next)
      return true;

    ListNode *slow = head, *fast = head;

    while (fast && fast->next)
    {
      slow = slow->next;
      fast = fast->next->next;
    }

    ListNode *prev = nullptr;

    while (slow)
    {
      ListNode *nextNode = slow->next;
      slow->next = prev;
      prev = slow;
      slow = nextNode;
    }

    while (prev)
    {
      if (head->val != prev->val)
        return false;
      head = head->next;
      prev = prev->next;
    }
    return true;
  }
};