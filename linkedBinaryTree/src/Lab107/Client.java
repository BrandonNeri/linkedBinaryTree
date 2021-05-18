package Lab107;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Brandon Neri
 * @version 03/05/2021
 *
 * Client.java is a Java class that uses the LinkedBinaryTree.java
 * class to create a series of trees to create a mathematical 
 * expression: ((2+9)+(7-(3*8))) that is then outputted in preOrder,
 * postOrder, inOrder, breadthFirst, and is then Parenthesized. This
 * Java class also includes a method that uses eulerTourBinary to 
 * construct the parenthesized representation of the LinkedBinaryTree.
 * 
 */
public class Client {

    public static void main(String[] args) {
        // Expected Expression
        System.out.println("Given Expression:\n( ( 2 + 9 ) + ( 7 - ( 3 * 8 ) ) )");

        // (2 + 9) Operation
        LinkedBinaryTree<String> tree1 = new LinkedBinaryTree<>();
        tree1.addRoot("+");
        tree1.addLeft(tree1.root, "2");
        tree1.addRight(tree1.root, "9");

        // (3 * 8) Operation
        LinkedBinaryTree<String> tree2 = new LinkedBinaryTree<>();
        tree2.addRoot("*");
        tree2.addLeft(tree2.root, "3");
        tree2.addRight(tree2.root, "8");

        // 7 Operation
        LinkedBinaryTree<String> tree3 = new LinkedBinaryTree<>();
        tree3.addRoot("7");

        // (7 - (3 * 8)) Operation
        LinkedBinaryTree<String> tree4 = new LinkedBinaryTree<>();
        tree4.addRoot("-");
        tree4.attach(tree4.root, tree3, tree2);

        // ((2 + 9) + (7 - (3 * 8))) Operation
        LinkedBinaryTree<String> tree5 = new LinkedBinaryTree<>();
        tree5.addRoot("+");
        tree5.attach(tree5.root, tree1, tree4);

        // Print Height of the Tree
        List<Integer> heights = new ArrayList<>();
        System.out.println("\nThe Heights of the Tree:");
        for (Position<String> position : tree5.createPreOrder()) {
            heights.add(tree5.height(position));
            System.out.print(tree5.height(position) + ", ");
        }
        int maxValue = 0;
        for (int i = 0; i < heights.size(); i++) {
            if (heights.get(i) > maxValue) {
                maxValue = heights.get(i);
            }
        }
        System.out.print("Max Height = " + maxValue);
        System.out.println();

        // Print PreOrder Tree Traversal
        System.out.println("\nThe PreOrder Tree Traversal Output:");
        for (Position<String> position : tree5.createPreOrder()) {
            System.out.print(position.getElement());
        }
        System.out.println();

        // Print InOrder Tree Traversal
        System.out.println("\nThe InOrder Tree Traversal Output:");
        for (Position<String> position : tree5.createInOrder()) {
            System.out.print(position.getElement());
        }
        System.out.println();

        // Print PostOrder Tree Traversal
        System.out.println("\nThe PostOrder Tree Traversal Output:");
        for (Position<String> position : tree5.createPostOrder()) {
            System.out.print(position.getElement());
        }
        System.out.println();

        // Print BreadthFirst Tree Traversal
        System.out.println("\nThe BreadthFirst Tree Traversal Output:");
        for (Position<String> position : tree5.createBreadthFirst()) {
            System.out.print(position.getElement());
        }
        System.out.println();

        // Print Parenthesized Representation of the Tree
        System.out.println("\nThe Parenthesized Representation Tree Output (Euler’s Tour):");
        eulerTourBinary(tree5, tree5.root); // Call to eulerTourBinary Method
        System.out.println();
    }

    /**
     *
     * Create a Parenthesized Representation of a tree using Euler's Tour Algorithm.
     * 
     * Based off the logic of the Algorithem found in Code Fragement 8.29
     * 
     * @param T a given LinkedBinaryTree
     * @param p position in a tree
     */
    public static void eulerTourBinary(LinkedBinaryTree T, Position p) {
        if (T.isInternal(p)) {
            System.out.print("( ");
        }
        if (T.left(p) != null) {
            eulerTourBinary(T, T.left(p));
        }
        System.out.print(p.getElement() + " ");
        if (T.right(p) != null) {
            eulerTourBinary(T, T.right(p));
        }
        if (T.isInternal(p)) {
            System.out.print(") ");
        }
    }
}
