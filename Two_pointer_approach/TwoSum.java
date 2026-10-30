package Two_pointer_approach;
import java.util.Arrays;
import java.util.Comparator;

public class TwoSum {
    public static int[] twoSumUnsorted(int[] nums, int target) {       
        int[][] numWithIndex = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            numWithIndex[i][0] = nums[i];
            numWithIndex[i][1] = i;
        }

        // Sort the 2D array based on the values (column 0)
        Arrays.sort(numWithIndex, Comparator.comparingInt(a -> a[0]));

        // Apply two-pointer technique
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int currentSum = numWithIndex[left][0] + numWithIndex[right][0];

            if (currentSum == target) {
                return new int[]{numWithIndex[left][1], numWithIndex[right][1]};
            } else if (currentSum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int target = 6;
        int[] result = twoSumUnsorted(nums, target);
        System.out.println("Original Indices: [" + result[0] + ", " + result[1] + "]");        
    }
}
