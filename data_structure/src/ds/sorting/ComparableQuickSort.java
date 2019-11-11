package ds.sorting;

import ds.common.Position;
import ds.lists.LinkedList;
import ds.lists.List;

import java.lang.reflect.Array;
import java.util.Comparator;
import java.util.Random;

public class ComparableQuickSort {
    private static Random random = new Random();

    /**
     * Simple test method
     *
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<Integer>();
        while (list.size() < 100) {
            list.insertLast(random.nextInt(100));
        }
        System.out.println(list);
        quickSort(list,new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return -o1.compareTo(o2);
            }
        });
        System.out.println(list);
    }

    /**
     * The main quicksort method
     * @param S the list being sorted
     * @param <T> the type of value stored in the list
     */
    public static <T> void quickSort(List<T> S, Comparator<T> C) {
        if (S.size() > 1) {
            Position<T> p = selectPivot(S);
            List<T>[] sublists = partition(S, C, p);
            quickSort(sublists[0], C);
            quickSort(sublists[2], C);
            join(S, sublists);
        }
    }

    /**
     * Method to join the lists L, E, G represented as an array of size 3
     * @param S the original list (now empty)
     * @param sublists the array of lists (L, E, G)
     * @param <T> the type of value stored in the list
     */
    private static <T> void join(List<T> S, List<T>[] sublists) {
        for (int i=0;i<3; i++) {
            while (!sublists[i].isEmpty()) {
                S.insertLast(sublists[i].remove(sublists[i].first()));
            }
        }
    }

    /**
     * Method that selects a random pivot
     * @param S the list being sorted
     * @param <T> the type of value stored in the list
     * @return the position of the selected pivot
     */
    private static <T> Position<T> selectPivot(List<T> S) {
        int index = random.nextInt(S.size());
        Position<T> current = S.first();
        while (index > 0) {
            current = S.next(current);
            index--;
        }
        return current;
    }

    /**
     * The partition method
     * @param S the List being partitioned
     * @param p the position of the pivot in the list
     * @param <T> the type of value stored in the list
     * @return an array of Lists containing L (index 0), E (index 1) and G (index 2)
     */
    private static <T> List<T>[] partition(List<T> S, Comparator<T> C, Position p) {
        List<T>[] sublists = (List<T>[]) Array.newInstance(List.class,3);
        sublists[0] = new LinkedList<T>();
        sublists[1] = new LinkedList<T>();
        sublists[2] = new LinkedList<T>();
        T x = (T) S.remove(p);
        sublists[1].insertFirst(x);

        while (!S.isEmpty()) {
            T y = S.remove(S.first());
            if (C.compare(y, x) < 0) {
                sublists[0].insertLast(y);
            } else if (C.compare(y,x) > 0) {
                sublists[2].insertLast(y);
            } else {
                sublists[1].insertLast(y);
            }
        }
        return sublists;
    }
}
