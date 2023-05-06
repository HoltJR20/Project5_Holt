/**
 * This class will start and end every game of checkers, accessing a board to do it
 */

public class Checkers {
    private Board brd;
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

        // create a new board
        setBoard(new Board(whitePlayer, blackPlayer));


        // begin the game, White player goes first
        // First, get players piece and the destination row & col

        //getBoard().movePiece(pc, toRow, toCol);

        // check for a winner after a move

        // check if a player needs to be Kinged
    }


    /**
     * Indicates whether the current game is finished or not
     * @return a true or false boolean
     */

    public boolean isEndGame() {
        return false;
    }

    /**
     * Getter for returning the winner
     * @return the Player who is the winner
     */

    public Player getWinner() {
        return null;
    }

    public void setBoard(Board board) {
        this.brd = board;
    }

    public Board getBoard() { return brd; }
}
