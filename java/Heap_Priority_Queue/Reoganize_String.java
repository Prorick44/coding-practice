package java.Heap_Priority_Queue;

import java.util.HashMap;
import java.util.PriorityQueue;

public class Reoganize_String {
  public String reorganizeString(String s) {
    HashMap<Character, Integer> map = new HashMap<>();
    for (char c : s.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }
    PriorityQueue<Character> pq = new PriorityQueue<>(new PriorityQueue<>((a, b) -> map.get(b) - map.get(a)));
    pq.addAll(map.keySet());
    StringBuilder sb = new StringBuilder();
    while (pq.size() > 1) {
      char first = pq.poll();
      char second = pq.poll();
      sb.append(first);
      sb.append(second);
      map.put(first, map.get(first) - 1);
      map.put(second, map.get(second) - 1);
      if (map.get(first) > 0)
        pq.offer(first);
      if (map.get(second) > 0)
        pq.offer(second);
    }

    if (!pq.isEmpty()) {
      char last = pq.poll();
      if (map.get(last) > 1)
        return "";
      sb.append(last);
    }
    return sb.toString();
  }
}
