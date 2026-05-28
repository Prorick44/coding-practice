package java.Binary_Search;

import java.util.*;

public class Aggressive_Cows {
  public int aggressiveCows(int[] stalls, int k) {
    Arrays.sort(stalls);
    int left = 1;
    int right = stalls[stalls.length - 1] - stalls[0];

    int ans = 0;

    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (canPlace(stalls, k, mid)) {
        ans = mid;
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return ans;
  }

  boolean canPlace(int[] stalls, int cows, int dist) {
    int count = 1;
    int last = stalls[0];
    for (int i = 1; i < stalls.length; i++) {
      if (stalls[i] - last >= dist) {
        count++;
        last = stalls[i];
      }
    }
    return count >= cows;
  }
}
