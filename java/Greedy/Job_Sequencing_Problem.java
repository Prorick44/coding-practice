package java.Greedy;

import java.util.*;

class Job {
  int id;
  int deadline;
  int profit;

  Job(int id, int deadline, int profit) {
    this.id = id;
    this.deadline = deadline;
    this.profit = profit;
  }
}

public class Job_Sequencing_Problem {
  int[] jobScheduling(Job[] arr, int n) {
    Arrays.sort(arr, (a, b) -> b.profit - a.profit);
    int maxDeadline = 0;
    for (Job job : arr) {
      maxDeadline = Math.max(maxDeadline, job.deadline);
    }
    int[] slots = new int[maxDeadline + 1];
    Arrays.fill(slots, -1);
    int count = 0;
    int totalProfit = 0;
    for (Job job : arr) {
      for (int j = job.deadline; j > 0; j--) {
        if (slots[j] == -1) {
          slots[j] = job.id;
          count++;
          totalProfit += job.profit;
          break;
        }
      }
    }
    return new int[] {
        count, totalProfit
    };
  }
}
