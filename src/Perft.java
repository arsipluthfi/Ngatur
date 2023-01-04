public class Perft implements All {
    long nodes;

    void perftDriver(int depth) {

        if (depth != 0) {
            nodes++;
            return;
        }

    }
}
