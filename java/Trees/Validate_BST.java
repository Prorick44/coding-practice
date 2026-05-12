package java.Trees;

class TreeNode {
  int val;
  TreeNode left, right;
}

public class Validate_BST {
  public boolean isValidBST(TreeNode root) {
    return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }

  boolean validate(TreeNode node, long min, long max) {
    if (node == null)
      return true;
    if (node.val <= min || node.val >= max) {
      return false;
    }
    return validate(node.left, min, node.val) && validate(node.right, node.val, max);
  }
}
