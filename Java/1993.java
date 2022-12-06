class LockingTree {

    int[] parent;
    int[] nodes;
    Map<Integer, List<Integer>> down;
    public LockingTree(int[] parent) {
        this.parent = parent;
        nodes = new int[parent.length];
        down = new HashMap<>();
        for (int i = 0; i < parent.length; i++){
            down.computeIfAbsent(parent[i], o -> new ArrayList<>()).add(i);
        }
    }

    public boolean lock(int num, int user) {
        if (nodes[num] != 0) return false;
        nodes[num] = user;
        return true;
    }

    public boolean unlock(int num, int user) {
        if (nodes[num] != user) return false;
        nodes[num] = 0;
        return true;
    }

    public boolean upgrade(int num, int user) {
        if (nodes[num] != 0) return false;

        int p = parent[num];
        while(p != -1){
            if (nodes[p] != 0) return false;
            p = parent[p];
        }

        if (dfs(num)){
            nodes[num] = user;
            return true;
        }

        return false;
    }

    private boolean dfs(int num){
        boolean res = nodes[num] > 0;
        for (int child : down.getOrDefault(num, Collections.emptyList())){
            if (dfs(child)){
                res = true;
            }
        }
        if (res) nodes[num] = 0;
        return res;
    }
}

/**
 * Your LockingTree object will be instantiated and called as such:
 * LockingTree obj = new LockingTree(parent);
 * boolean param_1 = obj.lock(num,user);
 * boolean param_2 = obj.unlock(num,user);
 * boolean param_3 = obj.upgrade(num,user);
 */
