package java.Trie;

class TrieNode {
  TrieNode[] children = new TrieNode[26];
  int count;
}

public class Prefix_Count {
  TrieNode root = new TrieNode();

  public int prefixCount(String[] words, String pref) {
    for (String word : words) {
      insert(word);
    }
    return search(pref);
  }

  void insert(String word) {
    TrieNode node = root;
    for (char c : word.toCharArray()) {
      int index = c - 'a';
      if (node.children[index] == null) {
        node.children[index] = new TrieNode();
      }
      node = node.children[index];
      node.count++;
    }
  }

  int search(String pref) {
    TrieNode node = root;
    for (char c : pref.toCharArray()) {
      int index = c - 'a';
      if (node.children[index] == null) {
        return 0;
      }
      node = node.children[index];
    }
    return node.count;
  }
}
