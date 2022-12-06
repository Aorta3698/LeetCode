class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int hi = letters.length - 1;
        int lo = 0;

        while(lo < hi){
            int mid = lo + (hi - lo) / 2;
            if (letters[mid] > target) hi = mid;
            if (letters[mid] <= target) lo = mid + 1;
        }

        return target >= letters[hi]? letters[0] : letters[hi];
    }
}
