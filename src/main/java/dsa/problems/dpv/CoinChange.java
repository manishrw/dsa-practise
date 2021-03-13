package dsa.problems.dpv;

public class CoinChange {
    public static boolean isCoinChangePossible(int[] X, int V) {
        // Initialize dp table
        boolean[] P = new boolean[V + 1];
        for (int v = 0; v <= V; v++) 
            P[v] = false;
        P[0] = true;

        // Recursive solution using bottom up approach
        for (int v = 0; v < V; v++) {
            for (int i = 0; i < X.length; i++) {
                if (X[i] <= v) {
                    P[v] = P[v] || P[v - X[i]];
                }
            }
        }
        return P[V];
    }
}