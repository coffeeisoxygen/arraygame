import com.coffeeisoxygen.arraygame.model.player.PlayerStatus;

public class TileInteractionResult {
    private final PlayerStatus status;
    private final int energyChange;
    private final int scoreChange;

    public TileInteractionResult(PlayerStatus status, int energyChange, int scoreChange) {
        this.status = status;
        this.energyChange = energyChange;
        this.scoreChange = scoreChange;
    }

    public PlayerStatus getStatus() {
        return status;
    }

    public int getEnergyChange() {
        return energyChange;
    }

    public int getScoreChange() {
        return scoreChange;
    }
}
