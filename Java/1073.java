class Solution {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        int n = arr1.length, m = arr2.length;
        int[] line = new int[Math.max(n, m) + 3];
        for (int i = n - 1, j = m - 1, k = line.length - 1; k > 2 ; i--, j--, k--){
            int a = i < 0? 0 : arr1[i], b = j < 0? 0 : arr2[j];
            while (line[k] + a + b >= 2){
                line[k] -= 2;
                if (line[k - 1] > 0){
                    line[k - 1]--;
                }else{
                    line[k - 1]++;
                    line[k - 2]++;
                }
            }
            line[k] += a + b;
        }
        int z = 0;
        while(z < line.length && line[z] == 0){
            ++z;
        }
        int[] ans = new int[Math.max(1, line.length - z)];
        for (int i = z, j = 0; i < line.length; i++, j++){
            ans[j] = line[i];
        }

        return ans;
    }
}
