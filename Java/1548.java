https://leetcode.com/problems/the-most-similar-path-in-a-graph/discuss/2185092/Try-ALL-pairs-with-DP-O(nnm)-or-84ms-(97)-or-Java-or-Fully-Commented-and-Explained.
class Solution {
    public List<Integer> mostSimilar(int n, int[][] roads, String[] names, String[] targetPath) {
        int m = targetPath.length;
        int[] cities = new int[n];
        int[] target = new int[m];
        for (int i = 0 ; i< n; i++){
            cities[i] = hash(names[i]);
        }
        for (int i = 0 ; i < m; i++){
            target[i]=hash(targetPath[i]);
        }

        boolean[][] ok = new boolean[n][n];
        for (int[] r : roads){
            ok[r[0]][r[1]]=ok[r[1]][r[0]]=true;
        }
        int[] dp = new int[n];
        int[][] parent = new int[m][n];
        for (int i = 0; i < n; i++){
            dp[i] = cities[i] == target[0]? 0 : 1;
        }

        for (int i = 1; i < m; i++){
            int[] next = new int[n];
            Arrays.fill(next, 10000);
            for (int j = 0; j < n; j++){
                for (int k = 0; k < n; k++){
                    if (ok[j][k]||ok[k][j]){
                        int res = dp[j] + (cities[k]==target[i]? 0 : 1);
                        if (res < next[k]){
                            next[k] = res;
                            parent[i][k]=j;
                        }
                    }
                }
            }
            dp = next;
        }

        LinkedList<Integer> ans = new LinkedList<>();
        int min = Arrays.stream(dp).min().getAsInt();
        for (int i = 0; i < n; i++){
            if (dp[i]==min){
                while(ans.size()<target.length){
                    ans.addFirst(i);
                    i = parent[--m][i];
                }
                break;
            }
        }

        return ans;
    }

    private int hash(String s){
        int h = 0;
        for (char ch : s.toCharArray()){
            h = h * 31 + ch - 'a' + 1;
        }
        return h;
    }
}

// class Solution {
//     public List<Integer> mostSimilar(int n, int[][] roads, String[] names, String[] targetPath) {
//         int[] target = new int[targetPath.length];
//         City[] cities = new City[names.length];
//         Map<City, List<City>> map = new HashMap<>();
//         for (int i = 0; i < target.length; i++){
//             target[i] = hash(targetPath[i]);
//         }
//         City dummy = new City();
//         for (int i = 0 ; i < names.length; i++){
//             cities[i] = new City(i, hash(names[i]));
//             map.computeIfAbsent(dummy, o -> new ArrayList<>()).add(cities[i]);
//         }
//         for (int[] r : roads){
//             map.computeIfAbsent(cities[r[0]], o -> new ArrayList<>()).add(cities[r[1]]);
//             map.computeIfAbsent(cities[r[1]], o -> new ArrayList<>()).add(cities[r[0]]);
//         }

//         Path ans = new Path();
//         dfs(dummy, 0, cities, target, new ArrayList<>(), ans, map);
//         return ans.path;
//         // int best = 10000;
//         // List<Integer>[] ans = new ArrayList[1];
//         // for (int i = 0; i < n; i++){
//         //     best = Math.min(best, dfs(cities[i], 0, best, cities, target, new ArrayList<>(), ans, map));
//         // }

//         // return ans[0];
//     }

//     private void dfs(City cur, int miss, City[] cities, int[] target, List<Integer> tmp, Path ans, Map<City, List<City>> map){
//         if (miss >= ans.best)
//             return;
//         if (tmp.size()==target.length){
//             ans.path = new ArrayList<>(tmp);
//             ans.best = miss;
//             return;
//         }
//         for (City next : map.get(cur)){
//             tmp.add(next.idx);
//             dfs(next, miss + (next.hash==target[tmp.size()-1]? 0 : 1), cities, target, tmp, ans, map);
//             tmp.remove(tmp.size()-1);
//         }
//     }
//     // private int dfs(City cur, int miss, int best, City[] cities, int[] target, List<Integer> tmp, List<Integer>[] ans, Map<City, List<City>> map){
//     //     if (cur.hash != target[tmp.size()] && ++miss >= best){
//     //         return 1000;
//     //     }
//     //     tmp.add(cur.idx);
//     //     if (tmp.size()==target.length){
//     //         ans[0] = new ArrayList<>(tmp);
//     //         return miss;
//     //     }
//     //     for (City next : map.get(cur)){
//     //         best = Math.min(best, dfs(next, miss, best, cities, target, tmp, ans, map));
//     //     }
//     //     tmp.remove(tmp.size()-1);
//     //     return best;
//     // }

//     private int hash(String s){
//         int h = 0;
//         for (char ch : s.toCharArray()){
//             h = h * 31 + ch - 'a' + 1;
//         }
//         return h;
//     }

//     private class Path {
//         List<Integer> path;
//         int best = 10000;
//         Path(){}
//     }

//     private class City {
//         int hash;
//         int idx;
//         City(int idx, int hash){
//             this.idx=idx;
//             this.hash=hash;
//         }
//         City(){}
//     }
// }
