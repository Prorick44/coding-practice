package java.Strings;

public class Rabin_Karp_Algorithm {
  public int rabinKarp(String text, String pattern) {
    int n = text.length();
    int m = pattern.length();

    int d = 256;
    int q = 101;

    int h = 1;

    for (int i = 0; i < m - 1; i++) {
      h = (h * d) % q;
    }

    int p = 0;
    int t = 0;

    for (int i = 0; i <= n - m; i++) {
      p = (d * p + pattern.charAt(i)) % q;
      t = (d * t + text.charAt(i)) % q;
    }

    for (int i = 0; i <= n - m; i++) {
      if (p == t) {
        int j;
        for (j = 0; j < m; j++) {
          if (text.charAt(i + j) != pattern.charAt(j))
            break;
        }
        if (j == m)
          return i;
      }
      if (i < n - m) {
        t = (d * (t - text.charAt(i) * h) + text.charAt(i + m)) % q;
        if (t < 0)
          t += q;
      }
    }
    return -1;
  }
}
