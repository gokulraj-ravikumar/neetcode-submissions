class Solution {
    public String encode(List<String> strs) {
        StringBuilder encodedString = new StringBuilder();

        for (String str : strs) {
            // len#actualStringlen#actualString.....
            int len = str.length();
            encodedString.append(len).append("#");
            encodedString.append(str);
        }

        return encodedString.toString();
    }

    public List<String> decode(String str) {
        List<String> decodedStrings = new ArrayList<>();

        int start = 0;
        while (start < str.length()) {
            int index = str.indexOf("#", start);
            int len = Integer.valueOf(str.substring(start, index));

            decodedStrings.add(str.substring(index + 1, index + len + 1));
            start = index + len + 1;
        }

        return decodedStrings;
    }
}
