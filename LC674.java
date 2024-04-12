class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int res = 1;
        int ans = 1;
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] < nums[i + 1]){
                res ++;
                ans = Math.max(ans, res);
            }
            else{
                res = 1;
            }
        }
        return ans;
    }
}
//O(N), O(1)
