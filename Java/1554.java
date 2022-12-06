class Solution {
    public boolean differByOne(String[] dict) {
        Set<String> seen = new HashSet<>();
        for (String s : dict){
            char[] arr = s.toCharArray();
            for (int i = 0; i < arr.length; i++){
                arr[i] = '0';
                if (!seen.add(String.valueOf(arr))) return true;
                arr[i] = s.charAt(i);
            }
        }

        return false;
    }
}
