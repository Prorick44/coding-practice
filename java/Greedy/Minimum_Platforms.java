package java.Greedy;

import java.util.*;

public class Minimum_Platforms {
  static int findPlatform(int[] arr, int[] dep, int n) {
    Arrays.sort(arr);
    Arrays.sort(dep);

    int platforms = 1;
    int maxPlatforms = 1;

    int i = 1;
    int j = 0;

    while (i < n && j < n) {
      if (arr[i] <= dep[j]) {
        platforms++;
        i++;
      } else {
        platforms--;
        j++;
      }
      maxPlatforms = Math.max(maxPlatforms, platforms);
    }
    return maxPlatforms;
  }
}
