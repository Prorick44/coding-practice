package java.Binary_Search;

public class Allocate_Minimum_Pages {
  public int findPages(int[] arr, int n, int m) {
    if (m > n)
      return -1;

    int left = 0;
    int right = 0;

    for (int pages : arr) {
      left = Math.max(left, pages);
      right += pages;
    }

    int ans = right;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (isPossible(arr, m, mid)) {
        ans = mid;
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return ans;
  }

  boolean isPossible(int[] arr, int students, int maxPages) {
    int count = 1;
    int sum = 0;
    for (int pages : arr) {
      if (sum + pages > maxPages) {
        count++;
        sum = pages;
      } else {
        sum += pages;
      }
    }
    return count <= students;
  }
}
