class Solution {
    public int repeatedStringMatch(String a, String b) {
        int base = b.length()/a.length();
        int upper = base + 2;

        for (int i = base; i <= upper; i++){
            String t = a.repeat(i);
            if(t.contains(b)) return i;
        }

        return -1;
    }
}
