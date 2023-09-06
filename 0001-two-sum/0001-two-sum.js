/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    let hashSet = {};
    let result = [];
    for(let i=0;i<nums.length;i++) {
        if((target-nums[i]) in hashSet){
            result.push(hashSet[target-nums[i]]);
            result.push(i);
        }
        hashSet[nums[i]] = i;
    }
    return result;
};