package java.Trees.Binary_Tree_Traversals;

import java.util.*;

public class Preorder_Traversal {
  List<Integer> result = new ArrayList<>();

  public List<Integer> preorderTraversal(TreeNode root) {
    preorder(root);
    return result;
  }

  void preorder(TreeNode node) {
    if (node == null)
      return;
    result.add(node.val);
    preorder(node.left);
    preorder(node.right);
  }
}
