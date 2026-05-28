package java.Binary_Search;

public class Capacity_to_Ship_Packages {
  public int shipWithinDays(int[] weights, int days) {
    int left = 0;
    int right = 0;

    for (int w : weights) {
      left = Math.max(left, w);
      right += w;
    }

    int ans = right;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (possible(weights, days, mid)) {
        ans = mid;
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return ans;
  }

  boolean possible(int[] weights, int days, int capacity) {
    int current = 0;
    int required = 1;

    for (int weight : weights) {
      if (current + weight > capacity) {
        required++;
        current = 0;
      }
      current += weight;
    }
    return required <= days;
  }
}
