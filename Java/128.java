class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int n : nums){
            seen.add(n);
        }
        int ans = 0;
        for (int key : seen){
            if (!seen.contains(key-1)){
                int cnt = 0;
                while(seen.contains(key)){
                    cnt++;
                    key++;
                }
                ans=Math.max(ans, cnt);
            }
        }
        return ans;
    }
}


// UNION FIND
class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] size = new int[nums.length];
        int[] parent = IntStream.range(0, nums.length).toArray();
        // Arrays.fill(size, 1);

        int ans = Math.min(1, nums.length);
        for (int n : nums){
            map.putIfAbsent(n, map.size());
            if (map.containsKey(n - 1)){
                ans = Math.max(union(map.get(n), map.get(n - 1), parent, size), ans);
            }
            if (map.containsKey(n + 1)){
                ans = Math.max(union(map.get(n), map.get(n + 1), parent, size), ans);
            }
        }
        return ans;
    }

    private int find(int x, int[] parent){
        return parent[x] == x? x : (parent[x] = find(parent[x], parent));
    }

    private int union(int x, int y, int[] parent, int[] size){
        x = find(x, parent);
        y = find(y, parent);
        if (x == y) return 0;
        if (size[x] == 0) size[x] = 1;
        if (size[y] == 0) size[y] = 1;
        if (size[x] > size[y]){
            size[x] += size[y];
            parent[y] = x;
        }else{
            size[y] += size[x];
            parent[x] = y;
        }
        return Math.max(size[x], size[y]);
    }
}
