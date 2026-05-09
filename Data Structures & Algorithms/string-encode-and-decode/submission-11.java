class Solution {

    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();

        for (String str : strs) {
            res.append(str.length()).append("#").append(str);
        }

        return res.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int start = 0;
        
        while (start < str.length()) {
            int index = str.indexOf("#", start);
            int len = Integer.valueOf(str.substring(start, index));
            res.add(str.substring(index + 1, index + len + 1));
            start = index + len + 1;
        }

        return res;
    }
}
