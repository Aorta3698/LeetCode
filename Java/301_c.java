class Solution {
    public boolean canChange(String start, String T) {
        int n = start.length();
        int[] lo = new int[n];
        int[] hi = new int[n];
        for (int i = 0, j = n -1, r=-1,l=n;i<n;i++,j--){
            if (start.charAt(i)=='R'){
                r=i;
            }
            if (start.charAt(i)=='L'){
                lo[i]=r;
            }
            if (start.charAt(j)=='L'){
                l=j;
            }
            if (start.charAt(j)=='R'){
                hi[j]=l;
            }
        }
        for (int i = 0,j=0; i < n; i++){
            if (T.charAt(i)=='L' || T.charAt(i) == 'R'){

            }
        }
    }
}
