package com.humorous.elevate.leetcode;

import java.util.Arrays;

/**
 * 36. 有效的数独
 */

public class IsValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        boolean[] visited = new boolean[9];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (visited[board[i][j] - '1']) {
                    return false;
                } else {
                    visited[board[i][j] - '1'] = true;
                }
            }
            Arrays.fill(visited, false); // 重新将数组全部更新为false，再判断
        }

        for (int j = 0; j < board[0].length; j++) {
            for (int i = 0; i < board.length; i++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (visited[board[i][j] - '1']) {
                    return false;
                } else {
                    visited[board[i][j] - '1'] = true;
                }
            }
            Arrays.fill(visited, false); // 重新将数组全部更新为false，再判断
        }


        for (int k = 0; k < board.length; k += 3) {
            for (int p = 0; p < board.length; p += 3) {
                for (int i = k; i < k + 3; i++) {
                    for (int j = p; j < p + 3; j++) {
                        if (board[i][j] == '.') {
                            continue;
                        }
                        if (visited[board[i][j] - '1']) {
                            return false;
                        } else {
                            visited[board[i][j] - '1'] = true;
                        }
                    }
                }
                Arrays.fill(visited, false); // 重新将数组全部更新为false，再判断
            }

        }

        return true;

    }
}
