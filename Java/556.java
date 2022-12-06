https://leetcode.com/problems/next-greater-element-iii/discuss/2361568/Java-Short-Solution-or-O(nlogn)
class Solution {
    public int nextGreaterElement(int n) {
        char[] A = String.valueOf(""+n).toCharArray();
        int[] p = new int[10];
        long ans = 0;
        for (int i = A.length-1; i >= 0; i--){
            for (int j = A[i]-'0'+1; j <= 9; j++){
                if (p[j] > 0){
                    A[p[j]] = A[i];
                    A[i] = (char)(j+'0');
                    Arrays.sort(A, i+1, A.length);
                    for (char ch : A){
                        ans *= 10;
                        ans += ch - '0';
                    }
                    return ans > Integer.MAX_VALUE? -1 : (int) ans;
                }
            }
            p[A[i]-'0']=i;
        }
        return -1;
    }
}
