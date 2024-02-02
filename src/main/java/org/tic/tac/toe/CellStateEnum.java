package org.tic.tac.toe;

public enum CellStateEnum {
    EMPTY(" "),
    X("X"),
    O("O");


    private final String string;

    private String playerName;

    private CellStateEnum(String title) {
        string = title;
    }

    @Override
    public String toString() {
        return string;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
}
