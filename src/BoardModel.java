public class BoardModel {

    private int boardRows;
    private int boardCols;
    private int boardSize;
    private TileModel[][] boardTiles;

    public BoardModel(int boardRows, int boardCols) {
        this.boardRows = boardRows;
        this.boardCols = boardCols;
        this.boardSize = boardRows * boardCols;
        createBoard();
    }

    private void createBoard() {
        boardTiles = new TileModel[boardRows][boardCols];
        for (int i = 0; i < boardRows; i++) {
            for (int j = 0; j < boardCols; j++) {
                if (i == 0 && j == 0) {
                    boardTiles[i][j] = new FinishTile(i, j);
                } else if (i == boardRows - 1 && j == boardCols - 1) {
                    boardTiles[i][j] = new StartTile(i, j);
                } else {
                    boardTiles[i][j] = new RouteTile(i, j);
                }
            }
        }
    }

    public void setTile(int row, int col, TileModel tile) {
        if (row >= 0 && row < boardTiles.length && col >= 0 && col < boardTiles[0].length) {
            boardTiles[row][col] = tile;
        }
    }

    public TileModel getTile(int row, int col) {
        return boardTiles[row][col];
    }

    public int getBoardRows() {
        return boardRows;
    }

    public int getBoardCols() {
        return boardCols;
    }

    public int getBoardSize() {
        return boardSize;
    }

    public void printBoard() {
        for (int i = 0; i < boardRows; i++) {
            for (int j = 0; j < boardCols; j++) {
                System.out.print(((String) boardTiles[i][j].getTileType()).charAt(0) + " ");
            }
            System.out.println();
        }
    }
}
