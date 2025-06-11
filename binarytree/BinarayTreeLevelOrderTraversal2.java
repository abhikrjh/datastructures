package binarytree;

/*
Given the root of a binary tree, return the bottom-up level order traversal of its nodes' values. (i.e., from left to right, level by level from leaf to root).

Input: root = [3,9,20,null,null,15,7]
Output: [[15,7],[9,20],[3]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarayTreeLevelOrderTraversal2 {

    private static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {

            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {

            int levelSize = queue.size();

            List<Integer> currentLevelList = new ArrayList<>(levelSize);

            for (int i = 0; i < levelSize; i++) {

                TreeNode currentNode = queue.poll();

                currentLevelList.add(currentNode.val);

                if (currentNode.left != null) {

                    queue.offer(currentNode.left);
                }

                if (currentNode.right != null) {

                    queue.offer(currentNode.right);
                }
            }

            result.add(0, currentLevelList);

            // The ArrayList.add(index, value) method in Java inserts a specified element at a specific index within the ArrayList.
            // This operation shifts existing elements to the right, increasing the list's size by one.
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

        List<List<Integer>> result = levelOrder(root);

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

        List<List<Integer>> lists = levelOrder(root1);

        print(lists);


    }

}
