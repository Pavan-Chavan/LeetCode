/**
 * @param {number[]} heights
 * @return {number[]}
 */
var canSeePersonsCount = function(heights) {
  let stack = []
  let answer = new Array(heights.length).fill(0);
  for (let i = 0; i < heights.length; i++) {
    while (stack.length && heights[stack.at(-1)] <= heights[i]) {
      let stackTop = stack.pop();
      answer[stackTop] += 1;
    }
    
    if (stack.length) {
      answer[stack.at(-1)] += 1;
    }
    stack.push(i);
  }
  return answer;
};
