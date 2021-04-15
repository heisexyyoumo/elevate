package com.humorous.elevate.leetcode;


/**
 * 130. 被围绕的区域
 */
public class SurroundedArea {


    public static void main(String[] args) {
//        char[][] board = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        char[][] board = {{'O', 'O', 'O', 'O', 'X', 'X'}, {'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'O'}, {'O', 'X', 'O', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'O'}, {'O', 'X', 'O', 'O', 'O', 'O'}};
        new SurroundedArea().solve(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    boolean[][] visited;
    int[][] dire = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; //右 -> 下 -> 左 -> 上

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        if (m == 1 || n == 1) {
            return;
        }

        visited = new boolean[m][n];
        for (int j = 0; j < n; j++) {
            if (!visited[0][j] && board[0][j] == 'O') {
                dfs(0, j, board, m, n);
            }
        }
        for (int j = 0; j < n; j++) {
            if (!visited[m - 1][j] && board[m - 1][j] == 'O') {
                dfs(m - 1, j, board, m, n);
            }
        }
        for (int i = 0; i < m; i++) {
            if (!visited[i][0] && board[i][0] == 'O') {
                dfs(i, 0, board, m, n);
            }
        }
        for (int i = 0; i < m; i++) {
            if (!visited[i][n - 1] && board[i][n - 1] == 'O') {
                dfs(i, n - 1, board, m, n);
            }
        }


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }


    private void dfs(int x, int y, char[][] board, int m, int n) {
        visited[x][y] = true;
        for (int i = 0; i < dire.length; i++) {
            int newx = x + dire[i][0];
            int newy = y + dire[i][1];
            if (isArea(newx, newy, m, n) && board[newx][newy] == 'O' && !visited[newx][newy]) {
                dfs(newx, newy, board, m, n);
            }
        }
    }


    public boolean isArea(int x, int y, int m, int n) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
