/**
 * Gonçalo Candeias Amaro 17440 - Rook
 */

package pt.ipbeja.estig.chess.model.pieces;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import pt.ipbeja.estig.chess.model.Model;
import pt.ipbeja.estig.chess.model.Position;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Rook.
 */
public class Rook extends Pieces {

    private Model.PieceColour color;
    private Position position;
    private Model model;

    /**
     * Instantiates a new Rook.
     *
     * @param model    the model
     * @param position the position
     * @param color    the color
     */
    public Rook(Model model, Position position, Model.PieceColour color) {
        this.model = model;
        this.color = color;
        this.position = position;
    }

    @Override
    public boolean canMoveTo(int line, char colChar) {

        int col = position.colTranslate(colChar);
        if (this.model.notEmpty(line, col) && this.model.isInside(line, col)) {
            if (colChar == this.position.getCol()) {
                return true;
            } else if (line == this.position.getLine()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public ImageView getImage() {

        if (color == Model.PieceColour.WHITE) {
            return new ImageView(
                    new Image("resources/WhiteRook.png", 80, 80, false, false)
            );
        } else {
            return new ImageView(
                    new Image("resources/BlackRook.png", 80, 80, false, false)
            );
        }

    }

    @Override
    public void newPosition(Position position) {
        this.position = position;
    }

    @Override
    public Position getPosition() {
        return this.position;
    }

    @Override
    public String getText() {
        StringBuilder ret = new StringBuilder();
        if (this.color == Model.PieceColour.WHITE) {
            ret.append("B ");
        } else {
            ret.append("P ");
        }
        ret.append("T");
        return ret.toString();
    }

    @Override
    public Model.PieceColour getColor() {
        return this.color;
    }

    @Override
    public boolean canKill(int line, char colChar) {
        int col = position.colTranslate(colChar);
        if ((this.model.getPiece(line, col) != this.model.empty) && this.model.isInside(line, col) &&
                this.model.getPiece(line, col).getColor() != this.color) {
            if (colChar == this.position.getCol()) {
                return true;
            } else if (line == this.position.getLine()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Position> possibleMoves() {
        char colChar[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        List<Position> ret = new ArrayList<>();
        for (int l = 0; l < Model.SIZE; l++) {
            for (int c = 0; c < Model.SIZE; c++) {
                if (this.canMoveTo(l, colChar[c])) {
                    ret.add(new Position(l, c));
                }
            }
        }
        return ret;
    }

    @Override
    public List<Position> possibleTakes() {
        char colChar[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        List<Position> ret = new ArrayList<>();
        for (int l = 0; l < Model.SIZE; l++) {
            for (int c = 0; c < Model.SIZE; c++) {
                if (this.canKill(l, colChar[c])) {
                    ret.add(new Position(l, c));
                }
            }
        }
        return ret;
    }

}
