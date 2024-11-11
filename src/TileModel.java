import com.coffeeisoxygen.arraygame.model.player.PlayerModel;

// This class will serve as the base class for tile models
public abstract class TileModel {
    protected int Tilerow;
    protected int Tilecol;
    protected String Tilename;

    // Constructor with optional tile name
    public TileModel(int row, int col) {
        this(row, col, "tile");
    }

    // Constructor with specified tile name
    // Example of polymorphism
    public TileModel(int row, int col, String name) {
        this.Tilerow = row;
        this.Tilecol = col;
        this.Tilename = name;
    }

    public abstract TileInteractionResult interact(PlayerModel player);

    public Object getTileType() {
        return this.Tilename;
    }
}
