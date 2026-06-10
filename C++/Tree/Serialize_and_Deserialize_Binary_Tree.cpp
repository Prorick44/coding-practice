#include <bits/stdc++.h>
using namespace std;

// Definition for a binary tree node.
struct TreeNode
{
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};

class Codec
{
public:
  string serialize(TreeNode *root)
  {
    if (!root)
      return "#,";

    return to_string(root->val) + "," + serialize(root->left) + serialize(root->right);
  }

  TreeNode *deserialize(string data)
  {
    stringstream ss(data);
    return build(ss);
  }

private:
  TreeNode *build(stringstream &ss)
  {
    string val;
    getline(ss, val, ',');

    if (val == "#")
      return nullptr;

    TreeNode *root = new TreeNode(stoi(val));

    root->left = build(ss);
    root->right = build(ss);

    return root;
  }
};