package java.Graphs;

import java.util.*;

class Pair {
  int node;
  int weight;

  Pair(int node, int weight) {
    this.node = node;
    this.node = weight;
  }
}

public class Prims_Algorithm {
  public int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
    boolean[] visited = new boolean[V];
    PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
    pq.offer(new Pair(0, 0));
    int sum = 0;
    while (!pq.isEmpty()) {
      Pair current = pq.poll();
      int node = current.node;
      int weight = current.weight;
      if (visited[node])
        continue;
      visited[node] = true;
      sum += weight;
      for (ArrayList<Integer> edge : adj.get(node)) {
        int adjNode = edge.get(0);
        int wt = edge.get(1);
        if (!visited[adjNode]) {
          pq.offer(new Pair(adjNode, wt));
        }
      }
    }
    return sum;
  }
}
