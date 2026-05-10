package java.Arrays;

public class Kadane_Algotithm {
  public int kadane(int[] arr) {
    int maxSum = arr[0];
    int current = arr[0];

    for (int i = 1; i < arr.length; i++) {
      current = Math.max(arr[i], current + arr[i]);
      maxSum = Math.max(maxSum, current);
    }

    return maxSum;
  }
}
