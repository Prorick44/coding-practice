#include <bits/stdc++.h>
using namespace std;

Node *merge(Node *a, Node *b)
{
  if (!a)
    return b;
  if (!b)
    return a;

  Node *result;

  if (a->data < b->data)
  {
    result = a;
    result->bottom = merge(a->bottom, b);
  }
  else
  {
    result = b;
    result->bottom = merge(a, b->bottom);
  }
  result->next = nullptr;
  return result;
}

Node *faltten(Node *root)
{
  if (!root || !root->next)
    return root;

  root->next = flatten(root->next);

  return merge(root, root->next);
}