class Solution {
    Map<Character, Integer> map = new HashMap<>();
    public String similarRGB(String color) {
        StringBuilder sb = new StringBuilder("#");
        char[] arr = color.toCharArray();
        for (int i = -1; i < 7; i++) map.put((char)('a' + i), 10 + i);
        for (int i = -1; i < 11; i++) map.put((char)('0' + i), i);
        find(arr, 1, 2, sb, map);
        find(arr, 3, 4, sb, map);
        find(arr, 5, 6, sb, map);
        return sb.toString();
    }

    private void find(char[] arr, int lo, int hi, StringBuilder sb, Map<Character, Integer> map){
        int val = map.get(arr[lo]) * 16 + map.get(arr[hi]), min = Integer.MAX_VALUE;
        char ans = ' ';

        for (int i = 0; i < 3; i++){
            int cur = 17 * map.get((char)(arr[lo] - 1 + i));
            int diff = (cur - val) * (cur - val);
            if (diff < min) {
                min = diff;
                ans = (char)(arr[lo] - 1 + i);
            }
        }

        if (ans == (char)('9' + 1)) ans = 'a';
        if (ans == (char)('a' - 1)) ans = '9';
        sb.append(ans);
        sb.append(ans);
    }
}
