/**
 * Gonçalo Candeias Amaro 17440 - Model
 */

package pt.ipbeja.estig.chess.model;

import javafx.scene.image.ImageView;
import pt.ipbeja.estig.chess.gui.View;
import pt.ipbeja.estig.chess.model.pieces.*;

import java.io.File;
import java.util.List;

/**
 * The type Model.
 */
public class Model {

    /**
     * The constant SIZE.
     */
    public static final int SIZE = 8;

    private Pieces[][] status;
    private View view;
    private FileHandler fileHandler;
    /**
     * The Empty.
     */
    public Pieces empty;

    private Pieces selectedPiece;
    private boolean selection = false;
    private int turnCounter;

    /**
     * Instantiates a new Model.
     *
     * @param view the view
     */
    public Model(View view) {
        this.view = view;
        this.fileHandler = new FileHandler();
        this.turnCounter = 0;
        this.empty = new Empty();
        this.resetBoard();
    }

    /**
     * Trigger selection.
     *
     * @param trigger the trigger
     */
    public void triggerSelection(boolean trigger) {
        this.selection = trigger;
        System.out.println(trigger);
    }

    /**
     * Select piece.
     *
     * @param line the line
     * @param col  the col
     */
    public void selectPiece(int line, int col) {
        this.selectedPiece = this.getPiece(line, col);
        this.getSelected().getText();
    }

    /**
     * Gets selected.
     *
     * @return the selected
     */
    public Pieces getSelected() {
        return this.selectedPiece;
    }

    /**
     * Is selected boolean.
     *
     * @return the boolean
     */
    public boolean isSelected() {
        return this.selection;
    }

    private void resetBoard() {

        this.selectedPiece = this.empty;

        this.status = new Pieces[Model.SIZE][Model.SIZE];

        topRow();

        for (int col = 0; col < Model.SIZE; col++) {
            this.status[1][col] = new Pawn(this, new Position(1, col), PieceColour.BLACK);
        }

        for (int line = 2; line < 6; line++) {
            for (int col = 0; col < Model.SIZE; col++) {
                this.status[line][col] = this.empty;
            }
        }

        for (int col = 0; col < Model.SIZE; col++) {
            this.status[6][col] = new Pawn(this, new Position(6, col), PieceColour.WHITE);
        }

        downRow();

    }

    /**
     * Clear board for test.
     */
    public void clearBoardForTest() {
        for (int line = 0; line < Model.SIZE; line++) {
            for (int col = 0; col < Model.SIZE; col++) {
                this.status[line][col] = this.empty;
            }
        }
    }

    private void topRow() {
        this.status[0][0] = new Rook(this, new Position(0, 0), PieceColour.BLACK);
        this.status[0][1] = new Knight(this, new Position(0, 1), PieceColour.BLACK);
        this.status[0][2] = new Bishop(this, new Position(0, 2), PieceColour.BLACK);
        this.status[0][3] = new Queen(this, new Position(0, 3), PieceColour.BLACK);
        this.status[0][4] = new King(this, new Position(0, 4), PieceColour.BLACK);
        this.status[0][5] = new Bishop(this, new Position(0, 5), PieceColour.BLACK);
        this.status[0][6] = new Knight(this, new Position(0, 6), PieceColour.BLACK);
        this.status[0][7] = new Rook(this, new Position(0, 7), PieceColour.BLACK);
    }

    private void downRow() {
        this.status[7][0] = new Rook(this, new Position(7, 0), PieceColour.WHITE);
        this.status[7][1] = new Knight(this, new Position(7, 1), PieceColour.WHITE);
        this.status[7][2] = new Bishop(this, new Position(7, 2), PieceColour.WHITE);
        this.status[7][3] = new Queen(this, new Position(7, 3), PieceColour.WHITE);
        this.status[7][4] = new King(this, new Position(7, 4), PieceColour.WHITE);
        this.status[7][5] = new Bishop(this, new Position(7, 5), PieceColour.WHITE);
        this.status[7][6] = new Knight(this, new Position(7, 6), PieceColour.WHITE);
        this.status[7][7] = new Rook(this, new Position(7, 7), PieceColour.WHITE);
    }

