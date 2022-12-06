/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class Solution {
    public void findSecretWord(String[] wordlist, Master master) {
        List<String> list = new ArrayList<>();
        for (String s : wordlist){
            list.add(s);
        }
        for (int i = 0; i < 10; i++){
            System.out.println(list.size());
            list = shuffle(list);
            int mid = list.size()/2;
            int res = master.guess(list.get(mid));
            List<String> next = new ArrayList<>();
            for (int j = 0; j < list.size(); j++){
                int cnt = 0;
                for (int k = 0; k < 6; k++){
                    if (list.get(j).charAt(k)==list.get(mid).charAt(k)){
                        cnt++;
                    }
                }
                if (cnt == res){
                    next.add(list.get(j));
                }
            }
            list=next;
        }
    }

    private List<String> shuffle(List<String> list){
        Random random = new Random();
        List<String> ans = new ArrayList<>();
        int[] idx = IntStream.range(0, list.size()).toArray();
        for (int i = 0; i < idx.length; i++){
            int j = random.nextInt(idx.length-i)+i;
            int tmp = idx[j];
            idx[j]=idx[i];
            idx[i]=tmp;
        }
        for (int i = 0; i < idx.length; i++){
            ans.add(list.get(idx[i]));
        }
        return ans;
    }
}
