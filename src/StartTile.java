import com.coffeeisoxygen.arraygame.model.player.PlayerModel;
import com.coffeeisoxygen.arraygame.model.player.PlayerStatus;

public class StartTile extends TileModel {
    public StartTile(int row, int col) {
        super(row, col, "start");
    }

    @Override
    public TileInteractionResult interact(PlayerModel player) {
        System.out.println("Player " + player.getPlayerName() + " is on start tile at " + this.Tilerow + ", " + this.Tilecol);
        // Example interaction result
        return new TileInteractionResult(PlayerStatus.ALIVE, 0, 0);
    }

}
