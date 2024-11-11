import com.coffeeisoxygen.arraygame.model.player.PlayerModel;
import com.coffeeisoxygen.arraygame.model.player.PlayerStatus;

public class DangerousTile extends TileModel {
    public DangerousTile(int row, int col) {
        super(row, col, "dangerous");
    }

    @Override
    public TileInteractionResult interact(PlayerModel player) {
        System.out.println("Player " + player.getPlayerName() + " is on dangerous tile at " + this.Tilerow + ", " + this.Tilecol);
        // Dangerous tile interaction: player goes missing, no energy or score change
        return new TileInteractionResult(PlayerStatus.MISSING, 0, 0);
    }
}
