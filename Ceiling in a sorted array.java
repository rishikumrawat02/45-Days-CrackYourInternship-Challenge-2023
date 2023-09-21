public class CeilingInSortedArray {
    // Function to find the ceiling value in a sorted array
    static int findCeiling(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int result = -1; // Initialize result to -1 (in case there is no ceiling)

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return arr[mid]; // Exact match found
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                result = arr[mid]; // Update result to potential ceiling
                right = mid - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 8, 10, 10, 12, 19 };
        int target = 5;

        int ceiling = findCeiling(arr, target);

        if (ceiling != -1) {
            System.out.println("Ceiling of " + target + " is " + ceiling);
        } else {
            System.out.println("No ceiling found for " + target);
        }
    }
}
