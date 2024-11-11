import com.coffeeisoxygen.arraygame.model.player.PlayerModel;
import com.coffeeisoxygen.arraygame.model.player.PlayerStatus;

public class RouteTile extends TileModel {
    public RouteTile(int row, int col) {
        super(row, col, "route");
    }

    @Override
    public TileInteractionResult interact(PlayerModel player) {
        System.out.println("Player " + player.getPlayerName() + " is on route tile at " + this.Tilerow + ", " + this.Tilecol);
        // Route tile interaction: player remains alive, no energy or score change
        return new TileInteractionResult(PlayerStatus.ALIVE, 0, 0);
    }
}
