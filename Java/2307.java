https://leetcode.com/problems/check-for-contradictions-in-equations/discuss/2197625/Java-or-Union-Find-or-9ms-(100-speed)-or-Explained.
class Solution {
    public boolean checkContradictions(List<List<String>> equations, double[] values) {
        UF uf = new UF(equations.size()*2);
        Map<String, Integer> idMap = new HashMap<>();
        for (int i = 0; i < values.length; i++){
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            idMap.putIfAbsent(a, idMap.size());
            idMap.putIfAbsent(b, idMap.size());
            if (uf.tryUnion(idMap.get(a), idMap.get(b), values[i])){
                return true;
            }
        }
        return false;
    }

    private class UF {
        double[] weights;
        int[] parent;
        int[] rank;
        UF (int n){
            weights = new double[n];
            Arrays.fill(weights, 1);
            rank = new int[n];
            parent = IntStream.range(0, n).toArray();
        }

        private int find(int x){
            if (x != parent[x]){
                int root = find(parent[x]);
                weights[x] *= weights[parent[x]];
                parent[x] = root;
            }
            return parent[x];
        }

        private boolean tryUnion(int x, int y, double v){
            int xRoot = find(x);
            int yRoot = find(y);
            if (xRoot == yRoot) {
                return Math.abs(weights[x]/weights[y] - v) >= 1e-5;
            }
            if (rank[xRoot]>rank[yRoot]){
                parent[yRoot]=xRoot;
                weights[yRoot] = 1/v * weights[x] / weights[y];
            }else{
                parent[xRoot]=yRoot;
                weights[xRoot] = v * weights[y] / weights[x];
                if (rank[xRoot]==rank[yRoot]){
                    rank[yRoot]++;
                }
            }
            return false;
        }
    }
}
// class Solution {
//     public boolean checkContradictions(List<List<String>> equations, double[] values) {
//         Map<String, Map<String, Double>> map = new HashMap<>();
//         for (int i = 0; i < equations.size(); i++){
//             String a = equations.get(i).get(0);
//             String b = equations.get(i).get(1);
//             if (a.equals(b) && diff(values[i], 1)){
//                 return true;
//             }
//             if (map.computeIfAbsent(a, o -> new HashMap<>()).containsKey(b) && diff(map.get(a).get(b), values[i])){
//                 return true;
//             }
//             if (map.computeIfAbsent(b, o -> new HashMap<>()).containsKey(a) && diff(map.get(b).get(a), 1/values[i])){
//                 return true;
//             }
//             map.get(a).put(b, values[i]);
//             map.get(b).put(a, 1/values[i]);
//         }

//         Map<String, Double> valMap = new HashMap<>();
//         for (String key : map.keySet()){
//             if (dfs(key, 1, key, new HashSet<>(), valMap, map)){
//                 return true;
//             }
//         }

//         return false;
//     }

//     private boolean dfs(String cur,
//                         double val,
//                         String st,
//                         Set<String> seen,
//                         Map<String, Double> valMap,
//                         Map<String, Map<String, Double>> map){
//         if (seen.contains(cur))
//             return false;
//         seen.add(cur);
//         Map<String, Double> curMap = map.getOrDefault(cur, Map.of());
//         for (String next : curMap.keySet()){
//             double nval = val * curMap.get(next);
//             String id = st+"/"+next;
//             if (valMap.containsKey(id) && diff(valMap.get(id), nval)){
//                 return true;
//             }
//             valMap.put(id, nval);
//             if (dfs(next, nval, st, seen, valMap, map)){
//                 return true;
//             }
//         }
//         return false;
//     }

//     private boolean diff(double a, double b){
//         a*=100000;
//         b*=100000;
//         int x = (int)a;
//         int y = (int)b;
//         double dx = a-x;
//         double dy = b-y;
//         if (Math.abs(dx-dy)>0.0001 && Math.abs(x-y)<=1)
//             return false;
//         return x!=y;
//     }
// }