    /**
     * Gets piece.
     *
     * @param line the line
     * @param col  the col
     * @return the piece
     */
    public Pieces getPiece(int line, int col) {
        return this.status[line][col];
    }

    /**
     * Gets image.
     *
     * @param line the line
     * @param col  the col
     * @return the image
     */
    public ImageView getImage(int line, int col) {
        this.status[line][col].getText();
        return this.status[line][col].getImage();
    }

    /**
     * Move piece.
     *
     * @param line the line
     * @param col  the col
     */
    public void movePiece(int line, int col) {

        System.out.println("moving");

        char colChar[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};

        if (this.selectedPiece.getColor() == PieceColour.WHITE && this.turnCounter % 2 != 0) {
            this.selectedPiece = this.empty;
            return;
        } else if ((this.selectedPiece.getColor() == PieceColour.BLACK && this.turnCounter % 2 == 0)) {
            this.selectedPiece = this.empty;
            return;
        } else if (this.getSelected().canMoveTo(line, colChar[col]) || this.getSelected().canKill(line, colChar[col])) {
            this.setPiece(this.getSelected().getPosition().getLine(), //get int
                    this.getSelected().getPosition().colTranslate(   //char to int
                            this.getSelected().getPosition().getCol() //get char
                    ), this.empty);
            this.setPiece(line, col, this.selectedPiece);
            this.fileHandler.register(this.turnCounter, this.assembleString(this.selectedPiece));
            this.selectedPiece = this.empty;
            this.turnCounter++;
        }
    }

    private String assembleString(Pieces piece) {
        StringBuilder ret = new StringBuilder();
        ret.append(piece.getText().charAt(2));
        ret.append(piece.getPosition().getCol());
        ret.append(piece.getPosition().getLine() + 1);
        return ret.toString();
    }

    /**
     * Sets piece.
     *
     * @param line  the line
     * @param col   the col
     * @param piece the piece
     */
    public void setPiece(int line, int col, Pieces piece) { //only public because test. should've been private

        System.out.println("setting");

        Pieces[][] ret = new Pieces[Model.SIZE][Model.SIZE];

        for (int l = 0; l < Model.SIZE; l++) {
            for (int c = 0; c < Model.SIZE; c++) {
                if (l == line && c == col) {
                    ret[l][c] = piece;
                    piece.newPosition(new Position(line, col));
                } else {
                    ret[l][c] = this.status[l][c];
                }
            }
        }

        this.status = ret;
    }

    /**
     * Is inside boolean.
     *
     * @param line the line
     * @param col  the col
     * @return the boolean
     */
    public boolean isInside(int line, int col) {
        return 0 <= line && line < Model.SIZE &&
                0 <= col && col < Model.SIZE;
    }

    /**
     * Time travel.
     *
     * @param file the file
     */
    public void timeTravel(File file) {
        int line;
        int col;
        List<Position> pastMoves = this.fileHandler.pastMoves(file);
        for (int i = 0; i < pastMoves.size(); i++) {
            line = pastMoves.get(i).getLine();
            col = pastMoves.get(i).colTranslate(
                    pastMoves.get(i).getCol()
            );
            this.movePiece(line, col);
        }

    }

    /**
     * The enum Piece colour.
     */
    public enum PieceColour {
        /**
         * White piece colour.
         */
        WHITE,
        /**
         * Black piece colour.
         */
        BLACK
    }

    /**
     * Not empty boolean.
     *
     * @param line the line
     * @param col  the col
     * @return the boolean
     */
    public boolean notEmpty(int line, int col) {
        if (this.status[line][col] == this.empty) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Get status pieces [ ] [ ].
     *
     * @return the pieces [ ] [ ]
     */
    public Pieces[][] getStatus() {
        return this.status;
    }
}
