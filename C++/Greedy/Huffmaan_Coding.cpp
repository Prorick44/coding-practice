#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
  struct Node
  {
    int data;
    Node *left, *right;

    Node(int val)
    {
      data = val;
      left = right = nullptr;
    }
  };

  struct cmp
  {
    bool operator()(Node *a, Node *b)
    {
      return a->data > b->data;
    }
  };

  void traverse(Node *root, string s, vector<string> &ans)
  {
    if (!root->left && !root->right)
    {
      ans.push_back(s);
      return;
    }

    traverse(root->left, s + "0", ans);
    traverse(root->right, s + "1", ans);
  }

  vector<string> huffmanCodes(string S, vector<int> f, int N)
  {
    priority_queue<Node *, vector<Node *>, cmp> pq;

    for (int i = 0; i < N; i++)
      pq.push(new Node(f[i]));

    while (pq.size() > 1)
    {
      Node *left = pq.top();
      pq.pop();
      Node *right = pq.top();
      pq.pop();

      Node *node = new Node(left->data + right->data);
      node->left = left;
      node->right = right;

      pq.push(node);
    }
    vector<string> ans;
    traverse(pq.top(), "", ans);

    return ans;
  }
};