/**
 * This class creates the board for the game, and lets players access the board to move the pieces
 */
public class Board {

    /**
     * Sets the size of the board
     */
    private final int SIZE = 8;

    /**
     * Board varible
     */

    private Piece board[][] = new Piece[SIZE][SIZE];
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
    public Board (){  }

    /**
     * Constructor which sets the players and calls the new board method
     * @param whitePlayer Represents white player
     * @param blackPlayer Represents black player
     */

    public Board (Player whitePlayer, Player blackPlayer){
        setBlackPlayer(blackPlayer);
        setWhitePlayer(whitePlayer);
        newBoard();
    }

    /**
     * Creates a new board with each of the players' pieces initialized.
     */


    public void newBoard() {
        if (getBlackPlayer() != null && getWhitePlayer() != null) {
            if (getBlackPlayer().getPieces().size() != 12 && getWhitePlayer().getPieces().size() != 12) {
                //Initiate Black Player Pieces
                int col = 0;
                int row = 0;
                int piecesToAllocate = 12;
                while (piecesToAllocate > 0) {
                    for (; row < 3; row++) {
                        if (col == 8) {col = 1;}
                        if (col == 9) {col = 0;}
                        for (; col < SIZE; col+=2) {
                            getBlackPlayer().getPieces().add(new Piece(new Color(false)));
                            getBlackPlayer().getPieces().get(12 - piecesToAllocate).setPosition(row, col);
                            board[row][col] = getBlackPlayer().getPieces().get(12 - piecesToAllocate);
                            piecesToAllocate -= 1;
                        }
                    }
                }

                //Initiate White Player Pieces
                piecesToAllocate = 12;
                row = 5;
                while (piecesToAllocate > 0) {
                    for (; row < SIZE; row++) {
                        if (col == 8) {col = 1;}
                        if (col == 9) {col = 0;}
                        for (; col < SIZE; col+=2) {
                            getWhitePlayer().getPieces().add(new Piece(new Color(true)));
                            getWhitePlayer().getPieces().get(12 - piecesToAllocate).setPosition(row, col);
                            board[row][col] = getWhitePlayer().getPieces().get(12 - piecesToAllocate);
                            piecesToAllocate -= 1;
                        }
                    }
                }
            }
        }
    }

    /**
     * Setter for white player
     * @param white Passes white player
     */
    public void setWhitePlayer(Player white) {
        this.whitePlayer = white;
    }

    /**
     * Returns white player
     * @return whitePlayer
     */

    public Player getWhitePlayer() {
        return whitePlayer;
    }
    /**
     * Setter for current player
     * @param player Passes current player
     */
    public void setCurrentPlayer(Player player) {
        this.currentPlayer = player;
    }

    /**
     * Returns current player
     * @return currentPlayer
     */

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * Setter for black player
     * @param black Passes black player
     */

    public void setBlackPlayer(Player black) {
        this.blackPlayer = black;
    }

    /**
     * Returns black player
     * @return black player
     */

    public Player getBlackPlayer() {
        return blackPlayer;
    }

    /**
     * Returns column number
     * @param location The "col" number of a piece's location
     * @return numerical representation of the column location
     */

    public int getColumn(int location) {
        return (location-1) % SIZE;
    }

    /**
     * Returns row number
     * @param location The "row" number of a piece's location
     * @return numerical representation of the row location
     */

    public int getRow(int location) {
        return (location-1) / SIZE;
    }

    /**
     * Returns the piece at a specific location
     * @param row Passes the piece's row number
     * @param col Passes the piece's column number
     * @return The piece at a specific location
     */
    public Piece getPiece(int row, int col) {
        return board[row][col];
    }

    /**
     * Moves a piece, taking the coordinates of where it is going
     * @param pc Passes current piece
     * @param toRow Passes the desired row number
     * @param toCol Passes the desired column number
     * @return A boolean which is true when a piece was successfully moved, and false when otherwise
     */

    /**
     * Method for moving a piece (see comments below)
     * @param pc A specified piece
     * @param toRow The row number the piece is being moved to
     * @param toCol The col number the piece is being moved to
     * @return A boolean based off the move's success
     */

