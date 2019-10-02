/**
 * Gonçalo Candeias Amaro 17440 - Position
 */

package pt.ipbeja.estig.chess.model;

/**
 * The type Position.
 */
public class Position {
    private final int line, col;

    private char colChar[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};

    /**
     * Instantiates a new Position.
     *
     * @param line the line
     * @param col  the col
     */
    public Position(int line, int col) {
        this.line = line;
        this.col = col;
    }

    @Override
    public String toString() {
        return "(" + line + ", " + col + ")";
    }

    /**
     * Gets line.
     *
     * @return the line
     */
    public int getLine() {
        return this.line;
    }

    /**
     * Gets col.
     *
     * @return the col
     */
    public char getCol() {
        return this.colChar[col];
    }

    /**
     * Col translate int.
     *
     * @param colChar the col char
     * @return the int
     */
    public int colTranslate(char colChar) {
        for (int line = 0; line < Model.SIZE; line++) {
            if (colChar == this.colChar[line]) {
                return line;
            }
        }
        return line;
    }
}
