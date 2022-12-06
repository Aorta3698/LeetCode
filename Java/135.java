class Solution {
    public int candy(int[] ratings) {
        Integer[] idx = IntStream.range(0, ratings.length).boxed().toArray(Integer[]::new);
        Arrays.sort(idx, Comparator.comparingInt(o -> ratings[o]));
        int[] got = new int[ratings.length];
        for (int i = 0; i < idx.length; i++){
            int r = idx[i]==idx.length-1||ratings[idx[i]]<=ratings[idx[i]+1]?1:got[idx[i]+1]+1;
            int l = idx[i]==0||ratings[idx[i]]<=ratings[idx[i]-1]?1:got[idx[i]-1]+1;
            got[idx[i]]=Math.max(r,l);
        }

        return Arrays.stream(got).sum();
    }
}

class Solution {
    public int candy(int[] ratings) {
        int max = Arrays.stream(ratings).max().getAsInt()+1;
        List<Integer>[] all = new List[max];
        Arrays.setAll(all, o -> new ArrayList<>());
        for (int i = 0; i < ratings.length; i++){
            all[ratings[i]].add(i);
        }

        Arrays.fill(ratings, 0);
        for (int i = 0; i < max; i++){
            int[] next = new int[all[i].size()];
            List<Integer> cur = all[i];
            for (int j = 0; j < cur.size(); j++){
                int l = cur.get(j) == 0? 0 : ratings[cur.get(j) - 1];
                int r = cur.get(j) == ratings.length - 1? 0 : ratings[cur.get(j)+1];
                next[j] = Math.max(l,r)+1;
            }
            for (int j = 0; j < cur.size(); j++){
                ratings[cur.get(j)] = next[j];
            }
        }

        return Arrays.stream(ratings).sum();
    }
}
