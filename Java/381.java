https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/discuss/2249636/Java-or-A-solution-without-hashset-or-O(1)-for-all.
class RandomizedCollection {

    Map<Integer, int[]> idMap;
    Map<Integer, List<Integer>> pMap;
    Random random;
    int top;
    public RandomizedCollection() {
        idMap=new HashMap<>();
        pMap=new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        pMap.computeIfAbsent(val, o -> new ArrayList<>()).add(top);
        idMap.put(top++, new int[]{val, pMap.get(val).size()-1});
        return pMap.get(val).size()==1;
    }

    public boolean remove(int val) {
        List<Integer> loc = pMap.get(val);
        if (loc==null||loc.isEmpty()){
            return false;
        }
        int free = loc.remove(loc.size()-1);
        if (free < --top){
            idMap.put(free, idMap.get(top));
            List<Integer> list = pMap.get(idMap.get(free)[0]);
            list.set(idMap.get(free)[1], free);
        }
        return true;
    }

    public int getRandom() {
        return idMap.get(random.nextInt(top))[0];
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
