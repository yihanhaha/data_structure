package ds.vectors;

public interface Vector<T> extends Iterable<T> {
    int size();
    boolean isEmpty();
    T elemAtRank(int rank);
    T replaceAtRank(int rank, T element);
    void insertAtRank(int rank, T element);
    T removeAtRank(int rank);
}
