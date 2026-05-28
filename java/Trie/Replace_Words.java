package java.Trie;

import java.util.*;

class TrieNode {
  TrieNode[] children = new TrieNode[26];
  boolean isEnd;
}

public class Replace_Words {
  TrieNode root = new TrieNode();

  public String replaceWords(List<String> dictionary, String sentence) {
    for (String word : dictionary) {
      insert(word);
    }
    StringBuilder sb = new StringBuilder();
    String[] words = sentence.split(" ");
    for (String word : words) {
      sb.append(search(word)).append(" ");
    }
    return sb.toString().trim();
  }

  void insert(String word) {
    TrieNode node = root;
    for (char c : word.toCharArray()) {
      int index = c - 'a';
      if (node.children[index] == null) {
        node.children[index] = new TrieNode();
      }
      node = node.children[index];
    }
    node.isEnd = true;
  }

  String search(String word) {
    TrieNode node = root;
    StringBuilder sb = new StringBuilder();
    for (char c : word.toCharArray()) {
      int index = c - 'a';
      if (node.children[index] == null) {
        return word;
      }
      sb.append(c);
      node = node.children[index];
      if (node.isEnd) {
        return sb.toString();
      }
    }
    return word;
  }
}
