package java.Heap_Priority_Queue;

import java.util.*;

public class Task_SCheduler {
  public int leastInterval(char[] tasks, int n) {
    int[] freq = new int[26];
    for (char c : tasks) {
      freq[c - 'A']++;
    }
    Arrays.sort(freq);
    int maxFreq = freq[25] - 1;
    int idle = maxFreq * n;
    for (int i = 24; i >= 0 && freq[i] > 0; i--) {
      idle -= Math.min(maxFreq, freq[i]);
    }
    return idle < 0 ? tasks.length : tasks.length + idle;
  }
}
