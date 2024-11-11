// Kelas PlayerModel
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
    private int movementIndex; // Tambahan index untuk track gerakan berikutnya

    // Constructor
    public PlayerModel(String playerName, int playerEnergy, String playerMovements, int initialRow, int initialCol) {
        this.playerName = playerName;
        this.playerEnergy = playerEnergy;
        this.playerMovementList = playerMovements.chars()
                                                 .mapToObj(c -> String.valueOf((char) c))
                                                 .collect(Collectors.toList());
        this.playerStatus = PlayerStatus.ALIVE;
        this.playerIsAlive = true;
        this.movementIndex = 0;
        this.initializePlayer(initialRow, initialCol);
    }

    // Method untuk menginisialisasi player di posisi awal
    private void initializePlayer(int initialRow, int initialCol) {
        this.playerScore = 0;
        this.playerPosRow = initialRow;
        this.playerPosCol = initialCol;
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

    public PlayerStatus getPlayerStatus() {
        return playerStatus;
    }

    public List<String> getPlayerMovementList() {

        // Return the list of player movements

        return playerMovementList;
    }

    // Method untuk mendapatkan gerakan berikutnya dari player
    public String nextMove() {
        if (movementIndex < playerMovementList.size()) {
            return playerMovementList.get(movementIndex++);
        } else {
            return null; // Jika sudah tidak ada gerakan
        }
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
