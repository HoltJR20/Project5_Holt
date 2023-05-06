import java.util.ArrayList;

/**
 * This class initializes which player is what color and the amount of pieces each player has left
 */
public class Player {
    /**
     * Represents the Player's piece color
     */
    private Color color;
    /**
     * Contains all the Player's pieces
     */
    private ArrayList<Piece> pieces = new ArrayList<>();

    /**
     * Sets which Player is white or black
     * @param color Passes a color object to be assigned to the Player
     */

    public Player(Color color) {
        this.color = color;
    }

    /**
     * Getter for returning the Player's piece color
     * @return Color object according to the current player
     */
    public Color getColor() {
        return null;
    }

    /**
     * Getter for returning the number of pieces a player has left
     * @return The number of pieces that remain for a player
     */

    public ArrayList<Piece> getPieces() {
        return null;
    }

    /**
     * Removes a piece from a certain player
     * @param p Passes a piece to be removed
     */

    public void removePiece(Piece p) {

    }
}
