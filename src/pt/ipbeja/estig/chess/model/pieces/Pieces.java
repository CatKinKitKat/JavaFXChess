/**
 * Gonçalo Candeias Amaro 17440 - Pieces
 */

package pt.ipbeja.estig.chess.model.pieces;

import javafx.scene.image.ImageView;
import pt.ipbeja.estig.chess.model.Model;
import pt.ipbeja.estig.chess.model.Position;

import java.util.List;

/**
 * The type Pieces.
 */
public abstract class Pieces {

    private Model.PieceColour color;
    private Position position;

    /**
     * Can move to boolean.
     *
     * @param line    the line
     * @param colChar the col char
     * @return the boolean
     */
    public abstract boolean canMoveTo(int line, char colChar);

    /**
     * Gets image.
     *
     * @return the image
     */
    public abstract ImageView getImage();

    /**
     * New position.
     *
     * @param position the position
     */
    public abstract void newPosition(Position position);

    /**
     * Gets position.
     *
     * @return the position
     */
    public abstract Position getPosition();

    /**
     * Gets text.
     *
     * @return the text
     */
    public abstract String getText();

    /**
     * Gets color.
     *
     * @return the color
     */
    public abstract Model.PieceColour getColor();

    /**
     * Can kill boolean.
     *
     * @param line    the line
     * @param colChar the col char
     * @return the boolean
     */
    public abstract boolean canKill(int line, char colChar);

    /**
     * Possible moves list.
     *
     * @return the list
     */
    public abstract List<Position> possibleMoves();

    /**
     * Possible takes list.
     *
     * @return the list
     */
    public abstract List<Position> possibleTakes();

}
