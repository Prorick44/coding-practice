#include <bits/stdc++.h>
using namespace std;

struct TreeNode
{
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};

// Insert
TreeNode *insertIntoBST(TreeNode *root, int val)
{
  if (!root)
    return new TreeNode(val);

  if (val < root->val)
    root->left = insertIntoBST(root->left, val);
  else
    root->right = insertIntoBST(root->right, val);
  return root;
}

// Search
TreeNode *searchBST(TreeNode *root, int val)
{
  if (!root || root->val == val)
    return root;

  if (val < root->val)
    return searchBST(root->left, val);

  return searchBST(root->right, val);
}

// Delete
TreeNode *findMin(TreeNode *root)
{
  while (root->left)
    root = root->left;

  return root;
}

TreeNode *deleteNode(TreeNode *root, int key)
{
  if (!root)
    return root;

  if (key < root->val)
    root->left = deleteNode(root->left, key);
  else if (key > root->val)
    root->right = deleteNode(root->right, key);
  else
  {
    if (!root->left)
      return root->right;
    if (!root->right)
      return root->left;

    TreeNode *temp = findMin(root->right);
    root->val = temp->val;
    root->right = deleteNode(root->right, temp->val);
  }
  return root;
}