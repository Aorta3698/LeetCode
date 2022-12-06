class Solution {
    HashMap<Integer, List<String>> seen = new HashMap<>();
    public List<String> findStrobogrammatic(int n) {
        if (n <= 0) return new ArrayList<>(List.of(""));
        if (n == 1) return new ArrayList(List.of("0", "1", "8"));
        if (n == 2) return new ArrayList(List.of("11", "69", "88", "96"));
        if (seen.containsKey(n)) return seen.get(n);


        List<String> ans = new ArrayList<>();
        List<String> prev = new ArrayList<>();
        for (int i = n-2; i >= 0; i-=2){
            List<String> tmp = findStrobogrammatic(i);
            String leadingZero = "0".repeat((n - i) / 2 - 1);
            for (String s : tmp){
                StringBuilder sb = new StringBuilder();
                sb.append(leadingZero);
                sb.append(s);
                sb.append(leadingZero);
                prev.add(sb.toString());
            }
        }

        char[][] pairs = {{'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};
        for (String s : prev){
            for (char[] pair : pairs){
                StringBuilder sb = new StringBuilder();
                sb.append(pair[0]);
                sb.append(s);
                sb.append(pair[1]);
                ans.add(sb.toString());
            }
        }

        seen.put(n, ans);
        return ans;
    }
}
