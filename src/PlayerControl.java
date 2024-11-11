import com.coffeeisoxygen.arraygame.model.player.PlayerModel;
import com.coffeeisoxygen.arraygame.model.player.PlayerStatus;

public class PlayerControl {
    private BoardModel board;
    private PlayerModel player;

    public PlayerControl(BoardModel board, PlayerModel player) {
        this.board = board;
        this.player = player;
    }

    // Metode untuk mengupdate posisi pemain dengan pengecekan board
    private void updatePlayerPosition(int newRow, int newCol) {
        // Pastikan posisi berada dalam batas board
        if (newRow >= 0 && newRow < board.getBoardRows() && newCol >= 0 && newCol < board.getBoardCols()) {
            // Jika posisi valid, update posisi pemain
            player.updatePlayerPosition(newRow, newCol);
        } else {
            // Jika posisi di luar batas board
            player.updatePlayerStatus(PlayerStatus.FELL);
            player.updatePlayerIsAlive(false);
            System.out.println("Player fell off the board!");
        }
    }

    // Metode untuk menggerakkan pemain berdasarkan arah
    public void movePlayer(String direction) {
        // Check if player has enough energy
        if (player.getPlayerEnergy() <= 0) {
            player.updatePlayerStatus(PlayerStatus.EXHAUSTED);
            player.updatePlayerIsAlive(false);
            System.out.println("Player is exhausted!");
            return;
        }

        int newRow = player.getPlayerPosRow();
        int newCol = player.getPlayerPosCol();

        switch (direction.toUpperCase()) {
            case "U" -> newRow--;
            case "D" -> newRow++;
            case "L" -> newCol--;
            case "R" -> newCol++;
            case "S" -> {
                // Special case for recharging energy
                TileModel currentTile = board.getTile(newRow, newCol);
                if (currentTile instanceof SafeTile) {
                    player.updatePlayerEnergy(10);
                    System.out.println("Player recharged energy at safe tile.");
                } else {
                    player.updatePlayerStatus(PlayerStatus.LOSE);
                    player.updatePlayerIsAlive(false);
                    System.out.println("Player tried to recharge energy at a non-safe tile. Game over!");
                    return;
                }
                return; // No movement, just recharge
            }
            default -> {
                System.out.println("Invalid move direction!");
                return;
            }
        }

        // Update posisi pemain menggunakan metode updatePlayerPosition
        updatePlayerPosition(newRow, newCol);

        // Cek apakah pemain berada dalam batas board
        if (player.getPlayerStatus() == PlayerStatus.FELL) {
            return; // Player fell off the board, no further action needed
        }

        // Interaksi dengan tile tempat pemain berada
        TileModel currentTile = board.getTile(newRow, newCol);
        TileInteractionResult result = currentTile.interact(player);

        player.updatePlayerStatus(result.getStatus());
        player.updatePlayerEnergy(result.getEnergyChange());
        player.updatePlayerScore(result.getScoreChange());

        // Cek apakah energi pemain habis
        if (player.getPlayerEnergy() <= 0) {
            player.updatePlayerStatus(PlayerStatus.EXHAUSTED);
            player.updatePlayerIsAlive(false);
            System.out.println("Player is exhausted!");
        }
    }

    // Metode untuk menambah skor pemain
    public void addPlayerScore(int score) {
        player.updatePlayerScore(score);
    }

    // Metode untuk mengurangi energi pemain
    public void decreasePlayerEnergy(int energy) {
        player.updatePlayerEnergy(-energy);
    }

    // Metode untuk menambah energi pemain
    public void increasePlayerEnergy(int energy) {
        player.updatePlayerEnergy(energy);
    }

    // Metode untuk mencetak board
    public void printBoard() {
        board.printBoard();
    }

    // Getter untuk status pemain
    public PlayerStatus getPlayerStatus() {
        return player.getPlayerStatus();
    }

    // Getter untuk mengecek apakah pemain masih hidup
    public boolean isPlayerAlive() {
        return player.isPlayerIsAlive();
    }
}
