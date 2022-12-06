// probably the best
class Solution {
    public int maximumRemovals(String s, String p, int[] removable) {
        int lo = -1, hi = removable.length - 1;
        int[] bad = new int[s.length()];
        Arrays.fill(bad, Integer.MAX_VALUE);
        for (int i = 0; i < removable.length; i++){
            bad[removable[i]] = i;
        }

        while(lo < hi){
            int mid = (hi + lo + 1) >> 1;
            if (isSub(s, p, bad, mid)) lo = mid;
            else hi = mid - 1;
        }

        return lo + 1;
    }

    private boolean isSub(String s, String p, int[] bad, int guess){
        int j = 0;
        for (int i = 0; i < s.length() && j < p.length(); i++){
            if (bad[i] > guess && s.charAt(i) == p.charAt(j)){
                j++;
            }
        }
        return j == p.length();
    }
}

// second best
class Solution {
    public int maximumRemovals(String s, String p, int[] removable) {
        int lo = -1, hi = removable.length - 1;
        char[] arr = s.toCharArray();

        while(lo < hi){
            int mid = (hi + lo + 1) >> 1;
            for (int i = 0; i <= mid; i++){
                arr[removable[i]] ^= ' ';
            }
            if (isSub(arr, p)) lo = mid;
            else hi = mid - 1;
            for (int i = 0; i <= mid; i++){
                arr[removable[i]] ^= ' ';
            }
        }

        return lo + 1;
    }

    private boolean isSub(char[] s, String p){
        int j = 0;
        for (int i = 0; i < s.length && j < p.length(); i++){
            if (Character.isUpperCase(s[i])) continue;
            if (s[i] == p.charAt(j)){
                j++;
            }
        }
        return j == p.length();
    }
}

// worst
class Solution {
    public int maximumRemovals(String s, String p, int[] removable) {
        int lo = -1, hi = removable.length - 1;
        while(lo < hi){
            int mid = (hi + lo + 1) >> 1;
            Set<Integer> skip = new HashSet<>();
            for (int i = 0; i <= mid; i++){
                skip.add(removable[i]);
            }
            if (isSub(s, p, skip)) lo = mid;
            else hi = mid - 1;
        }
        return lo + 1;
    }

    private boolean isSub(String s, String p, Set<Integer> skip){
        int j = 0;
        for (int i = 0; i < s.length() && j < p.length(); i++){
            if (skip.contains(i)) continue;
            if (s.charAt(i) == p.charAt(j)){
                j++;
            }
        }
        return j == p.length();
    }
}
