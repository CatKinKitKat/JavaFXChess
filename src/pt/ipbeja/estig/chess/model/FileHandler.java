/**
 * Gonçalo Candeias Amaro 17440 - FileHandler
 */

package pt.ipbeja.estig.chess.model;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The type File handler.
 */
public class FileHandler {

    private int turn;
    private File file;

    private static final DateFormat sdf = new SimpleDateFormat("yyyy_MM_dd-HH_mm_ss");
    private Date date;
    private FileWriter writer;
    private FileReader reader;

    /**
     * Instantiates a new File handler.
     */
    public FileHandler() {
        this.newHistory();
        this.turn = 0;

        // creates a FileWriter Object
    }

    /**
     * Register.
     *
     * @param turnCounter the turn counter
     * @param moveText    the move text
     */
    public void register(int turnCounter, String moveText) {
        try {
            this.writer = new FileWriter(file, true);
            if (turnCounter % 2 == 0) {
                writer.write(this.turn + 1 + ".  " + moveText + "  ");
                writer.flush();
            } else {
                writer.write(moveText + "\n");
                writer.flush();
                this.turn++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void newHistory() {
        date = new Date();
        this.file = new File("history-" + sdf.format(date) + ".txt");
        try {
            this.file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Past moves list.
     *
     * @param file the file
     * @return the list
     */
    public List<Position> pastMoves(File file) {
        List<Position> ret = new ArrayList<>();
        char[] content = new char[550]; //50*(2+1+3+1+3+1)
        try {
            this.reader = new FileReader(file);
            this.reader.read(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int i = 4;
        int j = 0;
        int line = 0, col = 0;
        boolean found = false;

        char[] colCheck = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        char[] linecheck = {'1', '2', '3', '4', '5', '6', '7', '8'};

        while (content[i] != '\0') {

            for (int c = 0; c < colCheck.length; c++) {
                if (content[i] == colCheck[c]) {
                    col = c;
                }
            }
            for (int l = 0; l < linecheck.length; l++) {
                if (content[i] == linecheck[l]) {
                    line = l;
                    found = true;
                }
            }

            if (found) {
                found = false;
                ret.add(new Position(line, col));
            }

            if (content[i] == '\n') {
                j += 11;
                i = 4;
                i += j;
            } else {
                i++;
            }
        }
        return ret;
    }


}
