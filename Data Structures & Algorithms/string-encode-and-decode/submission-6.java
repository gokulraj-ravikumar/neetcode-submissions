class Solution {

    public String encode(List<String> strs) {
        StringBuilder str = new StringBuilder();

        for (String s : strs) {
            str.append((char) s.length()).append(s);
        }

        return str.toString();
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();

        if (str.length() <= 0)
            return list;

        int i = 0;
        while (i < str.length()) {
            int len = str.charAt(i);
            int start = i + 1;
            int end = start + len;
            list.add(str.substring(start, end));
            i = end;
        }

        return list;
    }
}
