package com.coffeeisoxygen.arraygame.model.player;

import java.util.List;

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
    public PlayerModel(String playerName, int playerEnergy, List<String> playerMovementList) {
        this.playerName = playerName;
        this.playerEnergy = playerEnergy;
        this.playerMovementList = playerMovementList;
        this.initializePlayer();
        this.playerStatus = PlayerStatus.ALIVE;
    }

    // contrsuctor dengan nilai nilai default
    private void initializePlayer() {
        this.playerScore = 0;
        this.playerPosRow = 0;
        this.playerPosCol = 0;
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

    // Setter
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setPlayerPosRow(int playerPosRow) {
        this.playerPosRow = playerPosRow;
    }

    public void setPlayerPosCol(int playerPosCol) {
        this.playerPosCol = playerPosCol;
    }

    public void setPlayerMovementList(List<String> playerMovementList) {
        this.playerMovementList = playerMovementList;
    }

    public void setPlayerStatus(PlayerStatus playerStatus) {
        this.playerStatus = playerStatus;
    }

    // Method
    public void addPlayerScore(int score) {
        this.playerScore += score;
    }

    public void decreasePlayerEnergy(int energy) {
        this.playerEnergy -= energy;
    }

    public void increasePlayerEnergy(int energy) {
        this.playerEnergy += energy;
    }

    public void movePlayer(String direction) {
        switch (direction.toUpperCase()) {
            case "U" -> this.playerPosRow -= 1;
            case "D" -> this.playerPosRow += 1;
            case "L" -> this.playerPosCol -= 1;
            case "R" -> this.playerPosCol += 1;
            case "S" -> this.playerEnergy += 10;
            default -> {
                // invalid input
            }
        }
        if (this.playerEnergy <= 0) {
            this.playerStatus = PlayerStatus.EXHAUSTED;
        }
        // Add other conditions to update playerStatus as needed
    }
    // TODO: ComeBack Here after setup a board , tile and sub class
    // List Of TODO :
    // ? [ ] mark : Memaksimalkan Separation of Concerns
    // ? [ ] mark : Mengintegrasikan Board atau Tile Interactions
    // ? [ ] mark : Memaksimlkan Single Responsibility Principle
    // ! [ ] fix : Meningkatkan Pengelolaan Energi, Status, dan Penyederhanaan
    // Setter
    /*
     * Membuat Interface untuk PlayerMovementHandler atau GameEventHandler jika
     * nantinya ingin membuat variasi handler untuk event yang lebih kompleks.
     * Menyiapkan Unit Test untuk PlayerController sehingga memastikan logika
     * pergerakan dan interaksi berjalan sesuai skenario game.
     */
}
