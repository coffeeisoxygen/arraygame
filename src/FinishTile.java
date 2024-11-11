import com.coffeeisoxygen.arraygame.model.player.PlayerModel;
import com.coffeeisoxygen.arraygame.model.player.PlayerStatus;

public class FinishTile extends TileModel {
    public FinishTile(int row, int col) {
        super(row, col, "finish");
    }

    @Override
    public TileInteractionResult interact(PlayerModel player) {
        System.out.println("Player " + player.getPlayerName() + " is on finish tile at " + this.Tilerow + ", " + this.Tilecol);
        // Finish tile interaction: player wins, no energy change, score increases
        return new TileInteractionResult(PlayerStatus.WIN, 0, 100); // Example score increase
    }
}
