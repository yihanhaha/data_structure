package ds.patterns;

public class BruteForce {
    private static int comparisons = 0;

    public static void main(String[] args) {
        String T = "a pattern matching algorithm";
        comparisons = 0;
        System.out.println("index: " + match(T, "rithm"));
        System.out.println("comparisons: " + comparisons);

        T = "abacaabaccabacabaabb";
        comparisons = 0;
        System.out.println("index: " + match(T, "abacab"));
        System.out.println("comparisons: " + comparisons);

        T =  "the cat sat on the back of the big red mat";
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
        int i = 0;
        int n = T.length();
        int m = P.length();
        while (i <= n-m) {
            int j = 0;
            while ((j < m) && (T.charAt(i+j) == P.charAt(j))) {
                comparisons++;
                System.out.println("["+comparisons+"] T["+(i+j)+"]="+T.charAt(i+j) +", P["+j+"]="+P.charAt(j));
                j++;
            }
            comparisons++;
            if (j == m) return i;
            System.out.println("["+comparisons+"] T["+(i+j)+"]="+T.charAt(i+j) +", P["+j+"]="+P.charAt(j)+ " MISMATCH");
            i++;
        }
        return -1;
    }

    public static int match (String T, String P, int offset)
    {
        int i = offset;
        int n = T.length();
        int m = P.length();
        while (i <= n-m) {
            int j = 0;
            while ((j < m) && (T.charAt(i+j) == P.charAt(j))) {
                comparisons++;
                System.out.println("["+comparisons+"] T["+(i+j)+"]="+T.charAt(i+j) +", P["+j+"]="+P.charAt(j));
                j++;
            }
            comparisons++;
            if (j == m) return i;
            System.out.println("["+comparisons+"] T["+(i+j)+"]="+T.charAt(i+j) +", P["+j+"]="+P.charAt(j)+ " MISMATCH");
            i++;
        }
        return -1;
    }
}
