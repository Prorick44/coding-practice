package java.Trees.Binary_Tree_Traversals;

import java.util.*;

public class Postorder_Traversal {
  List<Integer> result = new ArrayList<>();

  public List<Integer> postorderTraversal(TreeNode root) {
    postorder(root);
    return result;
  }

  void postorder(TreeNode node) {
    if (node == null)
      return;
    postorder(node.left);
    postorder(node.right);
    result.add(node.val);
  }
}
