class Solution {
public:
    int atMost(vector<int>& nums, int k)
    {
        int left = 0;
        int right = 0;
        int ans = 0;

        for(right = 0; right < nums.size(); right++)
        {
            k -= nums[right];
            while(k < 0)
            {
                k += nums[left];
                left++;
            }
            ans += right - left + 1;
        }
        return ans;
    }
    int numberOfSubarrays(vector<int>& nums, int k) {
        for(int i = 0; i < nums.size(); i++)
        {
            if(nums[i] % 2 == 1) nums[i] = 1;
            else nums[i] = 0;
        }
        return atMost(nums, k) - atMost(nums, k - 1);
    }
};