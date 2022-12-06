class Solution {
    public String customSortString(String order, String s) {
        int i = 0;
        int[] od = new int[26];
        for (char ch : order.toCharArray()) od[ch - 'a'] = i++;

        Character[] arr = new Character[s.length()];
        i = 0;
        for (char ch : s.toCharArray()) arr[i++] = ch;
        Arrays.sort(arr, Comparator.comparingInt(o -> od[o - 'a']));

        StringBuilder sb = new StringBuilder();
        for (Character ch : arr) sb.append(ch);
        return sb.toString();
    }
}
