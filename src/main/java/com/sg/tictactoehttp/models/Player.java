/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.tictactoehttp.models;

/**
 *
 * @author Joe Gonzalez
 */
public enum Player {
    Player1('X'),
    Player2('O');
    
    private char marker;
    
    private Player(char marker) {
        this.marker = marker;
    }
    
    public char getMarker(){
        return marker;
    }
}
