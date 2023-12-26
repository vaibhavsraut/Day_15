package com.day15;
import java.util.LinkedList;

class MyHashTable<K, V> {
    private final int numOfBuckets;
    private LinkedList<MyMapNode<K, V>>[] bucketArray;

    public MyHashTable(int numOfBuckets) {
        this.numOfBuckets = numOfBuckets;
        this.bucketArray = new LinkedList[numOfBuckets];
        for (int i = 0; i < numOfBuckets; i++) {
            this.bucketArray[i] = new LinkedList<>();
        }
    }

    public Integer add(K key, V value) {
        int index = getBucketIndex(key);
        LinkedList<MyMapNode<K, V>> linkedList = bucketArray[index];
        MyMapNode<K, V> myMapNode = new MyMapNode<>(key, value);

        MyMapNode<K, V> existingNode = linkedList.stream()
                .filter(node -> node.key.equals(key))
                .findFirst()
                .orElse(null);

        if (existingNode == null) {
            linkedList.add(myMapNode);
        } else {
            existingNode.value = value;
        }
        return null;
    }

    public void remove(K key) {
        int index = getBucketIndex(key);
        LinkedList<MyMapNode<K, V>> linkedList = bucketArray[index];

        MyMapNode<K, V> nodeToRemove = linkedList.stream()
                .filter(node -> node.key.equals(key))
                .findFirst()
                .orElse(null);

        if (nodeToRemove != null) {
            linkedList.remove(nodeToRemove);
        }
    }

    private int getBucketIndex(K key) {
        int hashCode = key.hashCode();
        return hashCode % numOfBuckets;
    }

    public void printHashTable() {
        for (int i = 0; i < numOfBuckets; i++) {
            System.out.print("Bucket " + i + ": ");
            LinkedList<MyMapNode<K, V>> linkedList = bucketArray[i];
            for (MyMapNode<K, V> node : linkedList) {
                System.out.print("(" + node.key + ": " + node.value + ") ");
            }
            System.out.println();
        }
    }
}
