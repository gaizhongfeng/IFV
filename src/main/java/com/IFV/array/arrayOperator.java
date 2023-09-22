package com.IFV.array;

import java.util.Arrays;

public class arrayOperator {

    /**
     * Merge two ordered arrays
     * @param nums1 array1
     * @param m     Number of elements in array 1
     * @param nums2 array2
     * @param n     Number of elements in array 2
     */
    public static void mergeOrderedArrays(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1;
        int tail = m + n - 1;
        int cur;
        while (p1 >= 0 || p2 >= 0) {
            if (p1 == -1) {
                cur = nums2[p2--];
            } else if (p2 == -1) {
                cur = nums1[p1--];
            } else if (nums1[p1] > nums2[p2]) {
                cur = nums1[p1--];
            } else {
                cur = nums2[p2--];
            }
            nums1[tail--] = cur;
        }
    }

    /**
     * Remove all elements with values equal to val and return the new length of the array after removal.
     * @param nums array
     * @param val   element
     * @return
     */
    public static int onlyRemoveElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            if (nums[left] == val) {
                nums[left] = nums[right - 1];
                right--;
            } else {
                left++;
            }
        }
        return left;
    }

    public static int[] removeElement(int[] nums, int val) {
        int resultLength = onlyRemoveElement(nums , val);
        return Arrays.copyOfRange(nums, 0, resultLength);
    }
}
