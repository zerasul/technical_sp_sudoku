package com.spartacommodities.interviews.sudoku;

import java.util.*;

public class SudokuBoard {
    private final int[][] board;

    public SudokuBoard(int[][] board) {
        this.board = board;
    }

    // TODO add implementation
    public boolean isSolved() {

        boolean checkValueFlag =true;
        List<Set<Integer>> rows = new ArrayList<>();

        for (int i =0;i< board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]<1 || board[i][j]>9){
                    checkValueFlag=false;
                    break;
                }
            }
        }

        for (int i =0;i< board.length;i++){
            Set<Integer> row = new HashSet<>();
            for(int j=0;j<board[i].length;j++){
               row.add(board[i][j]);
            }
            rows.add(row);
        }
        boolean checkuniqueRows = rows.stream().noneMatch(integers -> integers.size()<9);


        List<Set<Integer>> cols = new ArrayList<>();
        for(int i = 0; i<board.length;i++){
            Set<Integer> col = new HashSet<>();
            for(int j=0;j<board[i].length;j++) {
                col.add(this.board[j][i]);
            }
            cols.add(col);
        }
        boolean checkUniqueCols = cols.stream().noneMatch(integers -> integers.size()<9);

        List<Set<Integer>> squares = new ArrayList<>();

        for(int z= 0;z<9;z++ ) {
            for (int i = 0; i < 3; i++) {
                Set<Integer> col = new HashSet<>();
                for (int j = 0; j < 3; j++) {
                    col.add(this.board[i][j]);
                }
                squares.add(col);
            }
        }

        return checkValueFlag && checkuniqueRows && checkUniqueCols;
    }
}
