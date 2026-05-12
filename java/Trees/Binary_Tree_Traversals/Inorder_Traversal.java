package java.Trees.Binary_Tree_Traversals;

import java.util.*;

class TreeNode {
  int val;
  TreeNode left, right;

  TreeNode(int val) {
    this.val = val;
  }
}

public class Inorder_Traversal {
  List<Integer> result = new ArrayList<>();

  public List<Integer> inorderTraversal(TreeNode root) {
    inorder(root);
    return result;
  }

  void inorder(TreeNode node) {
    if (node == null)
      return;
    inorder(node.left);
    result.add(node.val);
    inorder(node.right);
  }
}
