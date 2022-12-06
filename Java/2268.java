class Solution {
    public int minimumKeypresses(String s) {
        int ans = 0;
        PriorityQueue<Integer> maxheap = new PriorityQueue<>();
        int[] count = new int[26];
        for (char ch : s.toCharArray()){
            count[ch - 'a']++;
        }
        Arrays.sort(count);
        for (int i = 25; i >= 0 && count[i] > 0; i--){
            maxheap.offer(-count[i]);
        }
        int n = 9;
        while(!maxheap.isEmpty()){
            ans -= maxheap.poll() * (n++ / 9);
        }
        return ans;
    }
}
