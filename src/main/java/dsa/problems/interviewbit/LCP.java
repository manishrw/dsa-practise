/*
* InterviewBit: Longest Common Prefix
* Reference: https://www.interviewbit.com/problems/longest-common-prefix/
*/
package dsa.problems.interviewbit;

import java.util.HashMap;
import java.util.Map;

public class LCP {
    private boolean debug = true;

    public String longestCommonPrefix(String[] A) {
        TrieNode head = new TrieNode('*');
        int max = 0;
        for (String s : A) {
            TrieNode node = head;
            for (char c : s.toCharArray()) {
                if (node.isChild(c)) {
                    node = node.getChild(c);
                    node.incCount();
                } else {
                    node.addChild(c);
                    node = node.getChild(c);
                }
                if (node.getCount() == A.length && max < node.getHeight()) {
                    max = node.getHeight();
                    if (debug) System.out.println("\nMaxLength changed to " + max + "\n");
                } 
                if (debug) System.out.println("Char: " + c + ", Node: " + node + ", Max: " + max);
            }
        }
        return A[0].substring(0, max);
    }
}

class TrieNode {
    private Map<Character, TrieNode> children;
    private Character value;
    private Integer count;
    private Integer height;
    
    public TrieNode(Character value, int count, int height) {
        this.value = value;
        this.count = count;
        this.height = height;
        this.children = new HashMap<>();
    }
    
    public TrieNode(Character value) {
        this.value = value;
        this.count = 1;
        this.height = 0;
        this.children = new HashMap<>();
    }

    public boolean isChild(Character value) {
        return children.containsKey(value);
    }

    public TrieNode getChild(Character value) {
        return children.get(value);
    }

    public void addChild(Character value) {
        this.children.put(value, new TrieNode(value, 1, this.height + 1));
    }

    public int getCount() {
        return count;
    }

    public void incCount() {
        this.count++;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "{" +
            "right='" + value + "'" +
            ", height='" + height + "'" +
            ", count='" + count + "'" +
            ", children='" + children + "'" +
            "}";
    }
    
}
