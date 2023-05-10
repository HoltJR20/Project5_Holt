/**
 * This class will start and end every game of checkers, accessing a board to do it
 */

public class Checkers {
    private Board brd;
    private Player winner;
    private boolean isEndGame = false;
    /**
     * A constructor for the checkers class
     */
    public Checkers() {

    }

    /**
     * Enables gameplay/plays the game of Checkers
     */

    public void play() {
        // initiate the Players; including colors and # of pieces
        Player whitePlayer = new Player(new Color(true));
        Player blackPlayer = new Player(new Color(false));
        Piece currentPiece;

        // create a new board
        setBoard(new Board(whitePlayer, blackPlayer));
        // Black player always goes first
        getBoard().setCurrentPlayer(blackPlayer);

        /** Begin the game with a loop. The UI should execute this loop until there is a winner */
        while (!getIsEndGame()) {
            int pieceIndex = 0; // set to the index of the piece to move
            int toRow = 0; // set to the row to move the piece to
            int toCol = 0; // set to the column to move the piece to

            // Retrieve the piece to move
            currentPiece = getBoard().getCurrentPlayer().getPieces().get(pieceIndex);

            // Attempt to move the piece to the new location
            if (getBoard().movePiece(currentPiece, toRow, toCol)) {
                //  Logic to check for a winner, if not should it be kinged and set current Player
                if (getBoard().getCurrentPlayer().getColor().getIsWhite()) {
                    if (blackPlayer.getPieces().size() < 1) {
                        setIsEndGame(true);
                        setWinner(getBoard().getCurrentPlayer());
                    } else {
                        // check if a player needs to be Kinged
                        if (toRow == 0 && !currentPiece.getIsKing()) {
                            currentPiece.setIsKing(true);
                        }
                        getBoard().setCurrentPlayer(blackPlayer);
                    }
                } else {
                    if (whitePlayer.getPieces().size() < 1) {
                        setIsEndGame(true);
                        setWinner(getBoard().getCurrentPlayer());
                    } else {
                        // check if a player needs to be Kinged
                        if (toRow == 7 && !currentPiece.getIsKing())  {
                            currentPiece.setIsKing(true);
                        }
                        getBoard().setCurrentPlayer(whitePlayer);
                    }
                }
            } else {
                // The move was invalid
                System.out.println("Invalid move. Please try again.");
            }
        }
    }


    /**
     * Indicates whether the current game is finished or not
     * @return a true or false boolean
     */

    public boolean getIsEndGame() {
        return isEndGame;
    }

    public void setIsEndGame(boolean endOfGame) {
        this.isEndGame = endOfGame;
    }
    /**
     * Getter for returning the winner
     * @return the Player who is the winner
     */

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public void setBoard(Board board) {
        this.brd = board;
    }

    public Board getBoard() { return brd; }
}
