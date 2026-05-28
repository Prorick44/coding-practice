package java.Trie;

public class Word_Dictionary {
  TrieNode root;

  public Word_Dictionary() {
    root = new TrieNode();
  }

  public void addWord(String word) {
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

  public boolean search(String word) {
    return dfs(word, 0, root);
  }

  boolean dfs(String word, int index, TrieNode node) {
    if (index == word.length()) {
      return node.isEnd;
    }

    char c = word.charAt(index);
    if (c == '.') {
      for (TrieNode child : node.children) {
        if (child != null && dfs(word, index + 1, child)) {
          return true;
        }
      }
      return false;
    }
    int idx = c - 'a';
    if (node.children[idx] == null) {
      return false;
    }
    return dfs(word, index + 1, node.children[idx]);
  }
}
