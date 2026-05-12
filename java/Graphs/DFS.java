package java.Graphs; // Depth First Search

import java.util.*;

public class DFS {
  public List<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
    List<Integer> result = new ArrayList<>();
    boolean[] visited = new boolean[V];
    dfs(0, adj, visited, result);
    return result;
  }

  void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, List<Integer> result) {
    visited[node] = true;
    result.add(node);
    for (int neighbor : adj.get(node)) {
      if (!visited[neighbor]) {
        dfs(neighbor, adj, visited, result);
      }
    }
  }
}
