class Solution {
    public String originalDigits(String s) {
        char[] arr = s.toCharArray();
        int[] count = new int[10];
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == 'z') count[0]++;
            if (arr[i] == 'w') count[2]++;
            if (arr[i] == 'u') count[4]++;
            if (arr[i] == 'x') count[6]++;
            if (arr[i] == 'g') count[8]++;
            if (arr[i] == 's') count[7]++;
            if (arr[i] == 'f') count[5]++;
            if (arr[i] == 'h') count[3]++;
            if (arr[i] == 'o') count[1]++;
            if (arr[i] == 'i') count[9]++;
        }
        count[7] -= count[6];
        count[5] -= count[4];
        count[3] -= count[8];
        count[1] -= (count[0] + count[2] + count[4]);
        count[9] -= (count[5] + count[6] + count[8]);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count.length; i++){
            sb.append(String.valueOf(i).repeat(count[i]));
        }

        return sb.toString();
    }
}
