/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {
  let minimum = Number.MAX_SAFE_INTEGER;
  let maxProfit = 0;
  prices.map((price) => {
    let currProfit = price - minimum;
    maxProfit = Math.max(maxProfit,currProfit);
    minimum = Math.min(price,minimum);
  })
  return maxProfit;
};