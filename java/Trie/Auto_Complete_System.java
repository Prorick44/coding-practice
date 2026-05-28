package java.Trie;

import java.util.*;

class TrieNode {
  HashMap<Character, TrieNode> children = new HashMap<>();
  List<String> words = new ArrayList<>();
}

public class Auto_Complete_System {
  TrieNode root;

  public Auto_Complete_System(String[] sentences) {
    root = new TrieNode();
    for (String sentence : sentences) {
      insert(sentence);
    }
  }

  void insert(String word) {
    TrieNode node = root;
    for (char c : word.toCharArray()) {
      node.children.putIfAbsent(c, new TrieNode());
      node = node.children.get(c);
      node.words.add(word);
    }
  }

  public List<String> search(String prefix) {
    TrieNode node = root;
    for (char c : prefix.toCharArray()) {
      if (!node.children.containsKey(c)) {
        return new ArrayList<>();
      }
      node = node.children.get(c);
    }
    return node.words;
  }
}
