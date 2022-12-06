class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        Integer[] idx = IntStream.range(0, dist.length).boxed().toArray(Integer[]::new);
        Arrays.sort(idx, Comparator.comparingDouble(o -> 1.0*dist[o]/speed[o]));
        for (int i = 0; i < dist.length; i++){
            if (1.0*dist[idx[i]]/speed[idx[i]] <= i)
                return i;
        }
        return dist.length;
    }
}
