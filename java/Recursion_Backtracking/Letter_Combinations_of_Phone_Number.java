package java.Recursion_Backtracking;

import java.util.*;

public class Letter_Combinations_of_Phone_Number {
  String[] map = {
      "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
  };

  public List<String> letterCombinations(String digits) {
    List<String> result = new ArrayList<>();
    if (digits.length() == 0)
      return result;
    backtrack("", digits, 0, result);
    return result;
  }

  void backtrack(String current, String digits, int index, List<String> result) {
    if (index == digits.length()) {
      result.add(current);
      return;
    }
    String letters = map[digits.charAt(index) - '0'];
    for (char c : letters.toCharArray()) {
      backtrack(current + c, digits, index + 1, result);
    }
  }
}
