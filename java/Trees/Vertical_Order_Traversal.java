package java.Trees;

import java.util.*;

class TreeNode {
  int val;
  TreeNode left, right;
}

class Pair {
  TreeNode node;
  int col;

  Pair(TreeNode node, int col) {
    this.node = node;
    this.col = col;
  }
}

public class Vertical_Order_Traversal {
  public List<List<Integer>> verticalTraversal(TreeNode root) {
    TreeMap<Integer, List<Integer>> map = new TreeMap<>();
    Queue<Pair> queue = new LinkedList<>();
    queue.offer(new Pair(root, 0));
    while (!queue.isEmpty()) {
      Pair current = queue.poll();
      map.putIfAbsent(current.col, new ArrayList<>());
      map.get(current.col).add(current.node.val);
      if (current.node.left != null) {
        queue.offer(new Pair(current.node.left, current.col - 1));
      }
      if (current.node.right != null) {
        queue.offer(new Pair(current.node.right, current.col + 1));
      }
    }
    return new ArrayList<>(map.values());
  }
}
