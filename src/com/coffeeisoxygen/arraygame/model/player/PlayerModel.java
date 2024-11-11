package com.coffeeisoxygen.arraygame.model.player;

import java.util.List;
import java.util.stream.Collectors;

public class PlayerModel {

    private String playerName;
    private int playerScore;
    private int playerEnergy;
    private int playerPosRow;
    private int playerPosCol;
    private boolean playerIsAlive;
    private List<String> playerMovementList;
    private PlayerStatus playerStatus;

    // Constructor
    public PlayerModel(String playerName, int playerEnergy, String playerMovements, int initialRow, int initialCol) {
        this.playerName = playerName;
        this.playerEnergy = playerEnergy;
        List<String> playerMovementCharsList = playerMovements.chars()
                                                 .mapToObj(c -> String.valueOf((char) c))
                                                 .collect(Collectors.toList());
        this.playerMovementList = playerMovementCharsList;
        this.initializePlayer(initialRow, initialCol);
        this.playerStatus = PlayerStatus.ALIVE;
    }

    // contrsuctor dengan nilai nilai default
    private void initializePlayer(int initialRow, int initialCol) {
        this.playerScore = 0;
        this.playerPosRow = initialRow; // Start at the specified initial row
        this.playerPosCol = initialCol; // Start at the specified initial column
        this.playerIsAlive = true;
    }

    // Getter
    public String getPlayerName() {
        return playerName;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public int getPlayerEnergy() {
        return playerEnergy;
    }

    public int getPlayerPosRow() {
        return playerPosRow;
    }

    public int getPlayerPosCol() {
        return playerPosCol;
    }

    public boolean isPlayerIsAlive() {
        return playerIsAlive;
    }

    public List<String> getPlayerMovementList() {
        return playerMovementList;
    }

    public PlayerStatus getPlayerStatus() {
        return playerStatus;
    }

    // Private Setters - Diakses hanya oleh PlayerControl
    private void setPlayerPosRow(int playerPosRow) {
        this.playerPosRow = playerPosRow;
    }

    private void setPlayerPosCol(int playerPosCol) {
        this.playerPosCol = playerPosCol;
    }

    private void setPlayerStatus(PlayerStatus playerStatus) {
        this.playerStatus = playerStatus;
    }

    private void setPlayerIsAlive(boolean playerIsAlive) {
        this.playerIsAlive = playerIsAlive;
    }

    private void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }

    private void setPlayerEnergy(int playerEnergy) {
        this.playerEnergy = playerEnergy;
    }

    // Methods to be used by PlayerControl
    public void updatePlayerScore(int score) {
        this.playerScore += score;
    }

    public void updatePlayerEnergy(int energy) {
        this.playerEnergy += energy;
    }

    public void updatePlayerStatus(PlayerStatus status) {
        this.playerStatus = status;
    }

    public void updatePlayerIsAlive(boolean isAlive) {
        this.playerIsAlive = isAlive;
    }

    public void updatePlayerPosition(int row, int col) {
        setPlayerPosRow(row);
        setPlayerPosCol(col);
    }
}
