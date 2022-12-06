class Solution {
    public String nextPalindrome(String num) {
        char[] A = num.toCharArray();
        int n = A.length;
        int[] p = new int[10];
        for (int i = n/2-1; i >= 0; i--){
            for (int j = A[i]-'0'+1; j <= 9; j++){
                if (p[j] > 0){
                    A[p[j]] = A[i];
                    A[i] = (char)(j + '0');
                    Arrays.sort(A, i+1, n/2);
                    StringBuilder sb = new StringBuilder();
                    for (int k = 0; k < n/2; k++){
                        sb.append(A[k]);
                    }
                    return sb.toString() + (n % 2 == 0? "" : A[n/2]) + sb.reverse().toString();
                }
            }
            p[A[i]-'0']=i;
        }
        return "";
    }
}
