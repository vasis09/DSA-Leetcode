class Solution {
    class Node {
        int max;
        int prefixLen;
        int suffixLen;
        char prefixChar;
        char suffixChar;
        int segLen;

        Node(char c) {
            this.max = 1;
            this.prefixLen = 1;
            this.suffixLen = 1;
            this.prefixChar = c;
            this.suffixChar = c;
            this.segLen = 1;
        }

        Node() {}
    }

    private Node[] tree;
    private char[] chars;

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        int n = s.length();
        this.chars = s.toCharArray();
        this.tree = new Node[4 * n];

        // Build segment tree
        build(0, 0, n - 1);

        int k = queryIndices.length;
        int[] result = new int[k];

        // Process queries
        for (int i = 0; i < k; i++) {
            int idx = queryIndices[i];
            char ch = queryCharacters.charAt(i);

            update(0, 0, n - 1, idx, ch);
            result[i] = tree[0].max; // Root node holds the global maximum
        }

        return result;
    }

    private Node merge(Node left, Node right) {
        Node res = new Node();
        res.segLen = left.segLen + right.segLen;
        res.prefixChar = left.prefixChar;
        res.suffixChar = right.suffixChar;

        // Base prefix and suffix lengths from children
        res.prefixLen = left.prefixLen;
        res.suffixLen = right.suffixLen;

        // Base max length from children
        res.max = Math.max(left.max, right.max);

        // Check if boundary characters can be merged
        if (left.suffixChar == right.prefixChar) {
            int mergedLen = left.suffixLen + right.prefixLen;
            res.max = Math.max(res.max, mergedLen);

            // Extend prefix length if left segment is fully uniform
            if (left.prefixLen == left.segLen) {
                res.prefixLen = left.segLen + right.prefixLen;
            }

            // Extend suffix length if right segment is fully uniform
            if (right.suffixLen == right.segLen) {
                res.suffixLen = right.segLen + left.suffixLen;
            }
        }

        return res;
    }

    private void build(int nodeIdx, int start, int end) {
        if (start == end) {
            tree[nodeIdx] = new Node(chars[start]);
            return;
        }

        int mid = start + (end - start) / 2;
        int leftChild = 2 * nodeIdx + 1;
        int rightChild = 2 * nodeIdx + 2;

        build(leftChild, start, mid);
        build(rightChild, mid + 1, end);

        tree[nodeIdx] = merge(tree[leftChild], tree[rightChild]);
    }

    private void update(int nodeIdx, int start, int end, int targetIdx, char newChar) {
        if (start == end) {
            chars[targetIdx] = newChar;
            tree[nodeIdx] = new Node(newChar);
            return;
        }

        int mid = start + (end - start) / 2;
        int leftChild = 2 * nodeIdx + 1;
        int rightChild = 2 * nodeIdx + 2;

        if (targetIdx <= mid) {
            update(leftChild, start, mid, targetIdx, newChar);
        } else {
            update(rightChild, mid + 1, end, targetIdx, newChar);
        }

        tree[nodeIdx] = merge(tree[leftChild], tree[rightChild]);
    }
}