import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Perft implements All {

    long nodes;
    Board board;

    void perftDriver(int depth) {

        if (depth == 0 && ++nodes != 0) {
            return;
        }

        MoveList moveList = new MoveList();
        board.generateMoves(moveList);

        for (int moves: moveList.list) {
            if (moves != 0) {

                long[] piecesCopy = new long[12];
                long[] occupancyCopy = new long[3];
                int sideCopy = board.side;
                int castlingCopy = board.castling;
                int enPassantCopy = board.enPassant;

                for (int i = 0; i < 12; i++) {
                    piecesCopy[i] = board.pieces[i];
                }

                for (int i = 0; i < 3; i++) {
                    occupancyCopy[i] = board.occupancy[i];
                }

                if (!board.makeMove(moves)) {
                    continue;
                }

                perftDriver(depth - 1);

                board.pieces = piecesCopy;
                board.occupancy = occupancyCopy;
                board.side = sideCopy;
                board.castling = castlingCopy;
                board.enPassant = enPassantCopy;
            }
        }
    }

    void parsePerftFile(int depth) {

        File file = new File("res/perft.txt");
        long s, t, positionNumber = 0;

        try (Scanner stream = new Scanner(file)) {

            while (stream.hasNextLine()) {
                String[] info = stream.nextLine().split(",");

                board.parseFen(info[0]);
                System.out.printf("\nPosition %d: %s\n", ++positionNumber, info[0]);
                board.printBoard();

                MoveList moveList = new MoveList();
                board.generateMoves(moveList);

                for (int i = 0; i++ < depth;) {
                    nodes = 0;
                    s = System.nanoTime();

                    perftDriver(i);
                    t = System.nanoTime() - s;

                    System.out.printf("Depth %d: %12d nodes visited, ", i , nodes);
                    System.out.printf("took %2d minutes, %2d seconds, %3d milliseconds, %3d microseconds, and %3d nanoseconds ", t / 60000000000L, (t / 1000000000L) % 60, (t / 1000000L) % 1000, (t / 1000L) % 1000, t % 1000);

                    if (nodes != Long.parseLong(info[i])) {
                        System.out.printf("(INCORRECT)\n");
                        return;
                    } else {
                        System.out.printf("(CORRECT)\n");
                    }
                }
            }

        } catch (FileNotFoundException e) {
            System.out.printf("File not found!");
        }

        System.out.printf("\nPerft test done! everything is in order.\n");
    }

    public Perft(Board board) {
        this.board = board;
    }
}
