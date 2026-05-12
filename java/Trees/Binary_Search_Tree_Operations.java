package java.Trees;

class TreeNode {
  int val;
  TreeNode left, right;

  TreeNode(int val) {
    this.val = val;
  }
}

public class Binary_Search_Tree_Operations {
  TreeNode insert(TreeNode root, int val) {
    if (root == null)
      return new TreeNode(val);
    if (val < root.val)
      root.left = insert(root.left, val);
    else
      root.right = insert(root.right, val);
    return root;
  }

  boolean search(TreeNode root, int key) {
    if (root == null)
      return false;
    if (root.val == key)
      return true;
    if (key < root.val)
      return search(root.left, key);
    return search(root.right, key);
  }

  TreeNode delete(TreeNode root, int key) {
    if (root == null)
      return null;

    if (key < root.val)
      root.left = delete(root.left, key);
    else if (key > root.val)
      root.right = delete(root.right, key);
    else {
      if (root.left == null)
        return root.right;
      if (root.right == null)
        return root.left;
      TreeNode min = findMin(root.right);
      root.val = min.val;
      root.right = delete(root.right, min.val);
    }
    return root;
  }

  TreeNode findMin(TreeNode node) {
    while (node.left != null)
      node = node.left;
    return node;
  }
}
