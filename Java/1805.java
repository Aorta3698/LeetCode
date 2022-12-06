class Solution {
    public int numDifferentIntegers(String word) {
        Set<String> set = new HashSet<>();
        int i = 0;
        while(i < word.length()){
            if (Character.isAlphabetic(word.charAt(i))) {i++; continue;}
            StringBuilder sb = new StringBuilder();
            if (word.charAt(i) != '0') sb.append(word.charAt(i));
            while(i < word.length() - 1 && Character.isDigit(word.charAt(i + 1)))
                if (word.charAt(++i) != '0' || sb.length() > 0)
                    sb.append(word.charAt(i));
            set.add(sb.length() == 0? "0" : sb.toString());
            i++;
        }

        return set.size();
    }
}
