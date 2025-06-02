package binarytree;

/*
Given the root of a binary tree, return the average value of the nodes on each level in the form of an array.
Answers within 10-5 of the actual answer will be accepted.

Input: root = [3,9,20,null,null,15,7]
Output: [3.00000,14.50000,11.00000]
Explanation: The average value of nodes on level 0 is 3, on level 1 is 14.5, and on level 2 is 11.
Hence return [3, 14.5, 11].

Input: root = [3,9,20,15,7]
Output: [3.00000,14.50000,11.00000]
*/

import binarytree.common.TreeNode1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInBinaryTree {

    private static List<Double> averageOfLevels(TreeNode1 root) {

        List<List<Double>> levelList = new ArrayList<>();

        Queue<TreeNode1> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {

            int levelSize = queue.size();

            List<Double> currentLevelList = new ArrayList<>(levelSize);

            for (int i = 0; i < levelSize; i++) {

                TreeNode1 currentNode = queue.poll();

                currentLevelList.add(currentNode.val);

                if (currentNode.left != null) {

                    queue.offer(currentNode.left);
                }

                if (currentNode.right != null) {

                    queue.offer(currentNode.right);
                }
            }

            levelList.add(currentLevelList);
        }

        return averageOfLevel(levelList);
    }

    private static List<Double> averageOfLevel(List<List<Double>> levelList) {

        List<Double> result = new ArrayList<>();

        for (List<Double> list : levelList) {

            double sumAtEachLevel = 0;

            for (Double e : list) {

                sumAtEachLevel += e;

            }

            double avg = sumAtEachLevel / list.size();

            result.add(avg);
        }

        return result;
    }

    private static void print(List<Double> result) {

        int count = 0;

        for (Double level : result) {

            System.out.print(level);

            count++;
            if (count < result.size()) {
                System.out.print(", ");
            }
        }
    }

    public static void main(String[] args) {

        // Constructing the tree: [3,9,20,null,null,15,7]

        TreeNode1 root = new TreeNode1(3);

        root.left = new TreeNode1(9);
        root.right = new TreeNode1(20);

        root.right.left = new TreeNode1(15);
        root.right.right = new TreeNode1(7);

        List<Double> result = averageOfLevels(root);


        print(result);
    }
}

