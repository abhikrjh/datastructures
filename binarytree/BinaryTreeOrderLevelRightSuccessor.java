package binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeOrderLevelRightSuccessor {

    private static TreeNode findSuccessor(TreeNode root, TreeNode node) {

        if (root == null) {

            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {

            TreeNode currentNode = queue.poll();

            if (currentNode.left != null) {

                queue.offer(currentNode.left);
            }

            if (currentNode.right != null) {

                queue.offer(currentNode.right);
            }

            if (currentNode.val == node.val) {

                break;
            }
        }

        return queue.peek();
    }

    private static void print(TreeNode node) {

        if (node != null) {

            System.out.println(node.val);
        } else {

            System.out.println("null");
        }
    }

    public static void main(String[] args) {

        // Constructing the tree: [3,9,20,null,null,15,7]

        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        TreeNode node = new TreeNode(15);

        TreeNode treeNode = findSuccessor(root, node);

        print(treeNode);
    }
}
