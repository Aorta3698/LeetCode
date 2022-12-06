public class Codec {

    Random random = new Random();
    char[] k = new char[10];
    String key = "";

    public String encode(List<String> strs) {
        if (key.isEmpty()){
            for (int i = 0; i < 10; i++){
                k[i] = (char)(random.nextInt(26) + 'a');
            }
            key = String.valueOf(k);
        }
        StringBuilder sb = new StringBuilder();
        for (String s : strs){
            sb.append(s);
            sb.append(key);
        }
        sb.setLength(sb.length() - key.length());
        return sb.toString();
    }

    public List<String> decode(String s) {
        return Arrays.stream(s.split(key, -1)).toList();
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
