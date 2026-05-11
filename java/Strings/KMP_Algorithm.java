package java.Strings;

public class KMP_Algorithm {
  public void computeLPS(String pattern, int[] lps) {

    int len = 0;
    int i = 1;

    while (i < pattern.length()) {

      if (pattern.charAt(i) == pattern.charAt(len)) {
        len++;
        lps[i] = len;
        i++;
      } else {

        if (len != 0) {
          len = lps[len - 1];
        } else {
          lps[i] = 0;
          i++;
        }
      }
    }
  }

  public int strStr(String text, String pattern) {

    int[] lps = new int[pattern.length()];

    computeLPS(pattern, lps);

    int i = 0;
    int j = 0;

    while (i < text.length()) {

      if (text.charAt(i) == pattern.charAt(j)) {
        i++;
        j++;
      }

      if (j == pattern.length()) {
        return i - j;
      } else if (i < text.length() &&
          text.charAt(i) != pattern.charAt(j)) {

        if (j != 0)
          j = lps[j - 1];
        else
          i++;
      }
    }

    return -1;
  }
}
