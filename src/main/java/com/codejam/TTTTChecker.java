package com.codejam;

import java.util.List;

public class TTTTChecker {

    /** Takes a tic-tac-toe-tokem game described by a List with 4 strings of length 4,
     * one for each line on the board. The input should be . X O or T
     * If any other input is sent an IllegalArgumentException will be thrown */
    public String check(List<String> input) {
        GameBoardHolder gameBoardHolder = parseGame(input);
        String[][] gameBoard = gameBoardHolder.gameBoard;
        if (isWinner(gameBoard, "X")) {
            return "X won";
        } else if (isWinner(gameBoard, "O")) {
            return "O won";
        }
        if (gameBoardHolder.numberOfBlanks == 0) {
            return "Draw";
        } else {
            return "Game has not completed";
        }
    }

    private boolean isWinner(String[][] gameBoard, String winner) {
        return isWinnerInRows(gameBoard, winner)
                || isWinnerInColumns(gameBoard, winner)
                || isWinnerDiagonally(gameBoard, winner);
    }


    private boolean isWinnerInRows(String[][] gameBoard, String winner) {
        for (String[] row : gameBoard) {
            if (isTOrParam(row[0], winner)
                    && isTOrParam(row[1], winner)
                    && isTOrParam(row[2], winner)
                    && isTOrParam(row[3], winner)) {
                return true;
            }
        }
        return false;
    }

    private boolean isWinnerInColumns(String[][] gameBoard, String winner) {
        for (int column = 0; column < 4; column++) {
            if (isTOrParam(gameBoard[0][column], winner)
                    && isTOrParam(gameBoard[1][column], winner)
                    && isTOrParam(gameBoard[2][column], winner)
                    && isTOrParam(gameBoard[3][column], winner)) {
                return true;
            }
        }
        return false;
    }

    private boolean isWinnerDiagonally(String[][] gameBoard, String winner) {
        boolean firstDiagonal = isTOrParam(gameBoard[0][0], winner)
                && isTOrParam(gameBoard[1][1], winner)
                && isTOrParam(gameBoard[2][2], winner)
                && isTOrParam(gameBoard[3][3], winner);

        boolean secondDiagonal = isTOrParam(gameBoard[0][3], winner)
                && isTOrParam(gameBoard[1][2], winner)
                && isTOrParam(gameBoard[2][1], winner)
                && isTOrParam(gameBoard[3][0], winner);
        return firstDiagonal || secondDiagonal;
    }

    private boolean isTOrParam(String toCheck, String param) {
        return param.equals(toCheck.replace("T", param));
    }


    private GameBoardHolder parseGame(List<String> input) {
        GameBoardHolder gameBoardHolder = new GameBoardHolder();

        if (input.size() != 4) {
            throw new IllegalArgumentException("Unexpected input expecting 4 lines got " + input.size());
        }
        int rowNumber = 0;
        for (String row : input) {
            char[] characters = row.toCharArray();
            if (characters.length != 4) {
                throw new IllegalArgumentException("Unexpected input expected 4 characters per line got " + characters.length);
            }
            int characterNumber = 0;
            for (char character : characters) {
                gameBoardHolder.gameBoard[rowNumber][characterNumber] = String.valueOf(character);
                if ('.' == character) {
                    gameBoardHolder.numberOfBlanks++;
                } else if (!(character == 'T' || character == 'X' || character== 'O')) {
                    throw new IllegalArgumentException("Unexpected input expecting [.TXO] got " + character);
                }
                characterNumber++;
            }
            rowNumber++;
        }
        return gameBoardHolder;
    }

    private class GameBoardHolder {
        public String[][] gameBoard = new String[4][4];;
        public int numberOfBlanks = 0;
    }
}
