/***
 * @file: BST.java
 * @description: This code creates a generic (using Comparable<T>) Binary Search Tree class
 * @author: Douglas Otton
 * @date: September 19, 2024
 ***/

import java.util.Iterator;
import java.util.Stack;

public class BST<T extends Comparable<T>> {
    private Node<T> root;
    private int size;

    // Implement the constructor
    BST() {
        root = null;
        size = 0;
    }

    // Implement the clear method
    public void clear() {
        root = null;
        size = 0;
    }

    // Implement the size method
    public int size() {
        return size;
    }

    // Returns true if the tree is empty
    public boolean isEmpty() {
        return root == null;
    }

    // Implement the insert method
    public void insert(T key) {
        root = insertHelper(root, key);
        size++;
    }

    private Node<T> insertHelper(Node<T> root, T key) {
        if (root == null) {
            size++;
            return new Node<T>(key, null, null);
        }
        if (root.getElement().compareTo(key) > 0) {
            root.setLeft(insertHelper(root.getLeft(), key));
        } else {
            root.setRight(insertHelper(root.getRight(), key));
        }
        size++;
        return root;
    }

    // Implement search method
    public T find(T key) {
        return findHelper(root, key);
    }

    private T findHelper(Node<T> root, T key) {
        if (root == null) {
            return null;
        }
        if (root.getElement().compareTo(key) > 0) {
            return findHelper(root.getLeft(), key);
        } else if (root.getElement().compareTo(key) < 0) {
            return findHelper(root.getRight(), key);
        } else {
            return root.getElement();
        }
    }

    // Implement remove method
    public T remove(T key) {
        T temp = findHelper(root, key);
        if (temp != null) {
            root = removeHelper(root, key);
            size--;
        }
        return temp;
    }

    private Node<T> removeHelper(Node<T> root, T key) {
        if (root == null) {
            return null;
        }
        if (root.getElement().compareTo(key) > 0) {
            root.setLeft(removeHelper(root.getLeft(), key));
        } else if (root.getElement().compareTo(key) < 0) {
            root.setRight(removeHelper(root.getRight(), key));
        } else { // Found it, remove it
            if (root.getRight() == null) {
                return root.getLeft();
            } else if (root.getLeft() == null) {
                return root.getRight();
            } else { //Two children
                Node<T> temp = getMax(root.getLeft());
                root.setElement(temp.getElement());
                root.setLeft(removeHelper(root.getLeft(), temp.getElement()));
            }
        }
        return root;
    }

    private Node<T> getMax(Node<T> node) {
        if (node == null) {
            return null;
        }
        while (node.getRight() != null) {
            node = node.getRight();
        }
        return node;
    }

    // Implement the iterator method
    public String iterator() {
        BSTIterator iterator = new BSTIterator();
        return iterator.inOrder();
    }

    // Implement BSTIterator class
    private class BSTIterator implements Iterator<T> {
        private Stack<Node<T>> stack;

        // BSTIterator constructor method
        public BSTIterator() {
            if (root != null) {
                stack = new Stack<>();
                goFromLeft(root);
            }
            /*
            stack = new Stack<>();
            if (root != null) {
                stack.push(root);
            }

             */
        }

        // returns true if the tree isn't empty
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        // returns the next
        public T next() {
            Node<T> current = null;
            if (!stack.isEmpty()) {
                current = stack.peek();
                stack.pop();

                if (current.getRight() != null) {
                    goFromLeft(current.getRight());
                }
            }
            return current.getElement();

            /*
            if (!hasNext()) {
                return null;
            }
            Node<T> node = stack.pop();
            if (node.getRight() != null) {
                stack.push(node.getRight());
            }
            if (node.getLeft() != null) {
                stack.push(node.getLeft());
            }
            return node.getElement();

             */
        }

        private void goFromLeft(Node<T> right) {
            while (right != null) {
                stack.push(right);
                right = right.getLeft();
            }
        }

        // returns the in order BST
        public String inOrder() {
            StringBuilder tree = new StringBuilder();
            inOrderHelper(root, tree);
            return tree.toString();

        }

        // appends the BST to tree in order (smallest to largest)
        private void inOrderHelper(Node<T> node, StringBuilder tree) {
            if (node == null) {
                return;
            }

            inOrderHelper(node.getLeft(), tree);
            tree.append(node.getElement()).append(" ");
            inOrderHelper(node.getRight(), tree);
        }
    }
}
/*
    public void preOrder() {
        preOrderHelper(root);
    }

    public void preOrderHelper(Node<T> node) {
        if (node == null){
            return;
        }

        System.out.println(node.getElement());
        inOrderHelper(node.getLeft());
        inOrderHelper(node.getRight());
    }

    public void postOrder() {
        postOrderHelper(root);
    }

    private void postOrderHelper(Node<T> node) {
        if (node == null){
            return;
        }

        postOrderHelper(node.getLeft());
        postOrderHelper(node.getRight());
        System.out.println(node.getElement());
    }
 */