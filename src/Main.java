import com.coffeeisoxygen.arraygame.model.player.BoardModel;
import com.coffeeisoxygen.arraygame.model.player.PlayerModel;
import com.coffeeisoxygen.arraygame.model.player.PlayerControl;
// import com.coffeeisoxygen.arraygame.model.player.DangerousTile; // Ensure this import is correct or remove if not used

public class Main {
    private static final int BOARD_ROWS = 5;
    private static final int BOARD_COLS = 5;
    private static final int DANGEROUS_TILE_ROW = 3;
    private static final int DANGEROUS_TILE_COL = 3;
    private static final String PLAYER_NAME = "Player 1";
    private static final int PLAYER_ENERGY = 100;
    private static final String PLAYER_MOVEMENTS = "UDUD";
    private static final int PLAYER_INITIAL_ROW = 4;
    private static final int PLAYER_INITIAL_COL = 3;

    public static void main(String[] args) throws Exception {
        BoardModel board = createBoard();
        PlayerModel player = createPlayer();
        PlayerControl playerControl = new PlayerControl(board, player);

        playerControl.executeMoves();
        printPlayerStatus(player);
    }

    private static BoardModel createBoard() {
        BoardModel board = new BoardModel(BOARD_ROWS, BOARD_COLS);
        board.setTile(DANGEROUS_TILE_ROW, DANGEROUS_TILE_COL,
                new DangerousTile(DANGEROUS_TILE_ROW, DANGEROUS_TILE_COL));
        board.printBoard();
        return board;
    }

    private static PlayerModel createPlayer() {
        return new PlayerModel(PLAYER_NAME, PLAYER_ENERGY, PLAYER_MOVEMENTS, PLAYER_INITIAL_ROW, PLAYER_INITIAL_COL);
    }

    private static void printPlayerStatus(PlayerModel player) {
        System.out.println("Player status: " + player.getPlayerStatus());
        System.out.println("Player energy: " + player.getPlayerEnergy());
        System.out.println("Player score: " + player.getPlayerScore());
        System.out.println("Player position: " + player.getPlayerPosRow() + ", " + player.getPlayerPosCol());
    }
}