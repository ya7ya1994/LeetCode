package Leetcode.challenge.Algorithms;

import java.util.Arrays;
import java.util.HashSet;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            HashSet<Character> rows = new HashSet<>();
            HashSet<Character> columns = new HashSet<>();

            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != '.' && !rows.add(board[i][j]))
                    return false;
                if (board[j][i] != '.' && !columns.add(board[j][i]))
                    return false;
            }
        }

        for (int i = 0; i < board.length; i += 3) {
            for (int j = 0; j < board.length; j += 3) {
                HashSet<Character> cubeCells = new HashSet<>();
                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j + 3; l++) {
                        if (board[k][l] != '.' && !cubeCells.add(board[k][l]))
                            return false;
                    }
                }
            }
        }
        return true;
    }
}












/*
questions(id int
         ,question varchar(1000)
         ,tag varchar(20)
         ,userID int
         ,)

*/