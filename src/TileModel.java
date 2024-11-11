import com.coffeeisoxygen.arraygame.model.player.PlayerModel;

// class ini akan bertanggung jawab sebagai base class untuk tile model
public abstract class TileModel {
    protected int Tilerow;
    protected int Tilecol;
    protected String Tilename;

    // constructor with optional tile name
    public TileModel(int row, int col) {
        this(row, col, "tile");
    }

    // constructor with specified tile name
    // exmaple of polymorphism
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
