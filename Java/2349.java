class NumberContainers {

    Map<Integer, Integer> idxMap;
    Map<Integer, TreeSet<Integer>> smallMap;
    public NumberContainers() {
        idxMap = new HashMap<>();
        smallMap = new HashMap<>();
    }

    public void change(int index, int number) {
        if (idxMap.containsKey(index)){
            smallMap.get(idxMap.get(index)).remove(index);
            if (smallMap.get(idxMap.get(index)).isEmpty()){
                smallMap.remove(idxMap.get(index));
            }
        }
        idxMap.put(index, number);
        smallMap.computeIfAbsent(number, o -> new TreeSet<>()).add(index);
    }

    public int find(int number) {
        return !smallMap.containsKey(number)? -1 : smallMap.get(number).first();
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */
