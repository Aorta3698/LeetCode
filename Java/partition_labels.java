class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        int idx = 0;
        char[] arr = s.toCharArray();

        while(idx < arr.length){
            HashSet<Character> seen = new HashSet<>(Set.of(arr[idx]));
            int start = idx;

            while(true){
                int end = 0;
                for (int i = idx + 1; i < arr.length; i++)
                    if (seen.contains(arr[i]))
                        end = i;

                if (end == 0) break;

                for (int i = idx + 1; i <= end; i++)
                    seen.add(arr[i]);

                idx = end;
            }

            idx++;
            ans.add(idx - start);
        }

        return ans;
    }
}
