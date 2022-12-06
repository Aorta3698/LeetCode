https://leetcode.com/problems/sort-items-by-groups-respecting-dependencies/discuss/2190316/Java-or-Topsort-or-Give-every-1-its-own-Group-ID
class Solution {
    public int[] sortItems(int n, int m, int[] grp, List<List<Integer>> beforeItems) {
        int[] ans = new int[n];
        Map<Integer, Map<Integer, Set<Integer>>> itemMap = new HashMap<>();
        Map<Integer, Set<Integer>> grpMap = new HashMap<>();
        for (int i = 0; i < n; i++){
            if (grp[i]==-1){
                grp[i]=m++;
            }
        }
        for (int i = 0; i < m; i++){
            grpMap.put(i, new HashSet<>());
            itemMap.put(i, new HashMap<>());
        }
        for (int i = 0; i < n; i++){
            itemMap.get(grp[i]).put(i, new HashSet<>());
        }
        for (int i = 0; i < beforeItems.size(); i++){
            for (int item : beforeItems.get(i)){
                if (grp[i]==grp[item]){
                    itemMap.get(grp[i]).get(item).add(i);
                }else{
                    grpMap.get(grp[item]).add(grp[i]);
                }
            }
        }

        int j = 0;
        for (int g : topSort(grpMap)){
            for (int item : topSort(itemMap.get(g))){
                ans[j++]=item;
            }
        }

        return j < ans.length? new int[]{} : ans;
    }

    private int[] topSort(Map<Integer, Set<Integer>> map){
        Map<Integer, Integer> indg = new HashMap<>();
        for (Set<Integer> values : map.values()){
            for (int m : values){
                indg.merge(m, 1, Integer::sum);
            }
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int key : map.keySet()){
            if (!indg.containsKey(key)){
                queue.offer(key);
            }
        }
        int j = 0;
        int[] ans = new int[map.size()];
        while(!queue.isEmpty()){
            int cur = queue.poll();
            ans[j++]=cur;
            for (int next : map.get(cur)){
                if (indg.merge(next, -1, Integer::sum)==0){
                    queue.offer(next);
                }
            }
        }

        return j == ans.length? ans : new int[]{};
    }
}
