package ds.patterns;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class BoyerMoore {
    private static int comparisons = 0;

    public static void main(String[] args) {
        String T = "a pattern matching algorithm";
        comparisons = 0;
        System.out.println("index: " + match(T, "rithm"));
        System.out.println("comparisons: " + comparisons);

        T = "abacaabadcabacabaabb";
        comparisons = 0;
        System.out.println("index: " + match(T, "abacab"));
        System.out.println("comparisons: " + comparisons);


        T = "the cat sat on the back of the bug red mat";
        comparisons = 0;
        int [] test = new int [10];
        int offset = -3;

        for (int i = 0; offset!= -1; i ++)
        {
            test[i] = match(T,"the",offset + 3);
            offset = test[i];
        }
        for (int j = 0; test[j] != -1;j++)
        {
            System.out.println("Index is: " + test[j]);
        }
        System.out.println("comparisons: " + comparisons);


    }

    public static int match(String T, String P) {
        int n = T.length();
        int m = P.length();

        Map<Character, Integer> L = lastOccurrenceMap(P);
        int i = m-1;
        int j = m-1;

        do {
            if (T.charAt(i) == P.charAt(j)) {
                if (j == 0) {
                    comparisons++;
                    return i;
                } else {
                    i--;
                    j--;
                }
            } else {
                int l = lastOccurrence(L, T.charAt(i));
                i = i + m - Math.min(j, 1+l);
                j = m-1;
            }
            comparisons++;
        } while (i < n);

        return -1;
    }

    public static int match (String T, String P, int offset)
    {
        int n = T.length();
        int m = P.length();

        Map<Character, Integer> L = lastOccurrenceMap(P);
        int i = offset;
        int j = m-1;

        do {
            if (T.charAt(i) == P.charAt(j)) {
                if (j == 0) {
                    comparisons++;
                    return i;
                } else {
                    i--;
                    j--;
                }
            } else {
                int l = lastOccurrence(L, T.charAt(i));
                i = i + m - Math.min(j, 1+l);
                j = m-1;
            }
            comparisons++;
        } while (i < n);

        return -1;
    }


    public static Map<Character, Integer> lastOccurrenceMap(String P)
    {
        Map<Character,Integer> last = new TreeMap<Character, Integer>();
//        for (int i = 0 ; i < P.length(); i ++)
//            last.put(P.charAt(i), -1);
        for (int j = 0; j < P.length(); j ++)
            last.put(P.charAt(j),j);
        return last;
    }

    public static int lastOccurrence(Map<Character, Integer> L, Character c)
    {
        //return L.get(c);
        int value = -1;
        if (L.get(c) != null)
            value = L.get(c);
        //System.out.println(value);
        return value;
    }
}
