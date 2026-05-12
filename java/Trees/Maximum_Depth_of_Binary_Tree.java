package java.Trees;

class TreeNode {
  int val;
  TreeNode left, right;
}

public class Maximum_Depth_of_Binary_Tree {
  public int maxDepth(TreeNode root) {
    if (root == null)
      return 0;
    return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
  }
}
