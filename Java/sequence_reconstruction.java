class Solution {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        if (seqs.size() == 0) return false;

        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i : org) set.add(i);

        for(List<Integer> s : seqs){
            for (int i = 0; i < s.size(); i++){
                if (i != 0) map.computeIfAbsent(s.get(i-1), o -> new HashSet<>()).add(s.get(i));
                if (!set.contains(s.get(i))) return false;
            }
        }

        int[] ind = new int[org.length + 1];
        for (Set<Integer> list : map.values())
            for (int v : list)
                ind[v]++;

        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        for (int i = 1; i < ind.length; i++) if (ind[i] == 0) queue.offer(i);
        while(!queue.isEmpty()){
            int idx = queue.poll();
            if (!queue.isEmpty() || org[count] != idx) return false;
            count++;

            if (map.containsKey(idx))
                for (int v : map.get(idx))
                    if (--ind[v] == 0) queue.offer(v);
        }

        return count == org.length;
    }
}
