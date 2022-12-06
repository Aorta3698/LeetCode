// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        for (double[] row : solution(new int[]{4, 2, 5, 9, 2}, 5)){
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
        for (double[] row : solution(new int[]{4, 2, 5, 9, 2}, 3)){
            System.out.println(Arrays.toString(row));
        }
    }

    // TIME COMPLEXITY IS O(n)
    private static double[][] solution(int[] orders, int n){
        n = Math.min(Math.abs(n), orders.length);
        double sum = 0;
        double max = 0;
        double[][] ans = new double[n][3];
        for (int i = orders.length - n, sz = 0; i < orders.length; i++){
            sz++;
            max = Math.max(max, orders[i]);
            sum += orders[i];
            ans[sz-1]=new double[]{max, sum/sz, sz == 1? -1 :
                Math.sqrt(1d*(sz-2)/(sz-1)*ans[sz-2][2]*ans[sz-2][2]+1d/(sz-1)*(orders[i]-sum/sz)*(orders[i]-ans[sz-2][1]))};
        }
        return ans;
    }
}
