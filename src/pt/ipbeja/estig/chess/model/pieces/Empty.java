/**
 * Gonçalo Candeias Amaro 17440 - Empty
 */

package pt.ipbeja.estig.chess.model.pieces;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import pt.ipbeja.estig.chess.model.Model;
import pt.ipbeja.estig.chess.model.Position;

import java.util.List;

/**
 * The type Empty.
 */
public class Empty extends Pieces {

    private Position position;

    /**
     * Instantiates a new Empty.
     */
    public Empty() {
        this.position = null;
    }

    private static final Image EMPTY =
            new Image("/resources/Empty.png", 80, 80, false, false);

    @Override
    public boolean canMoveTo(int line, char colChar) {
        return false;
    }

    @Override
    public ImageView getImage() {
        return new ImageView(this.EMPTY);
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
        return ("   ");
    }

    @Override
    public Model.PieceColour getColor() {
        return null;
    }

    @Override
    public boolean canKill(int line, char colChar) {
        return false;
    }

    @Override
    public List<Position> possibleMoves() {
        return null;
    }

    @Override
    public List<Position> possibleTakes() {
        return null;
    }
}
