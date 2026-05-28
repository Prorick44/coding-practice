package java.Trie;

import java.util.*;

public class Longest_Word_in_Dictionary {
  public String longestWord(String[] words) {
    Arrays.sort(words);
    HashSet<String> set = new HashSet<>();
    String result = "";
    for (String word : words) {
      if (word.length() == 1 || set.contains(word.substring(0, word.length() - 1))) {
        set.add(word);
        if (word.length() > result.length()) {
          result = word;
        }
      }
    }
    return result;
  }
}
