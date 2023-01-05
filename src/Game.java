
class Game implements All {

    public static void main(String[] args) throws Exception {

        Board board = new Board();

        board.initializeAll();
        board.parseFen("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1");
        board.printBoard();
        
        MoveList moveList = new MoveList();
        board.generateMoves(moveList);
        
        long s = System.nanoTime();
        Perft perftTester = new Perft(board);
        System.out.println(perftTester.perftDriver(6));
        System.out.println(System.nanoTime() - s);
    }
}

