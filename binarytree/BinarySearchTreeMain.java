package binarytree;

public class BinarySearchTreeMain {

    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();

        /*

        int[] nums = {5, 2, 7, 1, 4, 6, 9, 8, 3, 10};

        bst.populate(nums);

        bst.display();

        boolean balancedTree = bst.balancedBST(bst.root());

        System.out.println("Balanced Tree "+ balancedTree);

        */

        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        bst.populateSorted(nums);

        bst.display();
    }
}
