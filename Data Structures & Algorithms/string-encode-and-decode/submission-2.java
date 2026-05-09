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

            if (len < 10)
                start += len + 2;
            else if (len < 100)
                start += len + 3;
            else if (len < 1000)
                start += len + 4;

            list.add(str.substring(end + 1, end + 1 + len));
        }

        return list;
    }
}
// 4#neet4#code4#love3#you
