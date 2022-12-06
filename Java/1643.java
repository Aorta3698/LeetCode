class Solution {
    public String kthSmallestPath(int[] destination, int k) {
        int m = destination[0];
        int n = destination[1];
        StringBuilder sb = new StringBuilder();
        for (int i = m+n,h=0; i >= 1; i--){
            long cost = comb(i-1, n-h-1);
            if (cost>=k){
                sb.append("H");
                h++;
            }else{
                sb.append("V");
                k-=cost;
            }
        }
        return sb.toString();
    }

    private int comb(int a, int b){
        if (b<0){
            return 0;
        }
        long ans = 1;
        for (int i = 1; i <= b; i++){
            ans = (a-b+i)*ans/i;
        }
        return (int)ans;
    }
}
