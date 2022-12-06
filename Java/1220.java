class Solution {
    public int countVowelPermutation(int n) {
        long a = 1, e = 1, i = 1, o = 1, u = 1;
        int M = (int)1e9+7;
        while(--n > 0){
            long na = e;
            long ne = (a+i) % M;
            long ni = (a+e+o+u) % M;
            long no = (i+u) % M;
            long nu = a;
            a = na;
            e = ne;
            i = ni;
            o = no;
            u = nu;
        }
        return (int)((a+e+i+o+u)%M);
    }
}
