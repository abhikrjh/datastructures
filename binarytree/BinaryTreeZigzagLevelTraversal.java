package binarytree;


import binarytree.common.*;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeZigzagLevelTraversal {


    private static List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {

            return result;
        }

        Deque<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        boolean reverse = false;

        while (!queue.isEmpty()) {

            int levelSize = queue.size();

            List<Integer> currentLevelList = new ArrayList<>(levelSize);

            for (int i = 0; i < levelSize; i++) {

                if (!reverse) {

                    TreeNode currentNode = queue.pollFirst();

                    currentLevelList.add(currentNode.val);

                    if (currentNode.left != null) {

                        queue.offerLast(currentNode.left);
                    }

                    if (currentNode.right != null) {

                        queue.offerLast(currentNode.right);
                    }
                } else {

                    TreeNode currentNode = queue.pollLast();

                    currentLevelList.add(currentNode.val);

                    // Add children in reverse order for correct zigzag
                    if (currentNode.right != null) {

                        queue.offerFirst(currentNode.right);
                    }

                    if (currentNode.left != null) {

                        queue.offerFirst(currentNode.left);
                    }

                }
            }

            result.add(currentLevelList);
            reverse = !reverse;
        }

        return result;
    }

    private static void print(List<List<Integer>> result) {

        int count = 0;

        for (List<Integer> level : result) {

            System.out.print(level);

            count++;
            if (count < result.size()) {
                System.out.print(", ");
            }
        }
    }

    public static void main(String[] args) {

        // Constructing the tree: [3,9,20,null,null,15,7]

        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> result = zigzagLevelOrder(root);

        print(result);

        System.out.println();
        System.out.println("---------------------------------------------------");

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);

        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);

        root1.right.left = new TreeNode(6);
        root1.right.right = new TreeNode(7);

        List<List<Integer>> lists = zigzagLevelOrder(root1);

        print(lists);
    }
}
