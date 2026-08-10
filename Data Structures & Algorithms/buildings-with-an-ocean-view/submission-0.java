class Solution {
    public int[] findBuildings(int[] heights) {
        // the buildings which do not have next greater / equal to height can see ocean
        int n = heights.length;
        Stack<Integer> stack = new Stack<>(); // strictly decreasing

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[i] >= heights[stack.peek()]) {
                stack.pop();
            }
            stack.push(i);
        }

        int[] res = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }

        return res;
    }
}