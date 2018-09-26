import java.util.List;
import java.util.Stack;

/**
 * BinaryTree implementation.
 */

class BinaryTree<T extends Comparable<T>>{
    private TreeNode root;

    TreeNode getRoot() {
        return this.root;
    }

    // Iterative solution using Stack
    void inOrderIterative(TreeNode<Integer> root) {

        if(root == null)
            return;

        Stack<TreeNode> s = new Stack<>();
        TreeNode currentNode=root;

        // traversing the tree
        while(!s.empty() || currentNode!=null){

             //Reach the left most Node of the currentNode
            while (currentNode !=null) {

                //place pointer to a tree node on the stack before traversing the node's left subtree
                s.push(currentNode);
                currentNode = currentNode.left;
            }

            //Current must be NULL at this point
            currentNode = s.pop();
            System.out.print(currentNode.data + " ");

            //we have visited the node and its left subtree.  Now, it's right subtree's turn
            currentNode=currentNode.right;

        }
    }

    // Recursive Solution
    void inOrderRecursive(TreeNode root) {
        if(root !=  null) {
            inOrderRecursive(root.left);
            //Visit the node by Printing the node data
            System.out.print(root.data + " ");
            inOrderRecursive(root.right);
        }
    }

    // Alta solutie pentru a implementa un Binary Tree
    void add(T data) {
        TreeNode<T> newNode = new TreeNode<>(data);

        if (root == null) {
            root = newNode;
        } else {
            TreeNode<T> tempNode = root;
            TreeNode<T> prev = null;
            while (tempNode != null) {
                prev = tempNode;
                if (data.compareTo(tempNode.data) > 0) {
                    tempNode = tempNode.right;
                } else {
                    tempNode = tempNode.left;
                }
            }
            if (data.compareTo(prev.data) < 0) {
                prev.left = newNode;
            } else {
                prev.right = newNode;
            }
        }
    }
    //  visit the left child, then the parent and the right child;
    void traverseInOrder(TreeNode<T> root, List<T> storageList) {
        if (root != null) {
            traverseInOrder(root.left, storageList);
            storageList.add(root.data);
            traverseInOrder(root.right, storageList);
        }
    }
    // visit the parent first and then left and right children;
    void traversePreOrder(TreeNode<T> root, List<T> storageList) {
        if (root != null) {
            storageList.add(root.data);
            traversePreOrder(root.left, storageList);
            traversePreOrder(root.right, storageList);
        }
    }
    // visit left child, then the right child and then the parent;
    void traversePostOrder(TreeNode<T> root, List<T> storageList) {
        if (root != null) {
            traversePostOrder(root.left, storageList);
            traversePostOrder(root.right, storageList);
            storageList.add(root.data);
        }
    }

    void printList(List<T> list) {
        for (T item : list) {
            System.out.print(item + " ");
        }
    }
}
