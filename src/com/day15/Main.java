package com.day15;

public class Main {
    public static void main(String[] args) {
        MyHashTable<String, Integer> wordFrequencyTable = new MyHashTable<>(10);
        String sentence = "To be or not to be";
        String[] words = sentence.toLowerCase().split(" ");
        for (String word : words) {
            Integer frequency = wordFrequencyTable.add(word, 1);
            if (frequency != null) {
                wordFrequencyTable.add(word, frequency + 1);
            }
        }
        wordFrequencyTable.printHashTable();

        wordFrequencyTable.remove("not");
        System.out.println("\nAfter removing 'not':");
        wordFrequencyTable.printHashTable();
    }
}