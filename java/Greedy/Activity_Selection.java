package java.Greedy;

import java.util.*;

class Activity {
  int start;
  int end;

  Activity(int start, int end) {
    this.start = start;
    this.end = end;
  }
}

public class Activity_Selection {
  public int activitySelection(int[] start, int[] end, int n) {
    List<Activity> list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      list.add(new Activity(start[i], end[i]));
    }
    Collections.sort(list, (a, b) -> a.end - b.end);
    int count = 1;
    int lastEnd = list.get(0).end;
    for (int i = 1; i < n; i++) {
      if (list.get(i).start > lastEnd) {
        count++;
        lastEnd = list.get(i).end;
      }
    }
    return count;
  }
}
