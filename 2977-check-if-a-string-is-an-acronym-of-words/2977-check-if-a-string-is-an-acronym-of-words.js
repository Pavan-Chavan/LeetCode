/**
 * @param {string[]} words
 * @param {string} s
 * @return {boolean}
 */
var isAcronym = function(words, s) {
    let res = "";
    words.map((word) => {
       res+=word[0];
    })
    return s===res;
};