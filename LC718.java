class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int[] dp = new int[nums2.length + 1];
        int res = 0;
        for(int i = 1; i <= nums1.length; i++){
            for(int j = nums2.length; j >= 1; j--){
                if(nums1[i - 1] == nums2[j - 1]){
                    dp[j] = dp[j - 1] + 1;
                }
                else dp[j] = 0;
                res = Math.max(res, dp[j]);
            }
        }
        return res;
    }
}
/**
O(NM), O(M)
dp[j] 长度为j的nums2和nums1的最长重复子串长度
if(nums1[i - 1] == nums2[j - 1]){
    dp[j] = dp[j - 1] + 1;
}
else dp[j] = 0
遍历顺序，先nums1再到序遍历nums[2]避免重读
 */
