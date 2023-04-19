/**
 * This class creates the board for the game, and lets players access the board to move the pieces
 */
public class Board {

    /**
     * Sets the size of the board
     */
    private final int SIZE = 8;
    /**
     * Arraylist that stores the board (8x8 board)
     */
    private char[][] board = new char[SIZE][SIZE];
    /**
     * Represents current player
     */
    private Player currentPlayer;
    /**
     * Represents white player
     */
    private Player whitePlayer;
    /**
     * represents black player
     */
    private Player blackPlayer;

    /**
     * Constructor which creates an empty board
     */
    public Board (){

    }

    /**
     * Returns the piece at a specific location
     * @param row Passes the piece's row number
     * @param col Passes the piece's column number
     * @return The piece at a specific location
     */
    public Piece getPiece(int row, int col) {
        return null;

    }

    /**
     * Moves a piece, taking the coordinates of where it was to where it is going
     * @param player Passes current player
     * @param fromRow Passes the current row number
     * @param fromCol Passes the current column number
     * @param toRow Passes the desired row number
     * @param toCol Passes the desired column number
     */

    public void movePiece(Player player, int fromRow, int fromCol, int toRow, int toCol){

    }

    /**
     * Determines whether a move is valid or not
     * @return Boolean depending on if the move is valid
     */
    public boolean isValid() {
        return false;
    }
}
