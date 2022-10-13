package binarytree;

public class BinaryTree {

    private TreeNode root;

   class TreeNode{
      private TreeNode left;
      private TreeNode right;
      private int data;
      public TreeNode(int data){
          this.data = data;
      }
   }

   public void createBinaryTree(){
       TreeNode first = new TreeNode(1);
       TreeNode second = new TreeNode(2);
       TreeNode third = new TreeNode(3);
       TreeNode fourth = new TreeNode(4);
       TreeNode fifth = new TreeNode(5);

       root = first;    // root -----> first

       first.left = second; // second -----> first ------> third
       first.right = third;

       second.left=fourth; // fourth ------> second -----> fifth
       second.right=fifth;

   }


}
