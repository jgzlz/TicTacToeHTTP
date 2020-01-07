/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.tictactoehttp.service;

import com.sg.tictactoehttp.models.Move;
import org.springframework.stereotype.Service;

@Service
public class GameBoard {

    private char[][] board;

    public GameBoard() {
        initBoard();
    }

    public void setBoard(char[][] board) {
        this.board = board;
    }

    public void initBoard() {
        board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    public boolean checkWin() {
        boolean diagonal = ((checkRowCol(board[0][0], board[1][1], board[2][2]) == true) || (checkRowCol(board[0][2], board[1][1], board[2][0]) == true));
        return diagonal || checkColumnsForWin() || checkRowsForWin();

    }

    public boolean checkRowCol(char c1, char c2, char c3) {
        return ((c1 != '-') && (c1 == c2) && (c2 == c3));
    }

    private boolean checkColumnsForWin() {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(board[0][i], board[1][i], board[2][i]) == true) {
                return true;
            }
        }
        return false;
    }

    private boolean checkRowsForWin() {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(board[i][0], board[i][1], board[i][2]) == true) {
                return true;
            }
        }
        return false;
    }

    public boolean makeMove(Move move) {
        int row = move.getRow();
        int col = move.getCol();
        char marker = move.getPlayer().getMarker();

        if (board[row][col] == '-') {
            board[row][col] = marker;
            return true;
        } else {
            return false;
        }
    }

    public char[][] getBoard() {
        return board;
    }

}
