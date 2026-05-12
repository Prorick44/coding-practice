package java.Trees;

class TreeNode {
  int val;
  TreeNode left, right;
}

public class Diameter_of_Binary_Tree {
  int diameter = 0;

  public int diameterOfBinaryTree(TreeNode root) {
    depth(root);
    return diameter;
  }

  int depth(TreeNode node) {
    if (node == null)
      return 0;
    int left = depth(node.left);
    int right = depth(node.right);
    diameter = Math.max(diameter, left + right);
    return 1 + Math.max(left, right);
  }
}
