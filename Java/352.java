https://leetcode.com/problems/data-stream-as-disjoint-intervals/discuss/2163644/Java-or-Follow-up-Question-greater-O(1)-Add-and-O(1)-Merge
class SummaryRanges {

    Map<Integer, int[]> st;
    Map<Integer, int[]> end;
    List<Integer> list;
    int[][] prev = new int[0][];
    Set<Integer> seen = new HashSet<>();
    int INVALID = -1;
    public SummaryRanges() {
        st = new HashMap<>();
        end= new HashMap<>();
        list = new ArrayList<>();
    }

    public void addNum(int val) {
        if (!seen.contains(val)){ // only add if not seen.
            list.add(val); // pending processing list
        }
    }

    public int[][] getIntervals() {
        Set<int[]> addSet = new HashSet<>();
        for (int n : list){
            if (seen.contains(n)){ // skip if seen
                continue;
            }
            seen.add(n);
            if (st.containsKey(n+1)&&end.containsKey(n-1)){ // merge intervals on both ends, a new interval form -> add to addSet
                int[] s = st.get(n+1);
                int[] e = end.get(n-1);
                int[] m = new int[]{e[0], s[1]};
                st.remove(n+1);
                end.remove(n-1);
                st.put(m[0], m);
                end.put(m[1], m);
                s[0]=e[0]=INVALID;
                addSet.remove(s); // may be in addSet, remove them
                addSet.remove(e);
                addSet.add(m);
            }else if (st.containsKey(n+1)){ // merge with the next interval, no other action required.
                st.get(n+1)[0]--;
                st.put(n, st.get(n+1));
                st.remove(n+1);
            }else if (end.containsKey(n-1)){ // merge with the previous interval, no other action required.
                end.get(n-1)[1]++;
                end.put(n, end.get(n-1));
                end.remove(n-1);
            }else{ // new interval -> add to AddSet
                int[] m = new int[]{n, n};
                addSet.add(m);
                st.put(n, m);
                end.put(n, m);
            }
        }

        list.clear(); // remember to clear the pending list.
        if (!addSet.isEmpty()){ // Use 2 pointers technique to populate a new list if there is a new interval to insert.
            List<int[]> addList = new ArrayList<>(addSet);
            addList.sort(Comparator.comparingInt(o -> o[0]));
            int i = 0, j = 0;
            List<int[]> ans = new ArrayList<>();
            while(i < prev.length || j < addList.size()){
                if (i < prev.length && prev[i][0]==INVALID){
                    i++;
                }else if (j == addList.size() || i < prev.length && prev[i][0]<addList.get(j)[0]){
                    ans.add(prev[i++]);
                }else if (i == prev.length || prev[i][0]>addList.get(j)[0]){
                    ans.add(addList.get(j++));
                }
            }
            prev = ans.toArray(new int[0][]);
        }

        return prev;
    }
}



class SummaryRanges {

    TreeMap<Integer, int[]> st;
    TreeMap<Integer, int[]> end;
    List<Integer> list;
    int[][] prev = new int[0][];
    public SummaryRanges() {
        st = new TreeMap<>();
        end= new TreeMap<>();
        list = new ArrayList<>();
    }

    public void addNum(int val) {
        list.add(val);
    }

    public int[][] getIntervals() {
        List<int[]> add = new ArrayList<>();
        for (int n : list){
            Integer lo = st.floorKey(n);
            Integer hi = end.ceilingKey(n);
            if (hi != null && lo != null && st.get(lo)==end.get(hi)){
                continue;
            }
            if (st.containsKey(n+1)&&end.containsKey(n-1)){
                int[] s = st.get(n+1);
                int[] e = end.get(n-1);
                int[] m = new int[]{e[0], s[1]};
                st.remove(n+1);
                end.remove(n-1);
                st.put(m[0], m);
                end.put(m[1], m);
                s[0]=e[0]=-1;
                add.add(m);
            }else if (st.containsKey(n+1)){
                st.get(n+1)[0]--;
                st.put(n, st.get(n+1));
                st.remove(n+1);
            }else if (end.containsKey(n-1)){
                end.get(n-1)[1]++;
                end.put(n, end.get(n-1));
                end.remove(n-1);
            }else{
                int[] m = new int[]{n, n};
                add.add(m);
                st.put(n, m);
                end.put(n, m);
            }
        }

        list.clear();
        if (!add.isEmpty()){
            add.sort(Comparator.comparingInt(o -> o[0]));
            int i = 0, j = 0;
            List<int[]> ans = new ArrayList<>();
            while(i < prev.length || j < add.size()){
                if (i < prev.length && prev[i][0]==-1){
                    i++;
                }else if (j < add.size() && add.get(j)[0]==-1){
                    j++;
                }else if (j == add.size() || i < prev.length && prev[i][1]+1<add.get(j)[0]){
                    ans.add(prev[i++]);
                }else if (i == prev.length || i < prev.length && prev[i][0]-1>add.get(j)[1]){
                    ans.add(add.get(j++));
                }
                // if (i < prev.length){
                //     System.out.println("prev = " + Arrays.toString(prev[i]));
                // }
                // if (j < add.size()){
                //     System.out.println("add = " + Arrays.toString(add.get(j)));
                // }
            }
            prev = ans.toArray(new int[0][]);
        }

        return prev;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * int[][] param_2 = obj.getIntervals();
 */
