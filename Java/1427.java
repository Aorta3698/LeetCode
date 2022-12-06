class Solution {
    public String stringShift(String str, int[][] shift) {
        int left = 0, n = str.length();
        for (int[] s : shift){
            if (s[0] == 0) left += s[1];
            else left -= s[1];
        }

        char[] arr = new char[n];
        for (int i = 0; i < n; i++)
            arr[i] = str.charAt((i + left % n + n) % n);

        return String.valueOf(arr);
    }
}
