class Solution {
    public int numSplits(String s) {
        char[] arr = s.toCharArray();
        HashMap<Integer, Integer> frontMap = new HashMap<>();
        HashMap<Integer, Integer> backMap = new HashMap<>();
        HashSet<Character> frontSet = new HashSet<>();
        HashSet<Character> backSet = new HashSet<>();

        for (int i = 0; i < arr.length; i++){
            int j = arr.length - 1 - i;
            frontSet.add(arr[i]);
            backSet.add(arr[j]);
            frontMap.put(i, frontSet.size());
            backMap.put(j, backSet.size());
        }

        int count = 0;
        for (int i = 0; i < arr.length - 1; i++)
            if (frontMap.get(i) == backMap.get(i + 1)) count++;

        return count;
    }
}
