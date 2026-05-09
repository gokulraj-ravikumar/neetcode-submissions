class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;

        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);

            while (map.size() > k) {
                char charAtL = s.charAt(l);

                if (map.get(charAtL) == 1) {
                    map.remove(charAtL);
                } else {
                    map.put(charAtL, map.get(charAtL) - 1);
                }
                l++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
        }

        return maxLen;
    }
}
