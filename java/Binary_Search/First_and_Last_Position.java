package java.Binary_Search;

public class First_and_Last_Position {
  public int[] searchRange(int[] nums, int target) {
    return new int[] {
        first(nums, target), last(nums, target)
    };
  }

  int first(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;

    int ans = -1;

    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        ans = mid;
        right = mid - 1;
      } else if (nums[mid] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return ans;
  }

  int last(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    int ans = -1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        ans = mid;
        left = mid + 1;
      } else if (nums[mid] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return ans;
  }
}
