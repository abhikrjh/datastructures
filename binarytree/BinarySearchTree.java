package binarytree;

public class BinarySearchTree {


    public class Node {

        int value;
        int height;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }

    }

    private Node root;

    public Node root() {

        return root;
    }

    private int height(Node node) {

        if (node == null) {
            return -1;
        }

        return node.height;
    }

    public boolean isEmpty() {

        return root == null;
    }

    public boolean balancedBST(Node node) {

        if (node == null) {

            return true;
        }

        return Math.abs(height(node.left) - height(node.right)) <= 1
                && balancedBST(node.left)
                && balancedBST(node.right);
    }

    public void display() {

        display(root, "Root Node is : ");
    }

    private void display(Node node, String details) {

        if (node == null) {
            return;
        }

        System.out.println(details + node.value);

        display(node.left, "Left child of " + node.value + " : ");
        display(node.right, "Right child of " + node.value + " : ");
    }

    private void insert(int value) {

        this.root = insert(root, value);
    }

    private Node insert(Node node, int value) {

        if (node == null) {

            node = new Node(value);

            return node;
        }

        if (value < node.value) {

            node.left = insert(node.left, value);
        }

        if (value > node.value) {

            node.right = insert(node.right, value);
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;

        return node;
    }

    public void populate(int[] nums) {

        for (int num : nums) {

            insert(num);
        }
    }

    /*

    For a sorted nums input, populateSorted builds a balanced BST.
    It recursively picks the middle element as the root of each subtree.
    The array is parted into left and right subarrays: (start to mid) and (mid+1 to end).
    This avoids overlap, ensures termination, and results in a balanced structure.

    */
    public void populateSorted(int[] nums) {

        populateSorted(nums, 0, nums.length);
    }

    private void populateSorted(int[] nums, int start, int end) {

        if (start >= end) { // base condition
            return;
        }

        int mid = start + (end - start) / 2;

        insert(nums[mid]);

        populateSorted(nums, start, mid - 1);
        populateSorted(nums, mid, end);
    }


    private void preOrderTraversal(Node node) {

        if (node == null) {
            return;
        }

        System.out.println(node.value + " -> ");

        preOrderTraversal(node.left);

        preOrderTraversal(node.right);
    }

    private void inOrderTraversal(Node node) {

        if (node == null) {
            return;
        }

        inOrderTraversal(node.left);

        System.out.println(node.value + " -> ");

        inOrderTraversal(node.right);
    }

    private void postOrderTraversal(Node node) {

        if (node == null) {
            return;
        }

        postOrderTraversal(node.left);
        postOrderTraversal(node.right);

        System.out.println(node.value + " -> ");
    }


}
