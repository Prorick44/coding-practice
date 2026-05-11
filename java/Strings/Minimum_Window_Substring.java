package java.Strings;

import java.util.*;

public class Minimum_Window_Substring {
  public String nimWindow(String s, String t) {
    if (s.length() < t.length())
      return "";
    HashMap<Character, Integer> map = new HashMap<>();
    for (char c : t.toCharArray())
      map.put(c, map.getOrDefault(c, 0) + 1);
    int left = 0;
    int count = 0;
    int minLen = Integer.MAX_VALUE;
    int start = 0;
    for (int right = 0; right < s.length(); right++) {
      char c = s.charAt(right);
      if (map.containsKey(c)) {
        map.put(c, map.get(c) - 1);
        if (map.get(c) >= 0)
          count++;
      }
      while (count == t.length()) {
        if (right - left + 1 < minLen) {
          minLen = right - left + 1;
          start = left;
        }
        char leftChar = s.charAt(left);
        if (map.containsKey(leftChar)) {
          map.put(leftChar, map.get(leftChar) + 1);
          if (map.get(leftChar) > 0)
            count--;
        }
        left++;
      }
    }
    return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
  }
}
