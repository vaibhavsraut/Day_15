package com.day15;

class MyBinarySearchTree<K extends Comparable<K>> {
    private MyBinaryNode<K> root;

    public void add(K key) {
        root = addRecursively(root, key);
    }

    private MyBinaryNode<K> addRecursively(MyBinaryNode<K> current, K key) {
        if (current == null) {
            return new MyBinaryNode<>(key);
        }

        if (key.compareTo(current.key) < 0) {
            current.left = addRecursively(current.left, key);
        } else if (key.compareTo(current.key) > 0) {
            current.right = addRecursively(current.right, key);
        }

        return current;
    }

    public void createTree() {
        add((K) Integer.valueOf(56));
        add((K) Integer.valueOf(30));
        add((K) Integer.valueOf(70));
        add((K) Integer.valueOf(22));
        add((K) Integer.valueOf(40));
        add((K) Integer.valueOf(11));
        add((K) Integer.valueOf(3));
        add((K) Integer.valueOf(16));
        add((K) Integer.valueOf(60));
        add((K) Integer.valueOf(95));
        add((K) Integer.valueOf(65));
        add((K) Integer.valueOf(63));
        add((K) Integer.valueOf(67));
    }

    public int size() {
        return getSize(root);
    }

    private int getSize(MyBinaryNode<K> current) {
        return current == null ? 0 : 1 + getSize(current.left) + getSize(current.right);
    }

    public boolean search(K key) {
        return searchRecursively(root, key);
    }

    private boolean searchRecursively(MyBinaryNode<K> current, K key) {
        if (current == null) {
            return false;
        }

        if (key.equals(current.key)) {
            return true;
        }

        return key.compareTo(current.key) < 0 ? searchRecursively(current.left, key) :
                searchRecursively(current.right, key);
    }
}