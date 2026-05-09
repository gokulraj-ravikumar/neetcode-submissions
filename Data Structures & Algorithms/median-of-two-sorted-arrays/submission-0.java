class Solution {
    // Binary Search approach:
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure arrA is the smaller array to optimize binary search
        int[] arrA = nums1.length <= nums2.length ? nums1 : nums2;
        int[] arrB = nums1.length <= nums2.length ? nums2 : nums1;

        int lenA = arrA.length;
        int lenB = arrB.length;
        int totalLen = lenA + lenB;
        int halfLen = totalLen / 2;

        // Use r = lenA to allow the cut to be after the last element
        int l = 0, r = lenA;
        while (l <= r) {
            int midA = l + (r - l) / 2;
            int midB = halfLen - midA;
            
            // Notice we use midA - 1 and midB - 1 for the left side
            int aLeft = (midA > 0) ? arrA[midA - 1] : Integer.MIN_VALUE;
            int aRight = (midA < lenA) ? arrA[midA] : Integer.MAX_VALUE;
            
            int bLeft = (midB > 0) ? arrB[midB - 1] : Integer.MIN_VALUE;
            int bRight = (midB < lenB) ? arrB[midB] : Integer.MAX_VALUE;

            if (aLeft <= bRight && bLeft <= aRight) { // found median
                if (totalLen % 2 == 0) {
                    return (double) (Math.max(aLeft, bLeft) + Math.min(aRight, bRight)) / 2;
                } else {
                    return (double) Math.min(aRight, bRight);
                }
            } else if (aLeft > bRight) {
                r = midA - 1;
            } else {
                l = midA + 1;
            }
        }
        
        return 0.0;
    }
}