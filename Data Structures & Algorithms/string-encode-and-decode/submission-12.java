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
            int len = Integer.parseInt(str.substring(start, index));
            res.add(str.substring(index + 1, index + 1 + len));

            start = index + 1 + len;
        }

        return res;
    }
}
