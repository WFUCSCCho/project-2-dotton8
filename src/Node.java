/***
 * @file: Node.java
 * @description: This code creates a generic (using Comparable<T>) Node class for Binary Search Trees
 * @author: Douglas Otton
 * @date: September 19, 2024
 ***/

public class Node<T extends Comparable<T>> {
    T element;
    Node<T> left;
    Node<T> right;

    // Implement the constructors
    // Default constructor
    public Node() {
        element = null;
        left = null;
        right = null;
    }

    public Node(T element, Node<T> left, Node<T> right) {
        this.element = element;
        this.left = left;
        this.right = right;
    }

    // Implement the setElement method
    public void setElement(T element) {
        this.element = element;
    }

    // Implement the setLeft method
    public void setLeft(Node<T> left) {
        this.left = left;
    }

    // Implement the setRight method
    public void setRight(Node<T> right) {
        this.right = right;
    }

    // Implement the getLeft method
    public Node<T> getLeft() {
        return left;
    }

    // Implement the getRight method
    public Node<T> getRight() {
        return right;
    }

    // Implement the getElement method
    public T getElement() {
        return element;
    }

    // Implement the isLeaf method
    public boolean isLeaf() {
        return left == null && right == null;
    }
}