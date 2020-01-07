package com.sg.tictactoehttp.controllers;

import com.sg.tictactoehttp.models.Move;
import com.sg.tictactoehttp.service.GameBoard;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicTacToeController {

    private GameBoard gb;

    public TicTacToeController(GameBoard gb) {
        this.gb = gb;
    }

    @PostMapping("/makeMove")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<GameBoard> makeMove(@RequestBody Move move) {
        boolean success = gb.makeMove(move);
        boolean isWin = gb.checkWin();
        if(isWin){
             return new ResponseEntity<>(gb, HttpStatus.I_AM_A_TEAPOT);
        }
        if (!success) {
            return new ResponseEntity<>(null, HttpStatus.UNPROCESSABLE_ENTITY);
        }
        return new ResponseEntity<>(gb, HttpStatus.CREATED);
    }

    @GetMapping("/getBoard")
    @ResponseStatus(HttpStatus.FOUND)
    public char[][] getBoard() {
        return gb.getBoard();
    }

    @GetMapping("/resetBoard")
    @ResponseStatus(HttpStatus.RESET_CONTENT)
    public char[][] resetBoard() {
        gb.initBoard();
        return gb.getBoard();
    }

    @PostMapping("/setBoard")
    @ResponseStatus(HttpStatus.RESET_CONTENT)
    public char[][] resetBoard(char[][] board) {
        gb.setBoard(board);
        
        return gb.getBoard();
    }
}
