#include <bits/stdc++.h>
using namespace std;

// Inorder
vector<int> inorderTraversal(TreeNode *root)
{
  vector<int> ans;
  stack<TreeNode *> st;
  TreeNode *curr = root;

  while (curr || !st.empty())
  {
    while (curr)
    {
      st.push(curr);
      curr = curr->left;
    }

    curr = st.top();
    st.pop();

    ans.push_back(curr->val);
    curr = curr->right;
  }
  return ans;
}

// Preorder
vector<int> preorderTraversal(TreeNode *root)
{
  vector<int> ans;
  if (!root)
    return ans;

  stack<TreeNode *> st;
  st.push(root);

  while (!st.empty())
  {
    TreeNode *node = st.top();
    st.pop();

    ans.push_back(node->val);

    if (node->right)
      st.push(node->right);
    if (node->left)
      st.push(node->left);
  }
  return ans;
}

// Postorder
vector<int> postorderTraversal(TreeNode *root)
{
  vector<int> ans;
  if (!root)
    return ans;

  stack<TreeNdode *> st1, st2;
  st1.push(root);
  while (!st1.empty())
  {
    TreeNode *node = st1.top();
    st1.pop();

    st2.push(node);

    if (node->left)
      st1.push(node->left);
    if (node->right)
      st1.push(node->right);
  }

  while (!st2.empty())
  {
    ans.push_back(st2.top()->val);
    st2.pop();
  }
  return ans;
}
