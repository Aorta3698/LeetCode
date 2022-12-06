class Solution {
    public double calculateMaxInfoGain(double[] petal_length, String[] species) {
        int size = petal_length.length;
        List<List<Double>> all = new ArrayList<>();
        gen(0, petal_length, all, new LinkedList<>());
        int r = all.size() - 1;
        int l = 0;
        double min = Integer.MAX_VALUE;
        while(r > l){
            double subL = entropy(all.get(l))*all.get(l).size()/size;
            double subR = entropy(all.get(r))*all.get(r).size()/size;
            double sum = subL + subR;
            min = Math.min(sum, min);
            r--;
            l++;
        }

        return entropy(DoubleStream.of(petal_length).boxed().collect(Collectors.toList())) - min;
    }

    private double entropy(List<Double> input) {
        double ans = 0;
        HashMap<Double, Integer> map = new HashMap<>();
        for (Double i : input)
            map.merge(i, 1, Integer::sum);
        for (int i : map.values()){
            double p = (double)i / input.size();
            ans -= p * Math.log(p)/Math.log(2);
        }

        return ans;
    }

    private void gen(int n, double[] all, List<List<Double>> ans, LinkedList<Double> list){
        if (n == all.length){
            ans.add(new ArrayList<>(list));
            return;
        }

        gen(n + 1, all, ans, list);
        list.add(all[n]);
        gen(n + 1, all, ans, list);
        list.removeLast();
    }
}
