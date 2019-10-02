/**
 * Gonçalo Candeias Amaro 17440 - View
 */

package pt.ipbeja.estig.chess.gui;

import pt.ipbeja.estig.chess.model.Position;

import java.util.List;

public interface View {

    void updateBoard();

    void highlightGreen(List<Position> possibleMoves, boolean set);

    void highlightYellow(List<Position> possibleTakes, boolean set);
}
