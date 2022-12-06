//Time Complexity O(n)
//Space Complexity O(n)
public int[] q5(int[] A) {
    Map<Integer, Integer> cntMap = new HashMap<>();
    List<Integer> ans = new ArrayList<>();
    for (int n : A) if (cntMap.merge(n, 1, Integer::sum) == 1) ans.add(n);
    return ans.stream().mapToInt(o -> o).toArray();
}
