import com.coffeeisoxygen.arraygame.model.player.PlayerStatus;

public class TileInteractionResult {
    private PlayerStatus status;
    private int energyChange;
    private int scoreChange;

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
