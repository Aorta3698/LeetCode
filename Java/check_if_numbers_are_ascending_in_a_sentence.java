class Solution {
    public boolean areNumbersAscending(String s) {
        String[] arr = s.split(" ");
        int prev = -1;
        for (String w : arr){
            if (Character.isDigit(w.charAt(0))){
                int cur = Integer.parseInt(w);
                if (cur <= prev) return false;
                prev = cur;
            }
        }

        return true;
    }
}
