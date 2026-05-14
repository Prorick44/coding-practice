package java.Recursion_Backtracking;

import java.util.*;

public class Combination_Sum {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<>();
    backtrack(0, target, candidates, new ArrayList<>(), result);
    return result;
  }

  void backtrack(int index, int target, int[] candidates, List<Integer> current, List<List<Integer>> result) {
    if (target == 0) {
      result.add(new ArrayList<>(current));
      return;
    }
    if (target < 0)
      return;
    for (int i = index; i < candidates.length; i++) {
      current.add(candidates[i]);
      backtrack(i, target - candidates[i], candidates, current, result);
      current.remove(current.size() - 1);
    }
  }
}
