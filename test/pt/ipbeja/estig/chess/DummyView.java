/**
 * Gonçalo Candeias Amaro 17440 - DummyView
 */

package pt.ipbeja.estig.chess;

import pt.ipbeja.estig.chess.gui.View;
import pt.ipbeja.estig.chess.model.Position;

import java.util.List;

/**
 * The type Dummy view.
 */
public class DummyView implements View {
    @Override
    public void updateBoard() {

    }

    @Override
    public void highlightGreen(List<Position> possibleMoves, boolean set) {

    }

    @Override
    public void highlightYellow(List<Position> possibleTakes, boolean set) {

    }
}
