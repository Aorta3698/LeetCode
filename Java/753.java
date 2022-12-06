class Solution {
    public String crackSafe(int n, int k) {
        List<String> list = new ArrayList<>();
        gen(n, k, list, new StringBuilder());
        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<Integer, Integer> hashMap = new HashMap<>();
        int h = (int)Math.pow(17, n - 1);

        for (int i = 0; i < list.size(); i++){
            hashMap.put(i, hash(list.get(i)));
        }

        for (int i = 0; i < list.size(); i++){
            for (int j = i + 1; j < list.size(); j++){
                if (back(hashMap, list, i, h) == front(hashMap, list, j)){
                    map.computeIfAbsent(i, o -> new ArrayList<>()).add(j);
                }
                if (back(hashMap, list, j, h) == front(hashMap, list, i)){
                    map.computeIfAbsent(j, o -> new ArrayList<>()).add(i);
                }
            }
        }

        int[] ans = new int[list.size()];
        dfs(0, map, ans, 0, new boolean[list.size()]);

        StringBuilder sb = new StringBuilder();
        sb.append(list.get(ans[0]));
        for (int i = 1; i < ans.length; i++){
            sb.append(list.get(ans[i]).charAt(list.get(ans[i]).length() - 1));
        }

        return sb.toString();
    }

    private boolean dfs(int idx, Map<Integer, List<Integer>> map, int[] ans, int j, boolean[] seen){
        if (j == ans.length){
            return true;
        }

        for (int next : map.getOrDefault(idx, Collections.emptyList())){
            if (seen[next]) continue;
            ans[j] = next;
            seen[next] = true;
            if (dfs(next, map, ans, j + 1, seen)) return true;
            seen[next] = false;
        }

        return false;
    }

    private void gen(int n, int k, List<String> ans, StringBuilder sb){
        if (sb.length() == n){
            ans.add(sb.toString());
            return;
        }

        for (int i = 0; i < k; i++){
            sb.append(i);
            gen(n, k, ans, sb);
            sb.setLength(sb.length() - 1);
        }
    }

    private int hash(String s){
        int hash = 0;
        for (char ch : s.toCharArray()){
            hash *= 17;
            hash += ch;
        }
        return hash;
    }

    private int back(Map<Integer, Integer> map, List<String> list, int idx, int h){
        return map.get(idx) - h * list.get(idx).charAt(0);
    }

    private int front(Map<Integer, Integer> map, List<String> list, int idx){
        return (map.get(idx) - list.get(idx).charAt(list.get(idx).length() - 1)) / 17;
    }
}
