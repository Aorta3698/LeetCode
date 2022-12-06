class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        HashSet<Integer> ans = new HashSet<>(Set.of(0, firstPerson));
        Arrays.sort(meetings, Comparator.comparingInt(o -> o[2]));
        int len = meetings.length;

        List<int[]> group = new ArrayList<>();
        for (int i = 0; i < len; i++){
            group.add(meetings[i]);
            if (i != len - 1 && meetings[i][2] == meetings[Math.min(len - 1, i + 1)][2])
                continue;

            HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
            Queue<Integer> queue = new LinkedList<>();
            HashSet<Integer> in = new HashSet<>();
            for (int[] m : group){
                map.computeIfAbsent(m[0], o -> new HashSet<>()).add(m[1]);
                map.computeIfAbsent(m[1], o -> new HashSet<>()).add(m[0]);
                if (ans.contains(m[0]) && in.add(m[0])) queue.offer(m[0]);
                if (ans.contains(m[1]) && in.add(m[1])) queue.offer(m[1]);
            }

            boolean[] seen = new boolean[n];
            while(!queue.isEmpty()){
                int p = queue.poll();
                if (seen[p] || !map.containsKey(p)) continue;
                seen[p] = true;
                for (int next : map.get(p)){
                    ans.add(next);
                    queue.offer(next);
                }
            }
            if (i == meetings.length - 1) break;
            group.clear();
        }

        return new ArrayList<>(ans);
    }
}
