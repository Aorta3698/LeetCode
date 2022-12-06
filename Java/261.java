class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<Integer>[] map = new ArrayList[n];
        Arrays.setAll(map, o -> new ArrayList<>());
        for (int[] e : edges){
            map[e[0]].add(e[1]);
            map[e[1]].add(e[0]);
        }
        BitSet seen = new BitSet();
        return n==0||dfs(0, -1, seen, map)&&seen.cardinality()==n;
    }

    private boolean dfs(int cur, int parent, BitSet seen, List<Integer>[] map){
        if (seen.get(cur)){
            return false;
        }
        seen.set(cur);
        for (int next : map[cur]){
            if (next != parent&&!dfs(next, cur, seen, map)){
                return false;
            }
        }
        return true;
    }
}

// union find
class Solution {
    public boolean validTree(int n, int[][] edges) {
        UF uf = new UF(n);
        for (int[] e : edges){
            if (!uf.union(e[0], e[1])){
                return false;
            }
        }
        return n==0||uf.size[uf.find(0)]==n;
    }

    private class UF {
        int[] size;
        int[] parent;
        UF (int n){
            size=new int[n];
            Arrays.fill(size,1);
            parent=IntStream.range(0,n).toArray();
        }
        int find(int x){
            return x==parent[x]?x:(parent[x]=find(parent[x]));
        }
        boolean union(int a, int b){
            a=find(a);
            b=find(b);
            if (a==b){
                return false;
            }
            if (size[a]>size[b]){
                size[a]+=size[b];
                parent[b]=a;
            }else{
                size[b]+=size[a];
                parent[a]=b;
            }
            return true;
        }
    }
}

// top sort
class Solution {
    public boolean validTree(int n, int[][] edges) {
        int[] indg = new int[n];
        int[] cnt = new int[n];
        int cur = 0;
        List<Integer>[] map = new ArrayList[n];
        Arrays.setAll(map, o -> new ArrayList<>());
        Arrays.fill(cnt, 1);
        for (int[] e : edges){
            map[e[0]].add(e[1]);
            map[e[1]].add(e[0]);
            indg[e[0]]++;
            indg[e[1]]++;
        }
        Queue<Integer> queue = new ArrayDeque<>(IntStream.range(0,n).filter(o->indg[o]==1).boxed().toList());
        while(!queue.isEmpty()){
            cur = queue.poll();
            for (int next : map[cur]){
                if (--indg[next]==1){
                    queue.offer(next);
                }
                cnt[next]+=cnt[cur];
            }
        }
        return cnt[cur]==n;
    }
}
