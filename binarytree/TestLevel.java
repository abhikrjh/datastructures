package binarytree;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class TestLevel {


    // Input: root = [3,9,20,null,null,15,7]
    //Output: [[3],[9,20],[15,7]]


    private static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

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

            result.add(currentLevelList);
        }

        return result;
    }

    private static void print(List<List<Integer>> lists) {

        System.out.println(lists);
    }


    public static void main(String[] args) {

        // Input: root = [3,9,20,null,null,15,7]
        //Output: [[3],[9,20],[15,7]]

        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> lists = levelOrder(root);

        print(lists);


    }
}
