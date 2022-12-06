class Solution {
    public boolean checkRecord(String str) {
        char[] arr = str.toCharArray();
        for (int i = 0, s = -1, ab = 0; i < arr.length; i++){
            if (arr[i] == 'A' && ++ab == 2) return false;
            if (s == -1 && arr[i] == 'L') s = i;
            if (s != -1 && (arr[i] != 'L' || i == arr.length - 1)){
                if (i - s + (arr[i] == 'L'? 1 : 0) >= 3) return false;
                s = -1;
            }
        }

        return true;
    }
}
