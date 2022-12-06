https://leetcode.com/problems/push-dominoes/discuss/1620903/java-simple-to-understand-detailed-explanations
class Solution {
    public String pushDominoes(String dominoes) {
        char[] arr = dominoes.toCharArray();
        int[] distRight = new int[arr.length];
        int[] distLeft  = new int[arr.length];

        for (int i = 0; i < arr.length - 1; i++){
            if (arr[i + 1] != '.') continue;
            if (distRight[i] != 0 || arr[i] == 'R') distRight[i + 1] = distRight[i] + 1;
        }

        for (int i = arr.length - 1; i > 0; i--){
            if (arr[i - 1] != '.') continue;
            if (distLeft[i] != 0 || arr[i] == 'L') distLeft[i - 1] = distLeft[i] + 1;
        }

        for (int i = 0; i < arr.length; i++){
            if (arr[i] != '.' || distRight[i] == distLeft[i]) continue;
            if (distRight[i] == 0) {arr[i] = 'L'; continue;}
            if (distLeft[i]  == 0) {arr[i] = 'R'; continue;}
            arr[i] = distRight[i] < distLeft[i]? 'R' : 'L';
        }

        return new String(arr);
    }
}
