package Two_pointer_approach;
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        
        while (left < right) {
            // Calculate the width between the two pointers
            int width = right - left;
            
            // The height of the water is limited by the shorter line
            int currentHeight = Math.min(height[left], height[right]);
            
            // Update maxArea if the current container holds more water
            int currentArea = width * currentHeight;
            maxArea = Math.max(maxArea, currentArea);
            
            // Move the pointer that has the shorter line
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return maxArea;
    }
}
