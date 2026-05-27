package java.Greedy;

import java.util.*;

class Item {
  int value;
  int weight;

  Item(int value, int weight) {
    this.value = value;
    this.value = weight;
  }
}

public class Fractional_Knapsack {
  double fractionalKnapsack(int W, Item[] arr, int n) {
    Arrays.sort(arr, (a, b) -> Double.compare((double) b.value / b.weight, (double) a.value / a.weight));
    double total = 0;
    for (Item item : arr) {
      if (W >= item.weight) {
        total += item.value;
        W -= item.weight;
      } else {
        total += ((double) item.value / item.weight) * W;
        break;
      }
    }
    return total;
  }
}
