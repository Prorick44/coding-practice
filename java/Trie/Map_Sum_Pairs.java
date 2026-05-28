package java.Trie;

import java.util.*;

public class Map_Sum_Pairs {
  HashMap<String, Integer> map;
  TrieNode root;

  class TrieNode {
    TrieNode[] children = new TrieNode[26];
    int sum;
  }

  public Map_Sum_Pairs() {
    map = new HashMap<>();
    root = new TrieNode();
  }

  public void insert(String key, int val) {
    int diff = val - map.getOrDefault(key, 0);
    map.put(key, val);
    TrieNode node = root;
    for (char c : key.toCharArray()) {
      int index = c - 'a';
      if (node.children[index] == null) {
        node.children[index] = new TrieNode();
      }
      node = node.children[index];
      node.sum += diff;
    }
  }

  public int sum(String prefix) {
    TrieNode node = root;
    for (char c : prefix.toCharArray()) {
      int index = c - 'a';
      if (node.children[index] == null) {
        return 0;
      }
      node = node.children[index];
    }
    return node.sum;
  }
}
