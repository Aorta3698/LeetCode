class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int[] copy = new int[deck.length * 2];
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < deck.length; i++){
            indexMap.put(deck[i], i);
            copy[i] = deck[i];
        }

        int[] order = new int[deck.length];
        int last = deck.length;
        int count = 0;
        for (int i = 0; copy[i] != 0; i++){
            if (i % 2 == 0) order[indexMap.get(copy[i])] = count++;
            else copy[last++] = copy[i];
        }

        int[] ans = new int[deck.length];
        count = 0;
        Arrays.sort(deck);
        while(count < deck.length){
            for (int i = 0; i < ans.length; i++)
                if (count == order[i])
                    ans[i] = deck[count++];
        }

        return ans;
    }
}
