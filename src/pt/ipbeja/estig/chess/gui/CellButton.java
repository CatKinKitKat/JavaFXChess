/**
 * Gonçalo Candeias Amaro 17440 - CellButton
 */

package pt.ipbeja.estig.chess.gui;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import pt.ipbeja.estig.chess.model.Position;

/**
 * The type Cell button.
 */
public class CellButton extends Button {
    private final Position position;
    private boolean color;

    /**
     * Instantiates a new Cell button.
     *
     * @param position the position
     */
    public CellButton(Position position) {
        this.position = position;
        this.setPrefSize(80, 80);
    }

    /**
     * Gets position.
     *
     * @return the position
     */
    public Position getPosition() {
        return this.position;
    }

    /**
     * Sets color.
     *
     * @param color the color
     */
    public void setColor(boolean color) {
        this.color = color;
        if (color) { //true for white
            this.setStyle("-fx-background-color:White; -fx-text-fill:Black; -fx-font-size:16");
        } else { //false for black
            this.setStyle("-fx-background-color:Black; -fx-text-fill:White; -fx-font-size:16");
        }
    }

    /**
     * Sets yellow.
     *
     * @param setUnset the set unset
     */
    public void setYellow(boolean setUnset) {
        if (setUnset) {
            this.setStyle("-fx-background-color:Yellow; -fx-text-fill:Black; -fx-font-size:16");
        } else {
            this.setColor(this.color);
        }
    }

    /**
     * Sets green.
     *
     * @param setUnset the set unset
     */
    public void setGreen(boolean setUnset) {
        if (setUnset) {
            this.setStyle("-fx-background-color:Green; -fx-text-fill:Black; -fx-font-size:16");
        } else {
            this.setColor(this.color);
        }
    }
}
