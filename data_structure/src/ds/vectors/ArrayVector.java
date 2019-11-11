package ds.vectors;

import java.util.Iterator;

public class ArrayVector<T> implements Vector<T> {
    private T[] array;
    private int size;

    public ArrayVector() {
        this(10);
    }

    public ArrayVector(int capacity) {
        array = (T[]) new Object[capacity];
        size=0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public T elemAtRank(int rank) {
        if (rank < 0 || rank > size-1) throw new RankOutOfBoundsException();
        return array[rank];
    }

    @Override
    public T replaceAtRank(int rank, T element) {
        if (rank < 0 || rank > size-1) throw new RankOutOfBoundsException();
        T temp = array[rank];
        array[rank] = element;
        return temp;
    }

    @Override
    public void insertAtRank(int rank, T element) {
        if (rank < 0 || rank > size) throw new RankOutOfBoundsException();

//        if (size == array.length) throw new VectorFullException();
        if (size == array.length) {
            T[] newArray = (T[]) new Object[array.length*2];
            for (int i=0;i<array.length;i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
        int i = size;
        while (i > rank) {
            array[i] = array[i-1];
            i--;
        }
        array[rank] = element;
        size++;
    }

    @Override
    public T removeAtRank(int rank) {
        if (rank < 0 || rank > size-1) throw new RankOutOfBoundsException();

        T temp = array[rank];
        int i = rank;
        while (i < size-1) {
            array[i] = array[i+1];
            i++;
        }
        array[size-1] =null;
        size--;
        return temp;
    }

    public String toString() {
        String output = size + " / " + array.length + " :";
        for (int i=0; i<size;i++) {
            output += " "+array[i].toString();
        }
        return output;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public T next() {
                return array[index++];
            }
        };
    }
}
