package ds.sorting;

import ds.common.Position;
import ds.lists.LinkedList;
import ds.lists.List;
import ds.vectors.ArrayVector;
import ds.vectors.Vector;

import java.lang.reflect.Array;
import java.util.Random;

public class InPlaceQuickSort {
    private static Random random = new Random();

    /**
     * Simple test method
     *
     * @param args
     */
    public static void main(String[] args) {
        Vector<Integer> vector = new ArrayVector<Integer>();
        while (vector.size() < 8) {
            vector.insertAtRank(vector.size(), random.nextInt(100));
        }
        System.out.println(vector);
        inPlaceQuickSort(vector);
        System.out.println(vector);
    }

    /**
     * The headline method that triggers the in-place quick sort
     * @param V the vector being sorted
     * @param <T> the type of element in the Vector
     */
    public static <T extends Comparable<T>> void inPlaceQuickSort(Vector<T> V) {
        inPlaceQuickSort(V, 0, V.size()-1);
    }

    /**
     * The main in-place quicksort implementation (is called recursively for different ranges of V)
     * @param V the Vector being sorted
     * @param l the lower bound
     * @param r the upper bound
     * @param <T> the type of element in the Vector
     */
    private static <T extends Comparable<T>> void inPlaceQuickSort(Vector<T> V, int l, int r) {
        if (l > r) return;

        int i = l + ((l==r)?0:random.nextInt(r-l));
        T x = V.elemAtRank(i);

        int[] indices = inPlacePartition(V, l, r, x);
        inPlaceQuickSort(V, l, indices[0]);
        inPlaceQuickSort(V, indices[1], r);
    }

    /**
     * Implements the in place partition for the range [l,r] of V using pivot x.
     * @param V the vector
     * @param l the lower bound
     * @param r the upper bound
     * @param x the value of the pivot
     * @param <T> the type of element in the Vector
     * @return an array containing the upper bound for L (index 0) and the lower bound for G (index 1)
     */
    private static <T extends Comparable<T>> int[] inPlacePartition(Vector<T> V, int l, int r, T x) {
        int j = l;
        int k = r;

        // Split into L and EG
        while (j <= k) {
            while (j <= k && V.elemAtRank(j).compareTo(x) < 0) j++;
            while (j <= k && V.elemAtRank(k).compareTo(x) >= 0) k--;
            if (j < k) {
                V.replaceAtRank(j, V.replaceAtRank(k, V.elemAtRank(j)));
            }
        }

        // Split EG into E and G
        int lb = k;
        k = r;
        while (j <= k) {
            while (j <= k && V.elemAtRank(j).compareTo(x) == 0) j++;
            while (j <= k && V.elemAtRank(k).compareTo(x) > 0) k--;
            if (j < k) {
                V.replaceAtRank(j, V.replaceAtRank(k, V.elemAtRank(j)));
            }
        }

        // Return upper bound for L and lower bound for G (E is inbetween)
        return new int[] {lb, j};
    }

    /**
     * Useful method to to print out part of the Vector
     * @param V the vector being sorted
     * @param l the lower bound
     * @param r the upper bound
     * @param <T> the type of the Vector
     */
    private static <T extends Comparable<T>> void printRange(Vector<T> V, int l, int r) {
        for (int i = l; i <= r; i++) {
            System.out.print(V.elemAtRank(i)+" ");
        }
        System.out.println();
    }

}
