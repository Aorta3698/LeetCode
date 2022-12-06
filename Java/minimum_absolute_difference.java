class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE, n = arr.length;
        for (int i = 1; i < n; i++)
            min = Math.min(Math.abs(arr[i] - arr[i - 1]), min);
        for (int i = 1; i < n; i++)
            if (Math.abs(arr[i] - arr[i - 1]) == min)
                ans.add(List.of(arr[i - 1], arr[i]));

        return ans;
    }
}
