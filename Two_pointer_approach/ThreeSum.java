package Two_pointer_approach;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        
        // Step 1: Sort the array
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length; i++) {
            // Optimization: If the current number is positive, 
            // three positive numbers can never sum to 0.
            if (nums[i] > 0) {
                break;
            }
            
            // Step 2: Skip duplicates for the first element
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            // Step 3: Two-pointer setup
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int total = nums[i] + nums[left] + nums[right];
                
                if (total == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    
                    // Step 4: Skip duplicates for the second element
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    // Skip duplicates for the third element
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (total < 0) {
                    left++; // Sum is too small, move left pointer rightward
                } else {
                    right--; // Sum is too large, move right pointer leftward
                }
            }
        }
        
        return res;
    }
}
