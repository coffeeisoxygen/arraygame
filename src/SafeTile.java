import com.coffeeisoxygen.arraygame.model.player.PlayerModel;
import com.coffeeisoxygen.arraygame.model.player.PlayerStatus;

public class SafeTile extends TileModel {
    public SafeTile(int row, int col) {
        super(row, col, "safe");
    }

    @Override
    public TileInteractionResult interact(PlayerModel player) {
        System.out.println("Player " + player.getPlayerName() + " is on safe tile at " + this.Tilerow + ", " + this.Tilecol);
        // Safe tile interaction: player remains alive, no energy or score change
        return new TileInteractionResult(PlayerStatus.ALIVE, 0, 0);
    }
}
