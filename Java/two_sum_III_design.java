class TwoSum {
    private List<Integer> l;
    private HashSet<Integer> set;

    public TwoSum() {
        l = new ArrayList<>();
        set = new HashSet<>();
    }
    
    public void add(int number) {
        l.add(number);
        set.add(number);
    }
    
    public boolean find(int value) {
        if (l.size() < 2)
            return false;

        int count = 0;
        for (int i : l)
            if (set.contains(value - i)){
                if (value - i == i){
                    count++;
                    if (count == 2)
                        return true;
                }else
                    return true;
            }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
