package java.Trie;

import java.util.*;

class TrieNode {
  TrieNode[] children = new TrieNode[26];
  boolean isEnd;
}

public class Phone_Directory {
  TrieNode root = new TrieNode();

  public List<List<String>> displayContacts(int n, String[] contact, String s) {
    for (String word : contact) {
      insert(word);
    }
    List<List<String>> result = new ArrayList<>();
    String prefix = "";
    for (char c : s.toCharArray()) {
      prefix += c;
      List<String> list = new ArrayList<>();
      TrieNode node = searchNode(prefix);

      if (node != null) {
        dfs(node, prefix, list);
      }

      if (list.isEmpty()) {
        list.add("0");
      }
      result.add(list);
    }
    return result;
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

  TrieNode searchNode(String prefix) {
    TrieNode node = root;
    for (char c : prefix.toCharArray()) {
      int index = c - 'a';
      if (node.children[index] == null) {
        return null;
      }
      node = node.children[index];
    }
    return node;
  }

  void dfs(TrieNode node, String word, List<String> list) {
    if (node.isEnd) {
      list.add(word);
    }

    for (char c = 'a'; c <= 'z'; c++) {
      int index = c - 'a';
      if (node.children[index] != null) {
        dfs(node.children[index], word + c, list);
      }
    }
  }
}
