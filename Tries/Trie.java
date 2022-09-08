package Tries;

import java.util.ArrayList;

class TrieNode {
    char data;
    boolean isTerminal;
    TrieNode children[];
    int childCount;

    public TrieNode(char data) {
        this.data = data;
        this.isTerminal = false;
        this.children = new TrieNode[26];
        childCount = 0;
    }
}
public class Trie {

    private TrieNode root;

    public int count;
    public Trie() {
        root = new TrieNode('\0');
        count = 0;
    }

    private boolean addHelper(TrieNode root, String word) {
        if (word.length() == 0) {
            root.isTerminal = true;
            return true;
        }
        int childIndex = word.charAt(0) - 'A';
        TrieNode child = root.children[childIndex];
        if (child == null) {
            child = new TrieNode(word.charAt(0));
            root.children[childIndex] = child;
            root.childCount++;
        }

        return addHelper(child, word.substring(1));
    }

    public void add(String word) {

        if (addHelper(root, word)) {
            this.count++;
        }
    }

    public boolean search(String word) {

        return searchHelper(root, word);
    }

    private boolean searchHelper(TrieNode root, String word) {
        if (word.length() == 0) {
            return root.isTerminal;
        }
        int childIndex = word.charAt(0) - 'A';
        TrieNode child = root.children[childIndex];
        if (child == null) {
            return false;
        }
        return searchHelper(child, word.substring(1));
    }

    public void remove(String word) {
        removeHelper(root, word);
    }

    private void removeHelper(TrieNode root, String word) {
        if (word.length() == 0) {
            root.isTerminal = false;
            return;
        }
        int childIndex = word.charAt(0) - 'A';
        TrieNode child = root.children[childIndex];
        if (child == null) {
            return;
        }
        removeHelper(child, word.substring(1));
        if (!child.isTerminal && child.childCount == 0) {
            root.children[childIndex] = null;
            root.childCount--;
        }
    }

    public int countWords() {
        return count;
    }

    public boolean patternMatching(ArrayList<String> input, String pattern) {
        for (int i = 0; i < input.size(); i++) {
            String word = input.get(i);
            Trie suffixTrie = new Trie();
            for (int j = 0; j < word.length(); j++) {
                suffixTrie.add(word.substring(j));
            }
            if (suffixTrie.search(pattern)) {
                return true;
            }
        }
        return false;
    }
}
