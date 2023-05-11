/**
 * This class sets the pieces to a specific color and sees if they are a king or not
 */

public class Piece {
    /**
     * Refers to the color of a piece
     */
    private Color color;
    private int col;
    private int row;

    /**
     * Refers to whether a piece is a king or not
     */

    private boolean isKing;

    /**
     * A constructor for a certain piece
     * @param color Passes the color for a piece
     */

    public Piece(Color color) {
        setColor(color);
        setIsKing(false);
    }

    /**
     * Returns a specific color
     * @return color
     */

    public Color getColor() {
        return color;
    }

    /**
     * Setter for the color object
     * @param color A passed in color object
     */

    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Getter for the isKing variable
     * @return isKing, whether it's true or false
     */
    public boolean getIsKing() {
        return isKing;
    }

    /**
     * Setter for isKing variable
     * @param isKing True or false
     */
    public void setIsKing(boolean isKing) {
        this.isKing = isKing;
    }

    /**
     * Sets position of a piece based on the passed row and col number
     * @param row Row number
     * @param col Col number
     */
    public void setPosition(int row, int col) {
        setRow(row);
        setCol(col);
    }

    /**
     * Sets col number
     * @param col Specified col number
     */

    public void setCol(int col) {
        this.col = col;
    }

    /**
     * Sets row number
     * @param row Specified row number
     */
    public void setRow(int row) {
        this.row = row;
    }

    /**
     * Returns col number
     * @return col number
     */
    public int getCol() {return col;}
    /**
     * Returns row number
     * @return row number
     */
    public int getRow() {return row;}


}
