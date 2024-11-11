import com.coffeeisoxygen.arraygame.model.player.PlayerModel;
import com.coffeeisoxygen.arraygame.model.player.PlayerStatus;

public class DangerousTile extends TileModel {
    public DangerousTile(int row, int col) {
        super(row, col, "dangerous");
    }

    @Override
    public TileInteractionResult interact(PlayerModel player) {
        // Define interaction logic for dangerous tile
        return new TileInteractionResult(PlayerStatus.LOSE, 0, 0);
    }
}
