import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Gui extends JFrame {
    public class CheckersGUI extends JFrame {
        private JPanel boardPanel;
        private JButton[][] boardButtons;
        private Checkers checkers;

        public CheckersGUI(Checkers checkers) {
            this.checkers = checkers;
            boardPanel = new JPanel(new GridLayout(8, 8));
            boardButtons = new JButton[8][8];
            for (int row = 0; row < 8; row++) {
                for (int col = 0; col < 8; col++) {
                    boardButtons[row][col] = new JButton();
                    boardPanel.add(boardButtons[row][col]);
                    final int r = row;
                    final int c = col;
                    boardButtons[row][col].addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            // Handle button click event
                            // Call checkers.movePiece() method with (r, c) as destination coordinates
                        }
                    });
                }
            }
            updateBoard(); // Initialize the board
            add(boardPanel);
            pack();
            setTitle("Checkers");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
        }

        public void updateBoard() {
            Board board = checkers.getBoard();
            for (int row = 0; row < 8; row++) {
                for (int col = 0; col < 8; col++) {
                    Piece piece = board.getPiece(row, col);
                    if (piece == null) {
                        boardButtons[row][col].setIcon(null);
                    } else {
                        String iconName = (piece.getColor().getIsWhite() ? "white_" : "black_") + (piece.getIsKing() ? "king" : "piece");
                        boardButtons[row][col].setIcon(new ImageIcon(getClass().getResource("/images/" + iconName + ".png")));
                    }
                }
            }
        }
    }

}
