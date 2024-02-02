package org.tic.tac.toe;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Boolean wantToPlayAgain=false;
        do {
            Integer rawTicTacToe = IoService.getInputInteger("Please enter the length and width of " +
                    "the tic tac toe");
            String playerOne =
                    IoService.getInputString("Please Enter the palyer name for " + CellStateEnum.O + " :");
            CellStateEnum cellStateO = CellStateEnum.O;
            cellStateO.setPlayerName(playerOne);
            String playerTwo =
                    IoService.getInputString("Please Enter the palyer name for " + CellStateEnum.X + " :");
            CellStateEnum cellStateX = CellStateEnum.X;
            cellStateX.setPlayerName(playerTwo);
            TicTacToeService ticTacToeService = new TicTacToeService(rawTicTacToe, cellStateO, cellStateX);

            wantToPlayAgain=IoService.isWantToRetry();

        }while (wantToPlayAgain);


    }
}
