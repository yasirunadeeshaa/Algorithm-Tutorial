import java.util.Random;

import java.util.Random;

public class BinarySearchTree1 {
    public static class TreeNode {
        public int data;
        public TreeNode leftChild, rightChild, parent;

        public TreeNode(int d) {
            data = d;
            leftChild = null;
            rightChild = null;
            parent = null;
        }

        public void setLeftChild(TreeNode n) {
            leftChild = n;
            if (n != null) {
                n.parent = this;
            }
        }

        public void setRightChild(TreeNode n) {
            rightChild = n;
            if (n != null) {
                n.parent = this;
            }
        }
    }

    private TreeNode root;

    public TreeNode find(int findMe) {
        TreeNode n = root;
        while (n != null) {
            if (n.data == findMe)
                return n;
            if (n.data < findMe)
                n = n.rightChild;
            else
                n = n.leftChild;
        }
        return null;
    }

    public void output() {
        inOrderTraversal(root);
        System.out.println();
    }

    private void inOrderTraversal(TreeNode node) {
        if (node != null) {
            inOrderTraversal(node.leftChild);
            System.out.print(node.data + " ");
            inOrderTraversal(node.rightChild);
        }
    }

    public void insert(int value) {
        if (root == null) {
            root = new TreeNode(value);
        } else {
            insertBelow(root, value);
        }
    }

    private void insertBelow(TreeNode node, int value) {
        if (value < node.data) {
            if (node.leftChild == null) {
                node.setLeftChild(new TreeNode(value));
            } else {
                insertBelow(node.leftChild, value);
            }
        } else {
            if (node.rightChild == null) {
                node.setRightChild(new TreeNode(value));
            } else {
                insertBelow(node.rightChild, value);
            }
        }
    }

    public void remove(int value) {
        TreeNode nodeToRemove = find(value);
        if (nodeToRemove == null) return;

        if (nodeToRemove.leftChild == null) {
            replaceNode(nodeToRemove, nodeToRemove.rightChild);
        } else if (nodeToRemove.rightChild == null) {
            replaceNode(nodeToRemove, nodeToRemove.leftChild);
        } else {
            TreeNode maxNode = nodeToRemove.leftChild;
            while (maxNode.rightChild != null) {
                maxNode = maxNode.rightChild;
            }
            nodeToRemove.data = maxNode.data;
            replaceNode(maxNode, maxNode.leftChild);
        }
    }

    private void replaceNode(TreeNode node, TreeNode replacement) {
        TreeNode parent = node.parent;
        if (parent == null) {
            root = replacement;
            if (root != null)
                root.parent = null;
        } else if (node == parent.leftChild) {
            parent.setLeftChild(replacement);
        } else {
            parent.setRightChild(replacement);
        }
    }

    public static int[] randomValues(int howMany) {
        int[] result = new int[howMany];
        Random random = new Random();
        for (int i = 0; i < howMany; i++)
            result[i] = random.nextInt() % (10 * howMany);
        return result;
    }

    public void insertAll(int[] values, boolean printResults) {
        for (int value : values) {
            insert(value);
            if (printResults)
                output();
        }
    }

    public void removeAll(int[] values, boolean printResults) {
        for (int value : values) {
            remove(value);
            if (printResults)
                output();
        }
    }

    public static void main(String[] args) {
        int numValues = 10;
        boolean printResults = true;

        BinarySearchTree t = new BinarySearchTree();
        int[] a = randomValues(numValues);
        if (printResults) {
            System.out.print("Input values: ");
            for (int i : a)
                System.out.print(i + " ");
            System.out.println();
        }
        long start = System.currentTimeMillis();
        t.insertAll(a, printResults);
        t.removeAll(a, printResults);
        long now = System.currentTimeMillis();
        double elapsed = (now - start) / 1000.0;
        System.out.println();
        System.out.println("Elapsed time = " + elapsed + " seconds");
    }
}
