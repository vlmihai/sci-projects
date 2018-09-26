import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        //Varianta 1 de creare a unui Binary Tree using Comparator method
        BinaryTree<String> stringTree = new BinaryTree<>();
        stringTree.add("Lucian");
        stringTree.add("Alexandru");
        stringTree.add("Dan");
        stringTree.add("Cristina");
        stringTree.add("Robert");
        stringTree.add("Dragos");
        stringTree.add("Bogdan");

        System.out.println("\n" + "Inorder Traversal and Ordered:");
        List<String> OrderList = new ArrayList<>();
        stringTree.traverseInOrder(stringTree.getRoot(), OrderList);
        stringTree.printList(OrderList);
        System.out.println(" ");

        BinaryTree<Integer> intTree = new BinaryTree<>();
        TreeNode<Integer> rootNode=createBinaryTree();

        System.out.println("\n" + "Using Recursive solution:");
        intTree.inOrderRecursive(rootNode);

        System.out.println("\n" + "-------------------------");
        System.out.println("Using Iterative solution:");
        intTree.inOrderIterative(rootNode);

        System.out.println("\n" + "-------------------------");
        System.out.println("PreOrder Traversal:");
        List<Integer> inOrderList = new ArrayList<>();
        intTree.traversePreOrder(rootNode,inOrderList);
        intTree.printList(inOrderList);
        System.out.println("\n" + "-------------------------");
    }

    private static TreeNode<Integer> createBinaryTree()
    {
        // Varianta 2 de creare a unui Binary Tree
        TreeNode<Integer> rootNode =new TreeNode<>(1);
        rootNode.left = new TreeNode<>(5);
        rootNode.left.left = new TreeNode<>(6);
        rootNode.left.right = new TreeNode<>(7);

        rootNode.right = new TreeNode<>(2);
        rootNode.right.left = new TreeNode<>(3);
        rootNode.right.right = new TreeNode<>(4);

        return rootNode;

       // Varianta 3 de creare a unui Binary Tree
        /*TreeNode<Integer> rootNode =new TreeNode<>(40);
        TreeNode<Integer> node20=new TreeNode<>(20);
        TreeNode<Integer> node10=new TreeNode<>(10);
        TreeNode<Integer> node30=new TreeNode<>(30);
        TreeNode<Integer> node60=new TreeNode<>(60);
        TreeNode<Integer> node50=new TreeNode<>(50);
        TreeNode<Integer> node70=new TreeNode<>(70);

        rootNode.left=node20;
        rootNode.right=node60;

        node20.left=node10;
        node20.right=node30;

        node60.left=node50;
        node60.right=node70;

        return rootNode;*/
    }

}
