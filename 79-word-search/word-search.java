class Solution {
    public static boolean exist(char[][]board,String word) {
        int bt[][] = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean check = find(i, j, 0, board, word,bt);
                    if (check) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
        public static boolean find ( int row, int col, int idx, char[][] board, String word,int bt[][]){

            if (idx == word.length()) return true;
            if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != word.charAt(idx) || bt[row][col] == 1)
                return false;
            bt[row][col] = 1;
            boolean up = find(row - 1, col, idx + 1, board, word, bt);
            boolean down = find(row + 1, col, idx + 1, board, word, bt);
            boolean left = find(row, col - 1, idx + 1, board, word, bt);
            boolean right = find(row, col + 1, idx + 1, board, word, bt);
            bt[row][col] = 0; 
            return up || down || left || right;
        }
}