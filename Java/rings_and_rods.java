class Solution {
    public int countPoints(String rings) {
        int[] count = new int[10];
        HashMap<Character, Integer> map = new HashMap<>(Map.of('R', 0, 'G', 1, 'B', 2));
        int ans = 0;
        for (int i = 0; i < rings.length(); i+=2){
            int rod = rings.charAt(i + 1) - '0';
            if (count[rod] == 7) continue;
            int color = map.get(rings.charAt(i));
            count[rod] |= 1 << color;
            if (count[rod] == 7) ans++;
        }

        return ans;
    }
}
