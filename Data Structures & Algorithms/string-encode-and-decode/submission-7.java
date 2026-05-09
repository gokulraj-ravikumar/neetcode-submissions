class Solution {

    public String encode(List<String> strs) {
        StringBuilder str = new StringBuilder();

        for (String s : strs) {
            str.append(s.length()).append("#").append(s);
        }

        return str.toString();
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();

        int i = 0;

        while (i < str.length()) {
            int start = str.indexOf('#', i) + 1;
            int len = Integer.parseInt(str.substring(i, start - 1));
            int end = start + len;

            list.add(str.substring(start, end));
            i = end;
        }
        return list;
    }
}
