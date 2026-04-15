package binarytree.common;

public class TreeNode1 {

    public double val;

    public TreeNode1 left;
    public TreeNode1 right;

    public TreeNode1() {

    }

    public TreeNode1(double val) {
        this.val = val;
    }

    public TreeNode1(double val, TreeNode1 left, TreeNode1 right) {

        this.val = val;
        this.left = left;
        this.right = right;
    }
}
