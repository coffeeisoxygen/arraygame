import com.coffeeisoxygen.arraygame.model.player.*;

public class Main {
    public static void main(String[] args) {
        // Create a new board model
        BoardModel board = new BoardModel(5, 5);
        board.printBoard();
        // Create a new player model
        PlayerModel player = new PlayerModel("Player 1", 100, "lllllll", 4, 4);
        // Create a new player control
        PlayerControl playerControl = new PlayerControl(board, player);
        // Move the player
        playerControl.movePlayer(null);
        // Print player status
        System.out.println("Player status: " + player.getPlayerStatus());
        System.out.println("Player energy: " + player.getPlayerEnergy());
        System.out.println("Player score: " + player.getPlayerScore());
        // print player position
        System.out.println("Player position: " + player.getPlayerPosRow() + ", " + player.getPlayerPosCol());

    }
}
