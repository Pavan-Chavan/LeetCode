class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        int [] upperDia = new int[2*n-1];
        int [] lowerDia = new int[2*n-1];
        int [] leftRow = new int[n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++) 
                board[i][j] = '.';
        List<List<String>> res = new ArrayList < List < String >> ();
        solve(0,board,upperDia,lowerDia,leftRow,res);
        return res;
    }
    private void solve(int col, char [][] board, int [] upperDia, int [] lowerDia, int [] leftRow, List<List<String>> res) {
        if(col == board.length) {
            res.add(contruct(board));
            return;
        }
        for(int i=0; i<board.length; i++) {
            if(leftRow[i] == 0 && lowerDia[i+col]==0 && upperDia[board.length-1+col-i]==0) {
                leftRow[i] = 1;
                lowerDia[i+col] = 1;
                upperDia[board.length-1+col-i] = 1;
                board[i][col] = 'Q';
                solve(col+1,board,upperDia,lowerDia,leftRow,res);
                board[i][col] = '.';
                leftRow[i] = 0;
                lowerDia[i+col] = 0;
                upperDia[board.length-1+col-i] = 0;
            }
        }
    }
    private List<String> contruct (char [][] board) {
        List<String> res = new LinkedList < String > ();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
}