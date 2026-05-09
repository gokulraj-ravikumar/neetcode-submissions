class Solution {

    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();

        for (String str : strs) {
            int len = str.length();
            res.append(len).append("#");
            res.append(str);
        }

        System.out.println(res);

        return res.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int start = 0;

        while (start < str.length()) {
            int index = str.indexOf('#', start);

            int len = Integer.valueOf(str.substring(start, index));
            int nextIndex = index + len + 1;

            res.add(str.substring(index + 1, nextIndex));
            start = nextIndex;
        }

        return res;
    }
}
