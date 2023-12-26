package com.day15;

public class Main {
    public static void main(String[] args) {
        MyBinarySearchTree<Integer> binarySearchTree = new MyBinarySearchTree<>();
        binarySearchTree.createTree();
        System.out.println("Size of the Binary Search Tree: " + binarySearchTree.size());

        int keyToSearch = 63;
        System.out.println("Is " + keyToSearch + " present in the Binary Search Tree? "
                + binarySearchTree.search(keyToSearch));
    }
}