    public boolean movePiece(Piece pc, int toRow, int toCol){
        // find pc's current position (embedded in the piece)
        // validate move:  Black players can only move forward (increment); White players can only move backwards (decrement) UNLESS either is a king
        // Check if move takes the opponents piece:  increments/decrements by 2 on both the x & y-axis
        // set new location if successful move

        if (pc.getColor().getIsWhite()) {
            // White players can only decrement on the board  unless its a king
            if (toRow < pc.getRow() || pc.getIsKing()) {
                return executeUniversalMoveLogic(pc, toRow, toCol);
             } else {
                return false;
            }
        } else {
            // Black players can only increment on the board unless its a king
            if (toRow > pc.getRow() || pc.getIsKing()) {
                return executeUniversalMoveLogic(pc, toRow, toCol);
            } else {
                return false;
            }
        }
    }

    /**
     * Validates a player's move
     * @param pc A specified piece
     * @param toRow The row number the piece is being moved to
     * @param toCol The col number the piece is being moved to
     * @return True or false depending on if the move is valid
     */

    private boolean executeUniversalMoveLogic (Piece pc, int toRow, int toCol) {
        // Validate the move itself...how many rows & cols did they move?  Both must equal either 1 or 2
        int rowMoves = Math.abs(toRow - pc.getRow());
        int colMoves = Math.abs(toCol - pc.getCol());
        if (colMoves != rowMoves) {return false;}

        // Validate the destination cell is empty
        if (board[toRow][toCol] != null) {return false;}

        // Validate if they moved 2, did they jump and opponents piece?  if so, validate its existence and remove it from the board
        if (colMoves == 2) {
            if (toRow - pc.getRow() > 0) {
                if (toCol - pc.getCol() > 0) {
                    if (!removePieceFromBoard(pc, toRow-1, toCol-1)) { return false; }
                } else {
                    if (!removePieceFromBoard(pc, toRow-1, toCol+1)) { return false; }
                }
            } else {
                if (toCol - pc.getCol() > 0) {
                    if (!removePieceFromBoard(pc, toRow+1, toCol-1)) { return false; }
                } else {
                    if (!removePieceFromBoard(pc, toRow+1, toCol+1)) { return false; }
                }
            }
        }

        movePieceToDestination(pc, toRow, toCol);
        return true;
    }

    /**
     * Removes a piece from the board
     * @param pc A specified piece
     * @param row the piece's row
     * @param col the piece's col
     * @return True or false depending if the piece was successfully removed
     */
    private boolean removePieceFromBoard (Piece pc, int row, int col) {

        //Validate there is a piece to remove
        if (board[row][col] == null) { return false; }

        //Validate the piece to remove is not the same color (player isn't jumping their own piece)
        if (pc.getColor() == board[row][col].getColor()) {return false;}

        // Remove the piece from the opponent's list of pieces
        if (getCurrentPlayer().getColor().getIsWhite()) {
            for (int i = 0; i < getBlackPlayer().getPieces().size(); i++) {
                int rowToCheck = getBlackPlayer().getPieces().get(i).getRow();
                int colToCheck = getBlackPlayer().getPieces().get(i).getCol();
                if (rowToCheck == row && colToCheck == col) {
                    getBlackPlayer().getPieces().remove(i);
                }
            }
        } else {
            for (int i = 0; i < getWhitePlayer().getPieces().size(); i++) {
                int rowToCheck = getWhitePlayer().getPieces().get(i).getRow();
                int colToCheck = getWhitePlayer().getPieces().get(i).getCol();
                if (rowToCheck == row && colToCheck == col) {
                    getWhitePlayer().getPieces().remove(i);
                }
            }
        }

        board[row][col] = null;
        return true;
    }

    /**
     * Sets piece at a new destination if previous conditions passed
     * @param pc A specified piece
     * @param row The desired row
     * @param col The desired col
     */

    private void movePieceToDestination (Piece pc, int row, int col) {
        board[pc.getRow()][pc.getCol()] = null;
        board[row][col] = pc;
        pc.setRow(row);
        pc.setCol(col);
    }

}


