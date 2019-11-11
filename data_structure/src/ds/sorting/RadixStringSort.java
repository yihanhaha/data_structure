package ds.sorting;

import ds.lists.List;
import ds.lists.LinkedList;

import java.lang.reflect.Array;
import java.util.Random;

public class RadixStringSort {
    // range is '_' filler + 'a'-'z'
    private static final int BASE = 27;

    private static Random random = new Random();
    private static List<String>[] buckets;

    /**
     * Static initialisation of the bucket array (here we are assuming that
     * the numbers are base 10 - hence 10 buckets)
     */
    static {
        buckets = (List<String>[]) Array.newInstance(List.class, BASE);
        for (int i=0; i < BASE; i++) {
            buckets[i] = new LinkedList<String>();
        }

    }
    /**
     * Simple test method
     *
     * @param args
     */
    public static void main(String[] args) {
        radixSort("the small tabby cat sat on the big red mat");
//        List<String> S = new LinkedList<String>();
//
//        S.insertLast("the");
//        S.insertLast("small");
//        S.insertLast("tabby");
//        S.insertLast("cat");
//        S.insertLast("sat");
//        S.insertLast("on");
//        S.insertLast("the");
//        S.insertLast("big");
//        S.insertLast("red");
//        S.insertLast("mat");

//        System.out.println(S);
//        radixSort(S);
//        System.out.println(S);
    }

    public static void radixSort(String text) {
        List<String> S = new LinkedList<String>();

        // Convert the text to a list of words...
        for (String word : text.split(" ")) {
            S.insertLast(word);
        }

        System.out.println(S);
        radixSort(S);
        System.out.println(S);
    }
    /**
     * The top level radix sort method for Vectors of Integer values (with d digits)
     * @param S the values to be sorted
     */
    public static void radixSort(List<String> S) {
        // Find the longest word (1 pass)
        int d = -1;
        for(String word : S) {
            if (word.length() > d) d = word.length();
        }

        for (int i=1; i<=d; i++) {
            bucketSort(S, d, i);
        }
    }

    /**
     * Performs a stable bucket sort for a given digit
     * @param S the vector to be sorted
     * @param d the max number of digits
     * @param i the digit to be sorted on
     */
    private static void bucketSort(List<String> S, int d, int i) {
        // Put the values in the buckets
        while (!S.isEmpty()) {
            String word = S.remove(S.first());
            int gap = d-word.length();
            int index =  gap >= i ? 0:word.charAt(word.length()-i+gap) - 'a'+1;
            buckets[index].insertLast(word);
        }

        // Put the values back into the vector
        for (List<String> bucket : buckets) {
            while (!bucket.isEmpty()) {
                S.insertLast(bucket.remove(bucket.first()));
            }
        }
    }
}
