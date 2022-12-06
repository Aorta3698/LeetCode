class Solution {
    public String sortString(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        HashSet<Integer> idxSet = new HashSet<>();
        while(idxSet.size() != arr.length){
            char prev = ' ';
            for (int i = 0; i < arr.length; i++){
                if (idxSet.contains(i) || prev == arr[i]) continue;
                prev = arr[i];
                sb.append(prev);
                idxSet.add(i);
            }

            prev = ' ';
            for (int i = arr.length - 1; i >= 0; i--){
                if (idxSet.contains(i) || prev == arr[i]) continue;
                prev = arr[i];
                sb.append(prev);
                idxSet.add(i);
            }
        }

        return sb.toString();
    }
}
