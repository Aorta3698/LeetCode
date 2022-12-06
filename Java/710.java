class Solution {

    private Set<Integer> ban;
    private Map<Integer, Integer> map;
    private Random random;
    private int sz;
    public Solution(int n, int[] blacklist) {
        ban = new HashSet<>();
        map = new HashMap<>();
        random = new Random();
        sz = n - blacklist.length;
        int end = n - 1;

        for (int b : blacklist){
            ban.add(b);
        }
        for (int b : blacklist){
            if (b < sz){
                while(ban.contains(end)) end--;
                map.put(b, end--);
            }
        }
    }

    public int pick() {
        int ret = random.nextInt(sz);
        return map.getOrDefault(ret, ret);
    }
}
