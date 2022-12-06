https://leetcode.com/problems/sentence-similarity-iii/discuss/1937597/Java-or-Insert-to-shorter-string
class Solution {
    public boolean areSentencesSimilar(String A, String B) {
        if (A.length() < B.length())
            return areSentencesSimilar(B, A);

        return check(A, B);
    }

    private boolean check(String A, String B){
        String[] x = A.split(" ");
        String[] y = B.split(" ");
        int i = 0, j = y.length - 1, k = x.length - 1;
        while(i < y.length && x[i].equals(y[i])){
            i++;
        }
        while(j >= 0 && x[k].equals(y[j])){
            j--;
            k--;
        }
        return i > j; // USED ALL THE B.
    }
    // a b cc dd
    // a b cc dd ff
}
