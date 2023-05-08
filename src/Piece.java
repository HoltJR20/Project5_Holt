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

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean getIsKing() {
        return isKing;
    }

    public void setIsKing(boolean isKing) {
        this.isKing = isKing;
    }

    public void setPosition(int row, int col) {
        setRow(row);
        setCol(col);
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setRow(int row) {
        this.row = row;
    }
    public int getCol() {return col;}
    public int getRow() {return row;}


}
