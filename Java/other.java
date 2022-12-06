import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        // GENERATE ONE TESTCASE
        int SZ = (int)1e5;
        int MAX = (int)1e4;
        Random random = new Random();
        int[] A = new int[random.nextInt(SZ)+1];
        for (int i = 0; i < A.length; i++){
            A[i] = random.nextInt(MAX)+1;
        }
        System.out.println(Arrays.toString(A));

        // SOLVE THE PROBLEM
        int max = Arrays.stream(A).max().getAsInt();
        List<Integer>[] factors = new ArrayList[max+1];
        Arrays.setAll(factors, o -> new ArrayList<>());
        UF uf = new UF(A.length);
        for (int i = 0; i < A.length; i++){
            for (int j = 1; j*j <= A[i]; j++){
                if (A[i] % j == 0){
                    factors[j].add(i);
                    if (j*j!=A[i]){
                        factors[A[i]/j].add(i);
                    }
                }
            }
        }
        int ans = 0;
        for (int i = max, j = A.length; j > 1; i--){
            int prev = -1;
            for (int n : factors[i]){
                if (prev != -1 && uf.union(prev, n)){
                    --j;
                    ans+=i;
                }
                prev = n;
            }
        }

        // PRINT OUT THE ANSWER
        System.out.println("The Maximum Spanning Tree for Array A is " + ans);
    }

    private static class UF {
        int[] parent;
        int[] rank;
        UF (int n){
            parent = IntStream.range(0, n).toArray();
            rank = new int[n];
        }

        int find(int x){
            return x == parent[x]? x : (parent[x] = find(parent[x]));
        }

        boolean union(int x, int y){
            x = find(x);
            y = find(y);
            if (x == y)
                return false;
            if (rank[x] > rank[y]){
                parent[y] = x;
            }else{
                parent[x] = y;
                if (rank[x]==rank[y]){
                    rank[y]++;
                }
            }
            return true;
        }
    }
}
