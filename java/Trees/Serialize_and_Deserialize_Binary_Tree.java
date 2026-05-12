package java.Trees;

import java.util.*;

class TreeNode {
  int val;
  TreeNode left, right;

  TreeNode(int val) {
    this.val = val;
  }
}

public class Serialize_and_Deserialize_Binary_Tree {
  public String serialize(TreeNode root) {
    if (root == null)
      return "null";
    return root.val + "," + serialize(root.left) + "," + serialize(root.right);
  }

  public TreeNode deserialize(String data) {
    Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
    return build(queue);
  }

  TreeNode build(Queue<String> queue) {
    String val = queue.poll();
    if (val.equals("null"))
      return null;
    TreeNode node = new TreeNode(Integer.parseInt(val));
    node.left = build(queue);
    node.right = build(queue);
    return node;
  }
}
