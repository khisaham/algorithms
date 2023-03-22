/*
In a Binary Search Tree (BST), an Inorder Successor of a node is defined as the node with the smallest key greater than the key of the input node (see examples below).
Given a node inputNode in BST, you're asked to write a function findInOrderSuccessor that returns the Inorder Successor of inputNode.
If inputNode has no Inorder successor, return null.
Explain your code and analyse time and space complexity.

            20
           /  \
          9    25
         / \
        5  12
          /  \
         11  14
 */


public class BSTSuccessorSearch {
        static class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            public TreeNode(int val) {
                this.val = val;
                left = null;
                right = null;
            }
        }

        public static TreeNode findInOrderSuccessor(TreeNode inputNode) {
            // Case 1: If input node has right child
            if (inputNode.right != null) {
                TreeNode successor = inputNode.right;
                while (successor.left != null) {
                    successor = successor.left;
                }
                return successor;
            }
            // Case 2: If input node does not have right child
            else {
                TreeNode successor = null;
                TreeNode ancestor = root;
                while (ancestor != inputNode) {
                    if (ancestor.val > inputNode.val) {
                        successor = ancestor;
                        ancestor = ancestor.left;
                    } else {
                        ancestor = ancestor.right;
                    }
                }
                return successor;
            }
        }

        private static TreeNode root;

        public static void main(String[] args) {
            // Create a binary search tree
            root = new TreeNode(20);
            root.left = new TreeNode(9);
            root.right = new TreeNode(25);
            root.left.left = new TreeNode(5);
            root.left.right = new TreeNode(12);
            root.left.right.left = new TreeNode(11);
            root.left.right.right = new TreeNode(14);

            // Find the inorder successor of a node
            TreeNode node = root.left.left;
            TreeNode successor = findInOrderSuccessor(node);
            if (successor != null) {
                System.out.println("The inorder successor of " + node.val + " is " + successor.val);
            } else {
                System.out.println("There is no inorder successor for " + node.val);
            }
        }

}
