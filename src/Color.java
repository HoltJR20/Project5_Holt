/**
 * This class determine whether the piece is black or white
 */

public class Color {
    /**
     * Determines if the piece is white (true) or black (false)
     */
    private boolean isWhite = false;

    public Color () {
    }

    /**
     * A constructor for the Color class
     */
    public Color (boolean isWhite) {
        setIsWhite(isWhite);
    }

    public void setIsWhite(boolean isWhite) {
        this.isWhite = isWhite;
    }
    public boolean getIsWhite() {
        return isWhite;
    }

}
