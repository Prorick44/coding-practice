package java.Graphs;

import java.util.*;

class Pair {
  int node;
  int distance;

  Pair(int node, int distance) {
    this.node = node;
    this.distance = distance;
  }
}

public class Dijkstra_Algorithm {
  public int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
    PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);
    int[] dist = new int[V];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[S] = 0;
    pq.offer(new Pair(S, 0));
    while (!pq.isEmpty()) {
      Pair current = pq.poll();
      int node = current.node;
      int distance = current.distance;
      for (ArrayList<Integer> edge : adj.get(node)) {
        int adjNode = edge.get(0);
        int weight = edge.get(1);
        if (distance + weight < dist[adjNode]) {
          dist[adjNode] = distance + weight;
          pq.offer(new Pair(adjNode, dist[adjNode]));
        }
      }
    }
    return dist;
  }
}
