class Solution {
    public int minimumDeletions(String s) {
        int a = 0, b = 0;
        for (char ch : s.toCharArray()){
            if (ch == 'a'){
                a++;
            }else{
                b = Math.max(a, b) + 1;
            }
        }

        return s.length() - Math.max(a, b);
    }
}
