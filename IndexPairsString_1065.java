import java.util.*;

public class IndexPairsString_1065 {
    class Solution {
        public int[][] indexPairs(String text, String[] words) {
            List<int[]> result = new LinkedList<>();
            Trie trie = new Trie();

            for(String word: words) // Insert all the words in Trie.
                trie.insert(word);

            for(int startIndex = 0; startIndex < text.length(); ++startIndex) { // Start storing the right indices
                int endIndex = startIndex;
                TrieNode currNode = trie.getRoot();

                while(endIndex < text.length()) {
                    char ch = text.charAt(endIndex);
                    if(currNode.children.get(ch) == null) //invalid
                        break;
                    if(currNode.children.get(ch).wordEnd) //valid
                        result.add(new int[] { startIndex, endIndex });

                    currNode = currNode.children.get(ch);
                    endIndex++;
                }
            }

            return result.toArray(new int[result.size()][2]);
        }

        class Trie {
            private TrieNode root;

            public Trie() {  root = new TrieNode();  }

            public TrieNode getRoot() {  return root;  }

            public void insert(String word) {
                TrieNode currNode = root;
                for(Character ch: word.toCharArray()) {
                    currNode.children.put(ch, currNode.children.getOrDefault(ch, new TrieNode()));
                    currNode = currNode.children.get(ch);
                }
                currNode.wordEnd = true;
            }
        }

        class TrieNode {
            Map<Character, TrieNode> children;
            boolean wordEnd;

            public TrieNode() {
                children = new HashMap<>();
                wordEnd = false;
            }
        }
    }
}
