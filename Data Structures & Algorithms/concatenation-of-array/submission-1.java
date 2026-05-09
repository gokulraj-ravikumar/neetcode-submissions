class Solution {
    public int[] getConcatenation(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len * 2];

        // public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
        System.arraycopy(nums, 0, ans, 0, len);
        System.arraycopy(nums, 0, ans, len, len);

        return ans;
    }
}