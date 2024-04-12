# Day43-dp-part12

● 300.最长递增子序列 

第一种做法，dp状态转移，

dp[i]的含义是下标为i的数组的最长上升子序列长度

初始化为1，最长上升子序列为1

公式为，dp[i] = Math.max(dp[i], dp[j] + 1) j是每个下标小于i的数字

O(N^2), O(N)

第二种做法：

```
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int res = 0;
        for(int num : nums){
            int i = 0,j = res;
            while(i < j){
                int mid = i + (j - i) / 2;
                if(tails[mid] < num) i = mid + 1;
                else j = mid;
            }
            tails[i] = num;
            if(res == j) res++;
        }
        return res;
    }
}

/**
1.tails数组的定义：tails数组是用来存储当前找到的最长递增子序列的尾部元素。在任意时刻，tails[k]的值代表长度为k+1的最长递增子序列的尾部元素的最小值。
2.变量res表示当前发现的最长递增子序列的长度。
3.循环遍历nums数组：
对于每个元素num，使用二分查找在tails数组中找到num应该插入的位置，即tails数组中第一个大于等于num的元素的位置。
二分查找的范围是[0, res)，左闭右开，其中i是左边界，j是右边界。
4.二分查找过程：
计算中点m = (i + j) / 2。
如果tails[m] < num，则说明num应该在m之后的位置，因此更新左边界i = m + 1。
否则，num应该在m或之前的位置，因此更新右边界j = m。
5.更新tails数组：
找到的i即是num应该插入的位置。将tails[i]更新为num。
如果num的插入位置i等于当前递增子序列长度res，意味着num可以作为一个新的、更长的递增子序列的尾部，因此res自增1。
6.循环结束后，变量res即为最长递增子序列的长度。
 */

```

● 674. 最长连续递增序列 



● 718. 最长重复子数组  
