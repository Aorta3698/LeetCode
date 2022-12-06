class Solution {
    public boolean checkString(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return Arrays.equals(arr, s.toCharArray());
    }
}
