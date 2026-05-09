class Solution {

    public String encode(List<String> strs) {
        StringBuilder str = new StringBuilder();

        for (String s : strs) {
            int len = s.length();
            String id = len + "#";
            str.append(id).append(s);
        }
        return str.toString();
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        int start = 0;

        while (start < str.length()) {
            int end = str.indexOf('#', start);
            int len = Integer.parseInt(str.substring(start, end));

            start = end + 1;
            end = start + len;
            list.add(str.substring(start, end));
            start = end;
        }

        return list;
    }
}
