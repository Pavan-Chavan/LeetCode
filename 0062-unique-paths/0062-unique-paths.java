class Solution {
    public int uniquePaths(int m, int n) {
        int dp [][] = new int[m+1][n+1];
        return findPath(m,n,0,0,dp);
    }
    private int findPath(int m,int n, int i, int j,int dp[][]) {
        if(i>=m || j>=n) return 0;
        else if(i == m-1 && j == n-1) return 1;
        else {
            if(dp[i][j] != 0) return dp[i][j];
            return dp[i][j] = findPath(m,n,i+1,j,dp) + findPath(m,n,i,j+1,dp);
        }
    }
}