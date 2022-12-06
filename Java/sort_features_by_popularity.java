class Solution {
    public String[] sortFeatures(String[] features, String[] responses) {
        Map<String, Integer> featToIdx = new HashMap<>();
        Map<String, Integer> featToFreq = new HashMap<>();

        Comparator<String> comp = (a, b) -> {
            return featToFreq.get(a) == featToFreq.get(b)?
                featToIdx.get(a) - featToIdx.get(b)
                : featToFreq.get(b) - featToFreq.get(a);
        };

        for (int i = 0; i < features.length; i++){
            featToIdx.put(features[i], i);
            featToFreq.put(features[i], 0);
        }

        for (String res : responses){
            Set<String> set = new HashSet<>();
            for (String word : res.split(" ")){
                if (featToIdx.containsKey(word) && set.add(word))
                    featToFreq.put(word, featToFreq.get(word) + 1);
            }
        }

        Arrays.sort(features, comp);
        return features;
    }
}
