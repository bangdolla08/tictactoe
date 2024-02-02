package org.tic.tac.toe;

public class TicTacToeService {
    private final Integer boardSize;

    private final CellStateEnum playerOne;
    private final CellStateEnum playerTwo;
    private final CellStateEnum[][] boardData;

    public TicTacToeService(Integer boardSize, CellStateEnum playerOne, CellStateEnum playerTwo) {
        this.boardSize = boardSize;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        if (isValidSize(boardSize))
            IoService.messageAndExitApps("please input an odd number that is more than 1");
        boardData = new CellStateEnum[boardSize][boardSize];
        initializeBoard();
        displayBoard();
        makeMove(playerOne);
    }

    private void makeMove(CellStateEnum cellStateEnum) {
        int row, col;

        boolean playerMove = false;
        do {
            // Read row and column input from the player
            row = IoService.getInputInteger("Player " + cellStateEnum.getPlayerName() + ", " +
                    "enter your move (row): ", boardSize);
            col = IoService.getInputInteger("Player " + cellStateEnum.getPlayerName() + ", enter" +
                    " your move (coloumn): ", boardSize);

            // Make the move on the board
            playerMove = playerMove(row - 1, col - 1, cellStateEnum);
        } while (!playerMove);
        // Break the loop if the move is valid
        if (!isBoardFull() && !checkWin(cellStateEnum)) {
            displayBoard();
            if (cellStateEnum == playerOne) {
                makeMove(playerTwo);
            }
            if (cellStateEnum == playerTwo) {
                makeMove(playerOne);
            }

        } else if (isBoardFull()) {
            System.out.println("Wawww the board is full");
        } else if (checkWin(cellStateEnum)) {
            System.out.println("Congraturation you win broo " + cellStateEnum.getPlayerName());
        } else {
            System.out.println("Invalid move. Try again.");
        }
    }

    public boolean isBoardFull() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (boardData[i][j] == CellStateEnum.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean playerMove(Integer row, Integer col, CellStateEnum cellStateEnum) {
        boolean validMove = isValidMove(row, col) && boardData[row][col] == CellStateEnum.EMPTY;
        if (validMove) {
            boardData[row][col] = cellStateEnum;
        } else {
            System.out.println("Invalid move. Try again.");
        }
        return validMove;
    }

    public boolean checkWin(CellStateEnum player) {
        // Check rows and columns
        for (int i = 0; i < boardSize; i++) {
            boolean rowWin = true;
            boolean colWin = true;
            for (int j = 0; j < boardSize; j++) {
                if (boardData[i][j] != player) {
                    rowWin = false;
                }
                if (boardData[j][i] != player) {
                    colWin = false;
                }
            }
            if (rowWin || colWin) {
                return true;
            }
        }

        // Check diagonals
        boolean diagonal1Win = true;
        boolean diagonal2Win = true;
        for (int i = 0; i < boardSize; i++) {
            if (boardData[i][i] != player) {
                diagonal1Win = false;
            }
            if (boardData[i][boardSize - 1 - i] != player) {
                diagonal2Win = false;
            }
        }

        return diagonal1Win || diagonal2Win;
    }

    public void makeMove(int row, int col, CellStateEnum player) {
        if (isValidMove(row, col) && boardData[row][col] == CellStateEnum.EMPTY) {
            boardData[row][col] = player;
        } else {
            System.out.println("Invalid move. Try again.");
        }
    }

    // Method to check if a move is valid
    private boolean isValidMove(int row, int col) {
        return row >= 0 && row < boardSize && col >= 0 && col < boardSize;
    }

    public void displayBoard() {
        System.out.print("  ");
        for (int col = 1; col <= boardSize; col++) {
            System.out.print("|" + col + "  ");
        }
        System.out.println();

        for (int i = 0; i < boardSize; i++) {
            System.out.print(i + 1 + " |");
            for (int j = 0; j < boardSize; j++) {
                if (j > 0) {
                    System.out.print("|");
                }
                System.out.print(" " + boardData[i][j].toString() + " ");
            }
            System.out.println();
            if (i < boardSize - 1) {
                for (int k = 0; k < boardSize * 4 - 1; k++) {
                    System.out.print("-");
                }
                System.out.println();
            }
        }
    }

    public void initializeBoard() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                this.boardData[i][j] = CellStateEnum.EMPTY;
            }
        }
    }


    public boolean isValidSize(Integer ticTacToeSize) {
        return ticTacToeSize % 2 == 0;
    }

}
