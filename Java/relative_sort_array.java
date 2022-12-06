class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int step = 1001, len = 1001;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) map.put(arr2[i], i);
        for (int i = 0; i < arr1.length; i++) arr1[i] -= (len - map.getOrDefault(arr1[i], len)) * step;
        Arrays.sort(arr1);
        for (int i = 0; i < arr1.length; i++)
            arr1[i] += (len - map.getOrDefault((arr1[i] % step + step) % step, len)) * step;

        return arr1;
    }
}
