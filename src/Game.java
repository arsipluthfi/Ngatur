
class Game implements All {

    public static void main(String[] args) throws Exception {

        Board board = new Board();

        board.initializeAll();
        board.parseFen("r3k2r/pPppqpb1/bn2pnp1/3PN3/1p2P3/2N2Q1p/PPPBBPPP/R3K2R w KQkq - ");
                
        /*
        long s = System.nanoTime(), time;
        for (int i = 0; i < 100000000; i++) {
            board.copyBoard();
            board.parseFen("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1");
            MoveList moveList = new MoveList();
            board.generateMoves(moveList);
            board.restoreBoard();
        }
        time = System.nanoTime() - s;
        System.out.printf("Time taken %d seconds, %d milliseconds, %d microseconds, and %d nanoseconds\n", time / 1000000000, (time / 1000000) % 1000, (time / 1000) % 1000, time % 1000);
        */
        
        MoveList moveList = new MoveList();
        board.generateMoves(moveList);

        for (int move: moveList.list) {
            if (move != 0) {
                board.copyBoard();
                if (!board.makeMove(move)) {
                    continue;
                }
                board.makeMove(move);
                board.printBoard();
                while (System.in.read() != (int) '\n') {}
                board.restoreBoard();
            }
        }
    }
}

