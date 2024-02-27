package Arrays.BinarySearch;

/*
 * Find position of an element in a sorted array of infinite numbers
 * [https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-
 * numbers/]
 * 
 */

class FindElementInInfiniteArray {
    public static void main(String[] args) {
        int[] nums = { 1, 3, 5, 7, 9, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97,
                101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199,
                211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 331,
                337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457,
                461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557, 563, 569, 571, 577, 587, 593, 599,
                601, 607, 613, 617, 619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 683, 691, 701, 709, 719, 727, 733,
                739, 743, 751, 757, 761, 769, 773, 787, 797, 809, 811, 821, 823, 827, 829, 839, 853, 857, 859, 863, 877,
                881, 883, 887, 907, 911, 919, 929, 937, 941, 947, 953, 967, 971, 977, 983, 991, 997 };
        int target = 997;
        System.out.println(findPosition(nums, target));
    }

    static int findPosition(int[] nums, int target) {
        int[] range = findRange(nums, target);
        return binarySearch(nums, target, range[0], range[1]);
    }

    static int[] findRange(int[] nums, int target) {
        int start = 0;
        int end = 1;
        // Theoretically in infinite array there would be no need to check
        // if end index is within the bounds of array, as the array is infinite
        // and we wont be able to go out of array.
        // But Practically arrays are finite and we would have to check that the
        // end index is within bounds.
        while (end < nums.length && target > nums[end]) {
            start = end + 1;
            end = start * 2 + 1;
        }
        end = (end > nums.length - 1) ? end - end % nums.length - 1 : end;
        return new int[] { start, end };
    }

    static int binarySearch(int[] nums, int target, int start, int end) {
        if (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target)
                return mid;
            else if (target > nums[mid])
                return binarySearch(nums, target, mid + 1, end);
            else if (target < nums[mid])
                return binarySearch(nums, target, start, mid - 1);
        }
        return -1;
    }
}