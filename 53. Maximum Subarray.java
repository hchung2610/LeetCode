class Solution {
    public int maxSubArray(int[] nums) {
        //the logic is to compare sum with the value of current index while iterating. If sum is bigger then assign 
        // sum to the dp array to store value, else reset the sum value with the value of current index. 
        int sum = 0;
        int max = nums[0]; 
        int[] dp = new int[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum >= nums[i]) {
                dp[i] = sum; 
            } else {
                dp[i] = nums[i];
                sum = dp[i];
               
            }
            max = Math.max(max, sum);
        }
        return max; 
    }
}