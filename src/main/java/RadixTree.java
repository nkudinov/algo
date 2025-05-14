import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RadixTree {
    private static class Node {
        private Map<String, Node> children = new HashMap<>();
        private boolean isLeaf = false;
        private String value = null;

        public Node(String value) {
            this.value = value;
            this.isLeaf = true;
        }

        public Node() {
        }
    }

    private final Node root = new Node();

    public void insert(String key, String value) {
        insertRecursive(root, key, value);
    }

    private void insertRecursive(Node root, String key, String value) {
        if (key.isEmpty()) {
            root.isLeaf = true;
            root.value = value;
            return;
        }
        for (Map.Entry<String, Node> entry : new ArrayList<>(root.children.entrySet())) {
            String edgeLabel = entry.getKey();
            Node child = entry.getValue();

            int commonLen = commonPrefixLength(key, edgeLabel);
            if (commonLen == 0) continue;

            if (commonLen < edgeLabel.length()) {
                // Need to split the existing edge
                root.children.remove(edgeLabel);

                String commonPrefix = edgeLabel.substring(0, commonLen);
                String edgeSuffix = edgeLabel.substring(commonLen);
                String keySuffix = key.substring(commonLen);

                Node splitNode = new Node();
                root.children.put(commonPrefix, splitNode);

                // Reattach the old child to the split
                splitNode.children.put(edgeSuffix, child);

                // Add the new leaf or continue insertion
                if (keySuffix.isEmpty()) {
                    splitNode.isLeaf = true;
                    splitNode.value = value;
                } else {
                    insertRecursive(splitNode, keySuffix, value);
                }

                return;
            } else if (commonLen == edgeLabel.length()) {
                // edgeLabel fully matches the prefix of key
                String keySuffix = key.substring(commonLen);
                if (keySuffix.isEmpty()) {
                    // Exact match — update value
                    child.isLeaf = true;
                    child.value = value;
                } else {
                    insertRecursive(child, keySuffix, value);
                }
                return;
            }
        }

        // No common prefix with any existing edge
        root.children.put(key, new Node(value));
    }

    public String search(String key) {
        Node current = root;
        String remaining = key;

        while (!remaining.isEmpty()) {
            boolean found = false;
            for (Map.Entry<String, Node> entry : current.children.entrySet()) {
                String edge = entry.getKey();
                if (remaining.startsWith(edge)) {
                    current = entry.getValue();
                    remaining = remaining.substring(edge.length());
                    found = true;
                    break;
                }
            }

            if (!found) return null;
        }

        return current.isLeaf ? current.value : null;
    }

    private int commonPrefixLength(String a, String b) {
        int len = Math.min(a.length(), b.length());
        for (int i = 0; i < len; i++) {
            if (a.charAt(i) != b.charAt(i)) return i;
        }
        return len;
    }

    public static void main(String[] args) {
        RadixTree radix = new RadixTree();

        class TestCase {
            void check(String key, String expected) {
                String actual = radix.search(key);
                if ((expected == null && actual != null) ||
                        (expected != null && !expected.equals(actual))) {
                    System.out.println("❌ Test failed: key=\"" + key + "\" | expected=\"" + expected + "\", got=\"" + actual + "\"");
                } else {
                    System.out.println("✅ key=\"" + key + "\" | value=\"" + actual + "\"");
                }
            }
        }

        TestCase test = new TestCase();

        // Вставки
        radix.insert("slow", "v1");
        test.check("slow", "v1");
        radix.insert("slower", "v2");
        test.check("slower", "v2");
        radix.insert("slot", "v3");
        test.check("slot", "v3");
        radix.insert("slow", "v1_updated");
        test.check("slow", "v1_updated");
        radix.insert("s", "root_s");
        test.check("slow", "v1_updated");

        radix.insert("slowering", "v4");
        test.check("slow", "v1_updated");

        radix.insert("", "empty");
        test.check("slow", "v1_updated");

        radix.insert("apple", "fruit");
        test.check("slow", "v1_updated");

        radix.insert("app", "short");
        test.check("slow", "v1_updated");

        radix.insert("slowering", "v4_updated");
        test.check("slow", "v1_updated");

        radix.insert("banana", "yellow");

        // Проверки
        test.check("slow", "v1_updated");
        test.check("slower", "v2");
        test.check("slot", "v3");
        test.check("s", "root_s");
        test.check("slowering", "v4_updated");
        test.check("", "empty");
        test.check("apple", "fruit");
        test.check("app", "short");
        test.check("banana", "yellow");

        // Отрицательные случаи
        test.check("slug", null);
        test.check("slo", null);
        test.check("ban", null);
        test.check("missing", null);
    }
}
