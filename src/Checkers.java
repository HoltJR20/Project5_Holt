import java.util.Scanner;
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
        Player w = new Player(new Color(true));
        Player b = new Player(new Color(false));
        String playerColor = new String("");
        Piece currentPiece;

        setBoard(new Board(w, b));
        getBoard().setCurrentPlayer(b);



        while (!getIsEndGame()) {
            if (getBoard().getCurrentPlayer().getColor().getIsWhite() == true) {
                playerColor = "White";
            } else {
                playerColor = "Black";
            }
            Scanner scn = new Scanner(System.in);
            System.out.print("Enter piece index: ");
            int pieceIndex = scn.nextInt();
            System.out.println("Enter row to move to: ");
            int toRow = scn.nextInt();
            System.out.println("Enter column to move to: ");
            int toCol = scn.nextInt();

            currentPiece = getBoard().getCurrentPlayer().getPieces().get(pieceIndex);

            if (getBoard().movePiece(currentPiece, toRow, toCol)) {
                if (getBoard().getCurrentPlayer().getColor().getIsWhite()) {
                    if (b.getPieces().size() < 1) {
                        setIsEndGame(true);
                        setWinner(getBoard().getCurrentPlayer());
                    } else {
                        if (toRow == 0 && !currentPiece.getIsKing()) {
                            currentPiece.setIsKing(true);
                        }
                        getBoard().setCurrentPlayer(b);
                    }
                } else {
                    if (w.getPieces().size() < 1) {
                        setIsEndGame(true);
                        setWinner(getBoard().getCurrentPlayer());
                    } else {
                        if (toRow == 7 && !currentPiece.getIsKing()) {
                            currentPiece.setIsKing(true);
                        }
                        getBoard().setCurrentPlayer(w);
                    }

                }
            } else {
                System.out.println("Invalid move. Try Again.");
            }
        }
        System.out.println("Game over." + getWinner().getColor() + " wins.");
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

    /**
     * Setter for the winner of the game
     * @param winner
     */
    public void setWinner(Player winner) {
        this.winner = winner;
    }

    /**
     * setter for the board
     * @param board
     */
    public void setBoard(Board board) {
        this.brd = board;
    }

    /**
     * getter for the board
     * @return
     */
    public Board getBoard() { return brd; }
}
