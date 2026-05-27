package java.Greedy;

import java.util.*;

public class Assign_Cookies {
  public int findContentChildren(int[] g, int[] s) {
    Arrays.sort(g);
    Arrays.sort(s);

    int child = 0;
    int cookie = 0;

    while (child < g.length && cookie < s.length) {
      if (s[cookie] >= g[child]) {
        child++;
      }
      cookie++;
    }
    return child;
  }
}
