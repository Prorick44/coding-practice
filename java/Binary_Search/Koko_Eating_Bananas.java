package java.Binary_Search;

public class Koko_Eating_Bananas {
  public int minEatingSpeed(int[] piles, int h) {
    int left = 1;
    int right = 0;

    for (int pile : piles) {
      right = Math.max(right, pile);
    }

    int ans = right;

    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (canEat(piles, h, mid)) {
        ans = mid;
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return ans;
  }

  boolean canEat(int[] piles, int h, int speed) {
    int hours = 0;
    for (int pile : piles) {
      hours += Math.ceil((double) pile / speed);
    }
    return hours <= h;
  }
}
