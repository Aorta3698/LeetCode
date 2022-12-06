class Solution {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> ans = new ArrayList<>();
        int[] t = new int[2001];
        for (int n : arr1) t[n]++;
        for (int n : arr2) t[n]++;
        for (int n : arr3) t[n]++;
        for (int i = 1; i <= 2000; i++)
            if (t[i] == 3)
                ans.add(i);

        return ans;
    }
}
