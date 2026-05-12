package java.Graphs;

import java.util.*;

public class Topological_Sort {
  public int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
    int[] indegree = new int[V];
    for (int i = 0; i < V; i++) {
      for (int neighbor : adj.get(i)) {
        indegree[neighbor]++;
      }
    }
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < V; i++) {
      if (indegree[i] == 0) {
        queue.offer(i);
      }
    }
    int[] result = new int[V];
    int index = 0;
    while (!queue.isEmpty()) {
      int node = queue.poll();
      result[index++] = node;
      for (int neighbor : adj.get(node)) {
        indegree[neighbor]--;
        if (indegree[neighbor] == 0) {
          queue.offer(neighbor);
        }
      }
    }
    return result;
  }
}
