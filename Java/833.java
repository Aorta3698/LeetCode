class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        Item[] arr = new Item[sources.length];
        for (int i = 0; i < arr.length; i++){
            arr[i] = new Item(indices[i], sources[i], targets[i]);
        }
        Arrays.sort(arr, Comparator.comparingInt(o -> o.idx));

        StringBuilder sb = new StringBuilder();
        for (int i = 0, j = 0; i < s.length(); i++){
            if (j == arr.length || i != arr[j].idx){
                sb.append(s.charAt(i));
            }else{
                boolean match = s.substring(i, Math.min(s.length(), i + arr[j].source.length())).equals(arr[j].source);
                if (match){
                    i += arr[j].source.length() - 1;
                }
                sb.append(match? arr[j].target : s.charAt(i));
                j++;
            }
        }

        return sb.toString();
    }

    private class Item{
        int idx;
        String source;
        String target;
        Item (int idx, String source, String target){
            this.idx = idx;
            this.source = source;
            this.target = target;
        }
    }
}
