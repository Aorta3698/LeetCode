class Solution {
    public int[] groupStrings(String[] words) {
        Map<Integer, Integer> map = new HashMap<>();
        UF uf = new UF(words.length);
        for (int i = 0; i < words.length; i++){
            int hash = 0;
            for (int j = 0; j < words[i].length(); j++){
                hash |= (1<<words[i].charAt(j)-'a');
            }
            if (map.containsKey(hash)){
                uf.union(i, map.get(hash));
            }else{
                map.put(hash, i);
            }
            for (int j = 0; j<26;j++){
                // int del = hash & (~0^(1<<j));
                int del = hash ^ (1<<j);
                if (del >= hash){
                    continue;
                }
                if (map.containsKey(del)){
                    uf.union(map.get(del), i);
                }else{
                    map.put(del, i);
                }
            }
        }

        return new int[]{uf.sz, uf.maxGroup()};
    }

    private class UF {
        int[] parent;
        int[] size;
        int sz;
        UF (int n){
            parent = IntStream.range(0, n).toArray();
            size = new int[n];
            Arrays.fill(size, 1);
            sz = n;
        }

        int find(int x){
            return x == parent[x]? x : (parent[x]=find(parent[x]));
        }

        int maxGroup(){
            int ans = 0;
            for (int i = 0; i < size.length; i++){
                ans = Math.max(ans, size[i]);
            }
            return ans;
        }

        void union(int x, int y){
            x = find(x);
            y = find(y);
            if (x ==y )
                return;
            if (size[x]>size[y]){
                parent[y]=x;
                size[x]+=size[y];
            }else{
                parent[x]=y;
                size[y]+=size[x];
            }
            sz--;
        }
    }
}
// class Solution {
//     public int[] groupStrings(String[] words) {
//         Map<Integer, Integer> map = new HashMap<>();
//         UF uf = new UF(words.length);
//         for (int i = 0; i < words.length; i++){
//             int hash = 0;
//             for (char ch : words[i].toCharArray()){
//                 hash |= 1 << (ch-'a');
//             }
//             if (map.containsKey(hash)){
//                 uf.union(i, map.get(hash));
//             }else{
//                 map.put(hash, i);
//             }
//         }
//         for (int key : map.keySet()){
//             int cur = map.get(key);
//             for (int i = 0; i < 26; i++){
//                 Integer add = map.get(key | (1<<i));
//                 if (add!=null){
//                     uf.union(cur, add);
//                 }
//             }
//             for (int i = 0; i < 26; i++){
//                 if ((key & (1 << i)) == 0){
//                     continue;
//                 }
//                 key ^= (1<<i);
//                 for (int j = 0; j < 26; j++){
//                     Integer rep = map.get(key|(1<<j));
//                     if (rep != null){
//                         uf.union(cur, rep);
//                     }
//                 }
//                 key ^= (1<<i);
//             }
//         }

//         return new int[]{uf.sz, uf.maxGroup()};
//     }

//     private class UF {
//         int[] parent;
//         int[] size;
//         int sz;
//         UF (int n){
//             parent = IntStream.range(0, n).toArray();
//             size = new int[n];
//             Arrays.fill(size, 1);
//             sz = n;
//         }

//         int find(int x){
//             return x == parent[x]? x : (parent[x]=find(parent[x]));
//         }

//         int maxGroup(){
//             int ans = 0;
//             for (int i = 0; i < size.length; i++){
//                 ans = Math.max(ans, size[i]);
//             }
//             return ans;
//         }

//         void union(int x, int y){
//             x = find(x);
//             y = find(y);
//             if (x ==y )
//                 return;
//             if (size[x]>size[y]){
//                 parent[y]=x;
//                 size[x]+=size[y];
//             }else{
//                 parent[x]=y;
//                 size[y]+=size[x];
//             }
//             sz--;
//         }
//     }
// }
