class Solution {
    public boolean isPathCrossing(String path) {
        Set<Integer> seen = new HashSet<>(Set.of(0));
        Map<Character, Integer> xMap = new HashMap<>(Map.of('N', 1, 'S', -1, 'E', 0, 'W', 0));
        Map<Character, Integer> yMap = new HashMap<>(Map.of('N', 0, 'S', 0, 'E', 1, 'W', -1));
        int x = 0, y = 0, COLS = 10001;

        for (char ch : path.toCharArray()){
            x += xMap.get(ch);
            y += yMap.get(ch);
            if(!seen.add(x * COLS + y))
                return true;
        }

        return false;
    }
}
