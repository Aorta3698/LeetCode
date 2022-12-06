class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> ans = new HashSet<>();
        if (x == 1 || y == 1) {
            if (x + y == 2) {
                return bound >= 2? List.of(2) : List.of();
            }

            int m = x == 1? y : x;
            for (int i = 1; i + 1 <= bound; i *= m){
                ans.add(i + 1);
            }
            return new ArrayList<>(ans);
        }

        for (int i = 1; i <= bound; i *= x){
            for (int j = 1; i + j <= bound; j *= y){
                ans.add(i + j);
            }
        }

        return new ArrayList<>(ans);
    }
}
